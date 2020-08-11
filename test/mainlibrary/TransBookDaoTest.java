package mainlibrary;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TransBookDaoTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testCheckBook() {
        System.out.println("Test Check Nook");
    }

    @Test
    public void testBookValidate() {
        System.out.println("Test Book Validate");
    }

    @Test
    public void testUserValidate() {
        System.out.println("Test User Validate");
    }

    @Test
    public void testUpdatebook() {
        System.out.println("Test update Book");
    }

    @Test
    public void testIssueBook() {
        System.out.println("Test Issue Book");
    }

    @Test
    public void testReturnBook() {
        System.out.println("Test Return Book");
    }

    @Test
    public void testCheckIssuedBook() {
        System.out.println("Test Check Issue Book");
    }

    @Test
    public void testCheck() {
        System.out.println("Test Check");
    }
}