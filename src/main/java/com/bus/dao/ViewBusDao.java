package com.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bus.entity.BusDetails;

public class  ViewBusDao {

	public ArrayList<BusDetails> busdetails = new ArrayList<BusDetails>();

	public ArrayList<BusDetails> getBuses() {

		try {
			
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from busdetails");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//Creating Object for Bus
				BusDetails busDetails = new BusDetails();
				busDetails.setBus_no(rs.getInt(1));
				busDetails.setBus_name(rs.getString(2));
				busDetails.setDepTime(rs.getString(3));
				busDetails.setArrTime(rs.getString(4));
				busDetails.setToStation(rs.getString(5));
				busDetails.setFstation(rs.getString(6));
				busDetails.setSeat(rs.getInt(7));
				busDetails.setPrice(rs.getInt(8));
				//BUS ADD TO LIST
				busdetails.add(busDetails);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return busdetails;
	}
	
<<<<<<< HEAD
	
	public ArrayList<BusDetails> getUserSearch(HttpServletRequest req){
		
		
		try {
			Connection con = ConnectionProvider.getConnection();

			String sql = "select * from busdetails where toStation=? and fStation=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, req.getParameter("source"));
			ps.setString(2, req.getParameter("destination"));

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				BusDetails userBus = new BusDetails();
				userBus.setBus_no(rs.getInt(1));
				userBus.setBus_name(rs.getString(2));
				userBus.setDepTime(rs.getString(3));
				userBus.setArrTime(rs.getString(4));
				userBus.setToStation(rs.getString(5));
				userBus.setFstation(rs.getString(6));
				userBus.setSeat(rs.getInt(7));
				userBus.setPrice(rs.getInt(8));
				busdetails.add(userBus);
				
			
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return busdetails;
		
	}
	
	
	public BusDetails getBus(int BusNo){
		BusDetails userBus = new BusDetails();
		
		try {
			
			Connection con = ConnectionProvider.getConnection();

			String sql = "select * from busdetails where busNumber=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1,BusNo);
		

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				
				userBus.setBus_no(rs.getInt(1));
				userBus.setBus_name(rs.getString(2));
				userBus.setDepTime(rs.getString(3));
				userBus.setArrTime(rs.getString(4));
				userBus.setToStation(rs.getString(5));
				userBus.setFstation(rs.getString(6));
				userBus.setSeat(rs.getInt(7));
				userBus.setPrice(rs.getInt(8));
				busdetails.add(userBus);
				
			
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBus;
		
	}
=======
>>>>>>> ae987dc1650709abf1c592bae2556c3e23f53124

}
