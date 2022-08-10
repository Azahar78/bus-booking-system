package com.bus.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.dao.UpdateDao;


@WebServlet(name = "UpdateServlet",urlPatterns = {"/updateserv"})
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		Cookie c[]=req.getCookies();
		
		boolean flag = false;
    	String fname ="";
    	
    	for(Cookie ck : c){
    		String tname = ck.getName();
    		if(tname.equals("firstname")) {
    			flag = true;
    			fname = ck.getValue();
    		}
    	}
		
		
		
		
		int updateBus = UpdateDao.edit(req);
		
		pw.println("<h2 style='text-align: center;color:orange;'> Bus NO : "+updateBus+"Updated Suuceesfully</h2>");
		pw.println("<h3 style='text-align: center;color:orange;'> By Admin : "+fname+" </h3>");
		
		pw.println("<h2><a href='admin-dashboard.html'>Admin Dash Board</a></h2>");
		
		
		
		/*
		 * String arrtime = req.getParameter("depttime");
		 * 
		 * pw.println(" Arraive Time "+arrtime);
		 */
	
		  
		/*
		 * String BusName = req.getParameter("busname");
		 * 
		 * 
		 * int bno =(Integer)req.getAttribute("BusNO"); pw.println("<h3> Heelo </h3>");
		 * pw.println("<h2>"+BusName+"</h2>");
		 */
	
	}
}
