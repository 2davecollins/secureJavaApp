package mainlibrary;

import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoTest {

    UsersDao udao = null;

    @BeforeTest
    public void beforeTest() {
        System.out.println("Run Before Test");
        udao = new UsersDao();

    }

    @AfterTest
    public void afterTest() {
        System.out.println("Run after Test");
        udao.cleanup();
        udao = null;
    }


    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void tearDown() {

    }

    @Test(priority = 1)
    public void testIfAlreadyFalse() {
        System.out.println("Test Check if already exists when user not in database ");
        Assert.assertEquals(false, udao.checkIfAlready("TestUser"));
    }

    @Test(priority = 2)
    public void testFailValidate() {
        System.out.println("Validate a non user");
        Assert.assertEquals(false, udao.validate("TestUser", "1234"));

    }

    @Test(priority = 3)
    public void testAddUser() {
        System.out.println("Test to add new User");
        Assert.assertEquals(1, udao.addUser("TestUser", "123", "test@g.com", "2020-05-05"));
    }

    @Test(priority = 4)
    public void testIfAlreadyTrue() {
        System.out.println("Test Check if new user exists");
        Assert.assertEquals(true, udao.checkIfAlready("TestUser"));
    }

    @Test(priority = 5)
    public void testValidate() {
        System.out.println("Validate user");
        //Assert.assertEquals(true, udao.validate("TestUser","123"));
        Assert.assertEquals(true, udao.validate("TestUser", "WkZZ58pbJLu7bhpLB+hKbCNyBbI="));

    }

    @Test(priority = 6)
    public void testValidateWrongPass() {
        System.out.println("Validate user with incorrect password");
        Assert.assertEquals(false, udao.validate("TestUser", ""));

    }

    @Test(priority = 7)
    public void testValidateBlankUser() {
        System.out.println("Validate blank username");
        Assert.assertEquals(false, udao.validate("", "123"));

    }

    @Test(priority = 8)
    public void testSQLOR1eq1() {
        System.out.println("Check sql injection using OR 1=1");
        Assert.assertEquals(false, udao.validate("hacker\'or \"\"=\'", "0\'or \"\"=\'"));

    }

    @Test(priority = 10)
    public void getFromDB() {
        String stment = "select * from Users where UserName=?";
        Object[] inputValues = new Object[1];
        inputValues[0] = "Deco";
        boolean rs = DB.getFromDB(stment, inputValues);
        Assert.assertEquals(true, rs);

    }
    @Test(priority = 11)
    public void getValidIDDB() {
        String stment = "select * from Users where UserName=? and UserPass=?";
        Object[] inputValues = new Object[2];
        inputValues[0] = new String("Deco");
        inputValues[1] = new String("rbQTtqSihzfMbC/BrgrC4HPaXfw=");
        boolean rs = DB.getFromDB(stment, inputValues);
        Assert.assertEquals(true, rs);

    }
}