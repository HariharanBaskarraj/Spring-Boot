package com.doctorapp.util;

public class Queries {
	public static final String CREATEQUERY = "CREATE TABLE Doctor(DoctorID Integer Primary Key auto_increment, DoctorName Varchar(25),"
													+ " Speciality Varchar(35), Fees Double, Experience Integer, InTime Timestamp, OutTime Timestamp);";
	public static final String INSERTQUERY = "INSERT INTO Doctor(DoctorName, Speciality, Fees, Experience, InTime, OutTime) VALUES(?,?,?,?,?,?);";
	public static final String UPDATEQUERY = "UPDATE Doctor SET Fees=? WHERE DoctorID=?";
	public static final String DELETEQUERY = "DELETE FROM Doctor WHERE DoctorID=?";
	public static final String SELECTQUERY = "SELECT * FROM Doctor";

	public static final String QUERYBYSPEC = "SELECT * FROM Doctor WHERE Speciality=?";
	public static final String QUERYBYSPECANDEXP = "SELECT * FROM Doctor WHERE Speciality=? AND Experience=?";
	public static final String QUERYBYSPECANDFEE = "SELECT * FROM Doctor WHERE Speciality=? AND Fees=?";
	public static final String QUERYBYAVAIL = "SELECT * FROM Doctor WHERE InTime=?";
	public static final String QUERYBYID = "SELECT * FROM Doctor WHERE DoctorID=?";
}
