package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnector {
	
	private static String userDB = "root";
	private static String passDB="";
	private static String urlDB="jdbc:mysql://localhost:3306/boulderDash"; //@TODOPut the URL of the DataBase.
	
	private Connection connection;
	private Statement statement;
	private static DBConnector instance;
	
	public void DBConnector(){
		this.isOpen();
	}
	
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
	
	public static void setInstance(DBConnector instance){
		DBConnector.instance = instance;
	}
	
	public static DBConnector getInstance(){
		return DBConnector.instance;
		
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
		
	}
	
	
	public Connection getConnection(){
		
		return this.connection;
	}
	
	public void setStatement(Statement statement){
		this.statement = statement;
	}
	
	public Statement getStatement(){
		return this.statement;
	}
	
	public ResultSet executeQuery (String query){
		try {
			return this.getStatement().executeQuery(query);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer executeUpdate(String query){
		try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
	}
	
	
	public CallableStatement prepareCall(String query){
		try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

}
