package jdbcexercises;
/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Mar 26, 2012
 */

import java.sql.*;

public class JdbcEx1
{
	static Connection conn = null;
	static String dbURL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static String user = "labs";
	static String password = "labs";
	
	public JdbcEx1(){}

	public static void main(String[] args)throws SQLException
	{
		// Register the driver with the class manager
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e){
			System.err.println(e.getMessage());
		}
			
			//open and close the connection
			
			try {
				conn = DriverManager.getConnection(dbURL, user, password);
				conn.clearWarnings();
				System.out.println("Connection opened! for driver ==>Oracle 11XE");
				} catch (SQLException e){
					System.err.println(e.getMessage());
				} finally {
					if(!conn.isClosed()){
						conn.close();
						System.out.println("Connection closed! Oracle");
					}
				}
		}

	}
//end main}
//end class