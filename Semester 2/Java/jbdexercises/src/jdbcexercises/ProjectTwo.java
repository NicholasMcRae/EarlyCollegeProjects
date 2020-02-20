/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Mar 26, 2012
 */
package jdbcexercises;

import java.sql.*;
import java.util.Scanner;


public class ProjectTwo  
{
	
	static Connection conn = null;
	static Statement stmt = null;
	static String dbURL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static String user = "projects";
	static String password = "projects";
	
	public ProjectTwo(){}
	
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
			
			//while(!userInput.equalsIgnoreCase("X")){
				System.out.println("Enter a customer ID");
				userInput = in.nextLine();
				
				ResultSet r1 = stmt.executeQuery(" SELECT od.orderID, o.orderdate, '$' || TO_CHAR(((od.Quantity * od.unitprice)- " +
      			" (od.discount * od.quantity)),'99,999.99') as \"Order Total\", NVL2(shippeddate, 'Shipped', 'Not Shipped') as \"Status\" "
+ " FROM ORDERDETAILS od join ORDERS o ON od.orderid = o.orderid JOIN customers c ON c.customerid = o.customerid "
+ " WHERE c.CUSTOMERID = '" + userInput + "' " + " ORDER BY 3 desc ");
				
				ResultSet r2 = stmt.executeQuery("SELECT AVG (AVG (quantity * (unitprice - discount))) as \"AVERAGE\"" +
"FROM ORDERDETAILS od JOIN ORDERS o ON od.orderid = o.orderid JOIN customers c ON o.customerid = c.customerid GROUP BY c.customerid");
				
				ResultSet r3 = stmt.executeQuery("SELECT COUNT (o.orderid) as \"Number Orders\" FROM ORDERDETAILS od JOIN ORDERS o" +
"ON od.orderid = o.orderid JOIN customers c ON o.customerid = c.customerid WHERE (od.quantity * (od.unitprice - od.discount)) > 484.0205202");
      	
      	
      				
        	
        	
        	ResultSetMetaData meta = r1.getMetaData();
        	
        	System.out.println(meta.getColumnName(1) + "       " + meta.getColumnName(2)
        			+ "       " + meta.getColumnName(3) + "       " + meta.getColumnName(4));
        	
        	System.out.println("**********************************************************");
        	
        	while (r1.next()){
    				System.out.println(r1.getString("ORDERID") + "        " + r1.getDate("ORDERDATE") + "        "
    						+ r1.getString("Order Total") + "        " + r1.getString("Status"));
    			}
        	
        	r1.close();
				  
        	
        	System.out.println("The average customer order is:");
            while(r2.next()){
            	      	
            	System.out.print(r2.getString("AVERAGE"));
            	            
            }
            
            r2.close();
            
            System.out.println("The average customer order is:");
            while(r3.next()){
            	      	
            	System.out.print(r3.getString("NUMBER ORDERS"));
            	            
            }
            
            r3.close();
				
			
		
			
			
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