package mainlibrary;

import org.dom4j.util.UserDataAttribute;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class UsersDaoTest {
    UsersDao udao = null;

    @BeforeTest
    public void beforeTest(){
        System.out.println("Run Before Test");
        udao = new UsersDao();

    }
    @AfterTest
    public void afterTest(){
        System.out.println("Run after Test");
        udao = null;
    }

    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void tearDown() {

    }

    @Test(priority = 1)
    public void testValidate() {
        System.out.println("Validate user");
        Assert.assertEquals(true, udao.validate("Deco","1234"));
       
    }
    @Test(priority = 2)
    public void testFailValidate() {
        System.out.println("Validate non user");
        Assert.assertEquals(false, udao.validate("Nando","1234"));

    }

    @Test(priority = 3)
    public void testCheckIfAlready() {
        System.out.println("Test Check if already exists");
        Assert.assertEquals(true,udao.CheckIfAlready("Deco"));
    }

    @Test(priority = 4)
    public void testAddUser() {
        System.out.println("Test Add User");

        Assert.assertEquals(1,udao.AddUser("TestUser","123", "test@g.com","2020-05-05"));
    }
}