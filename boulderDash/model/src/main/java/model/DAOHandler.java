package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

/**
 * <h1>DAOHandler Class </h1>
 * 
 * 
* @author Théo
* @version 9.2
* @since 0.9.0
*/
public class DAOHandler 
{
	Connection connection = null;
	PreparedStatement prepStmt = null;
	ResultSet resultSet = null;
	
	public DAOHandler()
	{
		
	}
	
	private Connection getConnection() throws SQLException
	{
		Connection conn;
		conn = DBConnector.getInstance().getConnection();
		return conn;
	}
	
	
	
	public ResultSet getEntityPlacement(GameLevels choiceLevel)
	{
		try {
			String StringChoiceLevel = choiceLevel.toString();
			ResultSet rs = getConnection().createStatement().executeQuery("call getEntityPlacement('" + StringChoiceLevel + "')");
			return rs;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getAnimationSprite(GameEntities choiceEntity, EntityAnimation choiceAnim)
	{
		try {
			String StringChoiceEntity = choiceEntity.toString();
			String StringChoiceAnim = choiceAnim.toString();
			ResultSet rs = getConnection().createStatement().executeQuery("call getEntityPlacement('" + StringChoiceEntity + "','" + StringChoiceAnim + "')");
			return rs;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
}