package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlQueryFunction {
	
	
	@SuppressWarnings("finally")
	public static int getCount(String sqlQuery) throws ClassNotFoundException{
		
		 ReadProperties config = new ReadProperties();
		 try {
			config.loadProperties("config.properties");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		 String jdbcdriver = config.get("jdbcdriver");
		 String jdbcurl = config.get("jdbcurl");
		 String jdbcaccount = config.get("jdbcaccount");
		 String jdbcpassword = config.get("jdbcpassword");
		
		  Connection conn = null;
	      Statement stmt = null;
	      int count = 99999;
		  
		  try {
			  try {
		             Class.forName(jdbcdriver);
		          } catch (Exception e) {
		             System.out.println(e);
		          }
			  String myUrl = jdbcurl;
		      conn = DriverManager.getConnection(myUrl, jdbcaccount, jdbcpassword);
		      String query = sqlQuery;
		      stmt = conn.createStatement();
		      ResultSet rs = stmt.executeQuery(query);
		      rs.next();
		      count = rs.getInt(1);
		  } catch (SQLException excep) {
	          excep.printStackTrace();
	       } catch (Exception excep) {
	          excep.printStackTrace();
	       } finally {
	          try {
	             if (stmt != null)
	             conn.close();
	          } catch (SQLException se) {}
	          try {
	             if (conn != null)
	             conn.close();
	          } catch (SQLException se) {
	             se.printStackTrace();
	          }
	          return count;
	       }
		       
	}
	
	public static void deleteRecord(String sqlQuery) throws ClassNotFoundException{
		 
		ReadProperties config = new ReadProperties();
		 try {
			config.loadProperties("config.properties");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		 String jdbcdriver = config.get("jdbcdriver");
		 String jdbcurl = config.get("jdbcurl");
		 String jdbcaccount = config.get("jdbcaccount");
		 String jdbcpassword = config.get("jdbcpassword");
		
		
		  Connection conn = null;
	      Statement stmt = null;
	    
		  try {
			  try {
		             Class.forName(jdbcdriver);
		          } catch (Exception e) {
		             System.out.println(e);
		          }
			  String myUrl = jdbcurl;
		      conn = DriverManager.getConnection(myUrl, jdbcaccount, jdbcpassword);
		      String query = sqlQuery;
		      stmt = conn.createStatement();
		      stmt.executeUpdate(query);
		      
		  } catch (SQLException excep) {
	          excep.printStackTrace();
	       } catch (Exception excep) {
	          excep.printStackTrace();
	       } finally {
	          try {
	             if (stmt != null)
	             conn.close();
	          } catch (SQLException se) {}
	          try {
	             if (conn != null)
	             conn.close();
	          } catch (SQLException se) {
	             se.printStackTrace();
	          }
	       }      
	}

	}
