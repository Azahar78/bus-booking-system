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

import com.bus.dao.ViewBusDao;
import com.bus.entity.BusDetails;

@WebServlet(name = "EditServlet",urlPatterns = {"/editserv"})
public class EditServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		Cookie c[] = req.getCookies();
		
		int Bus_No = Integer.parseInt(req.getParameter("busNO"));
		
		BusDetails bus = new ViewBusDao().getBus(Bus_No);
		
		pw.println("<h3 style='text-align: center;color:green;'>");
			
		pw.println("BUS No :- "+bus.getBus_no());
		pw.println("BUS NAME  :- "+bus.getBus_name());
		pw.println("BUS ARR-TIME :- "+bus.getArrTime());
		pw.println("BUS DEP-TIME :- "+bus.getDepTime());
		pw.println("BUS From :- "+bus.getFstation());
		pw.println("BUS To :- "+bus.getToStation());
		pw.println("BUS SEAT :- "+bus.getSeat());
		pw.println("BUS PRICE :- "+bus.getPrice());
		pw.println("</h3>");
		pw.println("<hr>");
		
		pw.println("<form action='updateserv' method='get'>");
		pw.println("<input type='hidden' name='busno' value='"+bus.getBus_no()+"'>");
		pw.println("ArriveTime :<input type='text' name='arrivetime' value='"+bus.getArrTime()+"'>");
		pw.println("DepartureTime :<input type='text' name='depttime' value='"+bus.getDepTime()+"'>");
		pw.println("Seat Available :<input type='text' name='seatno' value='"+bus.getSeat()+"'>");
		pw.println("Price :<input type='text' name='price' value='"+bus.getPrice()+"'>");
		pw.println("<button type='submit'>Edit Bus</button>");
		pw.println("</form>");
		
		
	/*	DepartureTime :<input type="text" name="depttime">
		ArriveTime :<input type="text" name="arrivetime">
		Seat :<input type="number" name="seatno">
		Price :<input type="number" name="price">

		<input type="submit" value="ADD" style="text-align: center;">*/
		
		
		
		/*
		 * RequestDispatcher rd = req.getRequestDispatcher("Edit.html"); rd.include(req,
		 * resp);
		 */
		
		

		
		
		
	}

}
