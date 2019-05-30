package model;

/**
 * <h1>DAOHandler Class </h1>
 * 
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/

import java.sql.CallableStatement;
import java.sql.ResultSet;

public class DAOHandler {
	
	  /**
     * Execute query.
     *
     * @param query
     *            the query
     * @return the result set
     */
	protected static ResultSet executeQuery(String query){
		return DBConnector.getInstance().executeQuery(query);
		
	}
	 /**
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
     */
	protected static Integer executeUpdate(String query){
		return DBConnector.getInstance().executeUpdate(query);
	}
	 /**
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the callable statement
     */
	protected static CallableStatement prepareCall(String query){
		return DBConnector.getInstance().prepareCall(query);
	}
}