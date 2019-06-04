package boulderDashGame.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h1>DBConnector Class </h1>
 * connect the dataBase to the javaCode, then can execute queries.
 * <p>
 * we will use this class to catch the object in the map, and then we will use them to interact with them.
 * <p>
 * 
* @author Theo
* @author Thomas Barbod Varjavandi (alias - Deiaros)
* @version 9.2
* @since 0.9.0
*/


public class DBConnector {
	
	private static String userDB = "root";
	private static String passDB="";
	private static String urlDB="jdbc:mysql://localhost:3306/boulderDashDB"; //@TODOPut the URL of the DataBase.
	
	private static DBConnector DBConnector = null;

	/**
     * Method that open the connection.
     *   
     *          
     */
	public DBConnector() 
	{
		try 
		{
		    Class.forName("com.mysql.cj.jdbc.Driver");    
		}
		catch (ClassNotFoundException e) 
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	}
	
	
	/**
     * <h1>getConnection Method</h1>
     * establishes a connection if needed and returns that connection
     * 
     * @return stored/established connection
     * @throws SQLException           
     */
	public Connection getConnection() throws SQLException 
	{
		Connection conn = null;
		conn = DriverManager.getConnection(urlDB, userDB, passDB);
		return conn;
	}	

	public static DBConnector getInstance() 
	{
		if (DBConnector == null) 
		{
			DBConnector = new DBConnector();
		}
		return DBConnector;
	}

}
