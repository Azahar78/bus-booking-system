package com.bus.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.dao.ViewBusDao;
import com.bus.entity.BusDetails;

@WebServlet(name = "ViewAdminBus",urlPatterns = {"/adminbus"})
public class ViewAdminBus extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
        Cookie cookies[]=req.getCookies();
        
        if(cookies== null) {
        	out.println("<h1> Login User  </h1>");
        	RequestDispatcher rd = req.getRequestDispatcher("adminlogin.html");
			rd.include(req, resp);
		
        }
        
 else {
        	boolean flag = false;
        	String fname ="";
        	
        	for(Cookie ck : cookies){
        		String tname = ck.getName();
        		if(tname.equals("firstname")) {
        			flag = true;
        			fname = ck.getValue();
        		}
        		
        	}
        	
        	if(flag){
        		out.println("<h1 style='text-align: center;color:orange;'> Welcome Admin : "+fname+"</h1>");
        	}
        	
        	ArrayList<BusDetails>busList = new ViewBusDao().getBuses();
        	if(busList.size() == 0){
        		out.println("<h1 style=\"text-align: center;color:orange;\"> Dear Admin : "+fname+" Your Search Deastination bus not available </h1>");
        		
        	}
        	
        	else {
        		for(BusDetails bD : busList){
        			
        			out.println("<h2 style='text-align: center;color:green;'>");
        			out.println("BUS No :- "+bD.getBus_no());
        			out.println("BUS NAME :- "+bD.getBus_name());
        			out.println("BUS ARR-TIME :- "+bD.getArrTime());
        			out.println("BUS DEP-TIME :- "+bD.getDepTime());
        			out.println("BUS From :- "+bD.getFstation());
        			out.println("BUS To Station :- "+bD.getToStation());
        			out.println("BUS SEAT :- "+bD.getSeat());
        			out.println("BUS PRICE :- "+bD.getPrice());
        			out.println("</h2>");
        			out.println("<h3 style='text-align: center;color:green;'><a href='editserv?busNO="+bD.getBus_no()+"'>Edit</a></h3>");
        			out.println("<h3 style='text-align: center;color:red;'><a href='deletebus?busNO="+bD.getBus_no()+"'>Delete</a></h3>");
        			out.println("<hr>");
        		}
        		out.println("<h1 style='text-align: center;color:red;'>Total No Of Buses Availabe : - "+busList.size()+"</h1>");
        	}
        	
        }
        
	}
}
