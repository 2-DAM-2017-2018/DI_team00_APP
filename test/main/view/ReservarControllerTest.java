/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import javafx.stage.Stage;
import main.model.Clase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dani
 */
public class ReservarControllerTest {
    
    public ReservarControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDialogStage method, of class ReservarController.
     */
    
    @Test
    public void testSetDialogStage() 
    {
        try
        {
        System.out.println("setDialogStage");
        Stage dialogStage = null;
        ReservarController instance = new ReservarController();
        instance.setDialogStage(dialogStage);
        }
        catch(Exception e)
        {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setClase method, of class ReservarController.
     */
    @Test
    public void testSetClase() 
    {
        try
        {
        System.out.println("setClase");
        Clase clase = null;
        ReservarController instance = new ReservarController();
        instance.setClase(clase);
        }
        catch (Exception eo) 
        {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of isOkClicked method, of class ReservarController.
     */
    @Test
    public void testIsOkClicked() 
    {
        try
        {
            System.out.println("isOkClicked");
            ReservarController instance = new ReservarController();
            boolean expResult = false;
            boolean result = instance.isOkClicked();
            assertEquals(expResult, result);
            
        }
        catch(Exception eoe)
        {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
       
     
    }
    
}
