package com.bus.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.dao.UpdateDao;

@WebServlet(name = "DeleteBus", urlPatterns = { "/deletebus" })
public class DeleteBus extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		Cookie c[] = request.getCookies();

		if (c == null) {
			pw.println("LOGIN FIRST..!!");
			RequestDispatcher rd = request.getRequestDispatcher("adminlogin.html");
			rd.include(request, response);
			return;

		}
		
		
		else {
			
			boolean flag = false;
        	String fname ="";
        	
        	for(Cookie ck : c){
        		String tname = ck.getName();
        		if(tname.equals("firstname")) {
        			flag = true;
        			fname = ck.getValue();
        		}
        	}
        	
			/*
			 * if(flag){
			 * pw.println("<h1 style='text-align: center;color:orange;'> Welcome Admin : "
			 * +fname+"</h1>"); }
			 */
			
        	int Bus_No = Integer.parseInt(request.getParameter("busNO"));
        	
        	int Delete = UpdateDao.deleteBus(Bus_No);
        	
        	pw.println("<h2 style='text-align: center;color:orange;'> Bus NO : "+Delete+" Deleted Suuceesfully</h2>");
        	pw.println("<h3 style='text-align: center;color:orange;'> By Admin : "+fname+" </h3>");
        	RequestDispatcher rd = request.getRequestDispatcher("adminbus");
			rd.include(request, response);
			
			
		}

	}

}