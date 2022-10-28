package com.payingguests.util;

public class Queries {
	public static final String CREATEPGQUERY = "CREATE TABLE PayingGuest(PGId Integer PRIMARY KEY, PGName Varchar(50), Location Varchar(20),Category Varchar(20));";
	public static final String INSERTPGQUERY = "INSERT INTO PayingGuest VALUES(?,?,?,?);";

	public static final String SELECTPGQUERY = "SELECT * FROM PayingGuest;";
	public static final String QUERYBYPGID = "SELECT * FROM PayingGuest WHERE PGId=?;";
	public static final String QUERYBYCATEGORY = "SELECT * FROM PayingGuest WHERE Category=?;";
	public static final String QUERYBYLOCATION = "SELECT * FROM PayingGuest WHERE Location=?;";
	public static final String UPDATEPGCATEGORY = "UPDATE PayingGuest SET Category=? WHERE PGId=?;";

	public static final String DELETEPGQUERY = "DELETE FROM PayingGuest WHERE PGId=?;";

}
