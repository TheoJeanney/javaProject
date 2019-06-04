package model;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.GameLevels;

public class DAOHandlerTest {
	
	DAOHandler DAO = new DAOHandler();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecuteQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testExecuteUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareCall() throws SQLException {
		ResultSet rs = DAO.getEntityPlacement(GameLevels.LevelOne);
		while (rs.next())
		{
			String entityName = rs.getString("entName");
			System.out.println(entityName + "\n");
			assertNotNull(entityName);
		}
	}
}