package model;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBConnectorTest {
	
	DBConnector DBconnect = new DBConnector();


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
	public void testDBConnector() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsOpen() {
		assertTrue(DBconnect.isOpen());
	}


	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}


	@Test
	public void testGetConnection() {
		fail("Not yet implemented");
	}


	@Test
	public void testGetStatement() {
		fail("Not yet implemented");
	}

	@Test
	public void testExecuteQuery() throws SQLException {
		System.out.println(DBconnect.isOpen());
		System.out.println(DBconnect.getConnection());
		DBconnect.setStatement(DBconnect.getConnection().createStatement());
		System.out.println(DBconnect.getStatement());
		ResultSet rs = DBconnect.executeQuery("SELECT * FROM `entity`");
		while (rs.next()) {
			  String lastName = rs.getString("entName");
			  System.out.println(lastName + "\n");
			}
	}

}
