package model;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1>DBConnector Class </h1>
 * connect the dataBase to the javaCode, then can execute queries.
 * <p>
 * we will use this class to catch the object in the map, and then we will use them to interact with them.
 * <p>
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/


public class DBConnector {
	
	private static String userDB = "root";
	private static String passDB="";
	private static String urlDB="jdbc:mysql://localhost:3306/boulderDash"; //@TODOPut the URL of the DataBase.
	
	private Connection connection;
	private Statement statement;
	private static DBConnector instance;
	
	/**
     * Method that open the connection.
     *   
     *          
     */
	public DBConnector(){
		this.isOpen();
	}
	
	/**
     * Method that connect dataBase with JavaCode.
     * 
     * @return if the connection is good, return true.   
     *          
     */
	public boolean isOpen(){
		try {
			
			this.connection = DriverManager.getConnection(DBConnector.urlDB,DBConnector.userDB,DBConnector.passDB);
			this.statement = this.connection.createStatement();
			return true;
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	/**
     * Method that set the Instance
     *
     * @param instance , differentiate our objects.
     *          
     */
	public static void setInstance(DBConnector instance){
		DBConnector.instance = instance;
	}
	
	/**
     * Method that can get the object.

     * @return the instance of our object.
     *          
     */
	public static DBConnector getInstance(){
		return DBConnector.instance;
		
	}
	
	/**
     * Method that set the connection

     * @param connection , initialize our connection.
     *          
     */
	
	public void setConnection(Connection connection) {
		this.connection = connection;
		
	}
	
	/**
     * Method that get the connection.

     * @return the connection.     
     *          
     */
	
	public Connection getConnection(){
		
		return this.connection;
	}
	
	/**
     * Method that set the statement.
     * 
	 *
     * @param statement , initialize our statement.
     *          
     */
	
	public void setStatement(Statement statement){
		this.statement = statement;
	}
	
	/**
     * Method that get the statement

     * @return the statement.     
     *          
     */
	
	public Statement getStatement(){
		return this.statement;
	}
	
	/**
     * Method that execute our query.

     * @return null or execute the query.
     *          
     */
	
	public ResultSet executeQuery (String query){
		try {
			return this.getStatement().executeQuery(query);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
     * Method that update something @TODO

     * @return 0 or the execution of the query.   
     *          
     */
	
	public Integer executeUpdate(String query){
		try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
	}
	
	/**
     * Method that get the instance
     *
     * @param query , enter with the statement. 
     *
     * @return null or if we can connected with our data base.
     *          
     */
	
	public CallableStatement prepareCall(String query){
		try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

}
