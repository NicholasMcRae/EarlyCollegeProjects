/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Mar 26, 2012
 */
package jdbcexercises;

import java.sql.*;
import java.util.Scanner;


public class JdbcProgram  
{
	
	static Connection conn = null;
	static Statement stmt = null;
	static String dbURL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static String user = "projects";
	static String password = "projects";
	
	public JdbcProgram(){}
	
	public static void main(String[] args)throws SQLException
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e){
			System.err.println(e.getMessage());
		}
		
		
		
		try {
			conn = DriverManager.getConnection(dbURL, user, password);
			conn.clearWarnings();
			System.out.println("Connection opened! for driver ==>Oracle 11XE");
			stmt = conn.createStatement();
			
			
			
			//dump out the data 2 ways - 1) by ordinal position, and 2) by name
			String userInput = "";
			Scanner in = new Scanner(System.in);  // System.in is an InputStream
			
			while(!userInput.equalsIgnoreCase("X")){
				System.out.println("Want to do Q1(1) or Q3(3) or (X) exit: ");
				userInput = in.nextLine();
				
				//option = br.readLine();
				//System.out.println("");
				
				if(userInput.equalsIgnoreCase("1"))
						{
        
        	ResultSet r1 = stmt.executeQuery("select * from VQ1");
        	
        	System.out.println("Employee ID, EmployeeOrders");
        	while (r1.next()){
    				System.out.println(r1.getString("employeeid") + " " + r1.getString("EmployeeOrders"));
    			}
        	
        	r1.close();
				}
           
        if(userInput.equalsIgnoreCase("3")){
        	ResultSet r2 = stmt.executeQuery("select * from VQ3");
        	
        	System.out.println("orderid, totalquantity");
        	while (r2.next()){
    				System.out.println(r2.getString("orderid") + " " + r2.getString("totalquantity"));
    			}
        	
        	r2.close();
        }
                
				
			
			}// end while loop
			
			
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
//end class