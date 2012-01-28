/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.cloudbees.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author harpreet
 */
public class DAOTest {

    Connection conn = null;
    DAO dao = new DAO();

    public DAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        Properties connectionProps = new Properties();
        // Derby
       
        // connectionProps.put("user", "bees");
        // connectionProps.put("password", "bees");
        
        //MySQL
        // connectionProps.put("user", "cb_tutorial");
        // connectionProps.put("password", "cb_tutorial");


        try {
             // For Derby
             // conn = DriverManager.getConnection("jdbc:derby://localhost:1527/countries"
             //       + ";create=false", connectionProps);
            // For CloudBees MySQL
            conn = DriverManager.getConnection(
                    "jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com:3306/tutorial_dev?"+
                    "user=cb_tutorial&password=cb_tutorial");
                   
            
            dao.setConnection(conn);
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("Cannot connect to database; subsequent tests will fail");
            return;
        }

        System.out.println("Connected to database");

    }

    @After
    public void tearDown() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of connect method, of class DAO.     */
    /*
    @Test
    public void testConnect() {
        System.out.println("connect");
        DAO instance = new DAO();
        instance.connect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class DAO.
     */
    @Test
    public void testGetAll() {
        try {
            System.out.println("test: getAll");
            int expectedResultSize = 5;

            ResultSet result = dao.getAll();
            if (result == null) {
                fail("Could not retrieve the result set from the database");
                return;
            }
            int count = 0;
            while (result.next()) {
                count++;
            }

            assertEquals(expectedResultSize, count);
            // TODO review the generated test code and remove the default call to fail.
        } catch (SQLException ex) {
            Logger.getLogger(DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
         * Test of getCapital method, of class DAO.
         */
    @Test
    public void testGetCapital() {
        try {
            System.out.println("test: getCapital");
            String expected = "Kuala Lumpur";
            String findCountry = "Malaysia";
            ResultSet result = dao.getCapital(findCountry);
            if (result == null) {
                fail("Could not retrieve the result set from the database");
                return;
            }
            result.next();
            String capital = result.getString(1);
            assertEquals(expected, capital);

        } catch (SQLException ex) {
            Logger.getLogger(DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
