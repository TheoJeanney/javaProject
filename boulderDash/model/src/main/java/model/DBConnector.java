package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnector {
	
	private String userDB = "root";
	private String passDB="";
	private String urlDB=""; //Put the URL of the DataBase.
	
	private Connection connection;
	private Statement statement;
	private DBConnector instance;
	
	
	public void DBConnector(){
		
	}
	
	public boolean isOpen(){
		
		return true;
		
	}
	
	public static void setInstance(DBConnector instance){
		
	}
	
	public static DBConnector getInstance(){
		return null;
		
	}
	
	public void setConnection(Connection connection){
		
	}
	
	
	public Connection getConnection(){
		return null;
	}
	
	public void setStatement(Statement statement){
		
	}
	
	public Statement getStatement(){
		return null;
	}
	
	public ResultSet executeQuery (String query){
		return null;
	}
	
	public Integer executeUpdate(String query){
		return 0;
	}
	
	
	public CallableStatement prepareCall(String query){
		return null;
	}
	


}
