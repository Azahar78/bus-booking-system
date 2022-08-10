package com.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;



public class UpdateDao {

	public static int edit(HttpServletRequest req) {
		
		int updatedBus=0;
		
		try {
			Connection con = ConnectionProvider.getConnection();
			String updateQ = "update busdetails set arrTime=?,depTime=?,seat=?,price=? where busNumber=?";
			PreparedStatement pstm = con.prepareStatement(updateQ);
			pstm.setString(1,req.getParameter("arrivetime"));
			pstm.setString(2,req.getParameter("depttime"));
		    pstm.setInt(3,Integer.parseInt(req.getParameter("seatno")));
		    pstm.setInt(4,Integer.parseInt(req.getParameter("price")));
		    pstm.setInt(5,Integer.parseInt(req.getParameter("busno")));
		    
		    pstm.executeUpdate();
		    
		    updatedBus = Integer.parseInt(req.getParameter("busno"));
		    
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedBus;
		
	}
	
	

	public static int deleteBus(int busNo) {
		  
		int deletedBus=0;
		
		try {

			Connection con = ConnectionProvider.getConnection();
			String deleteQ ="DELETE FROM busdetails WHERE busNumber=?";
			
			PreparedStatement pstm  = con.prepareStatement(deleteQ);
			
			pstm.setInt(1, busNo);
			
			pstm.executeUpdate();
			deletedBus =busNo;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return deletedBus;

	}
	
	
	
	
}
