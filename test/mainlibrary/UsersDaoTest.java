package mainlibrary;

import org.dom4j.util.UserDataAttribute;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UsersDaoTest {
    UsersDao udao = null;

    @BeforeMethod
    public void setUp() {
        System.out.println("UserDaoTest setUp");
        udao = new UsersDao();

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("UserDaoTest TearDown");
        udao = null;
    }

    @Test(priority = 1)
    public void testValidate() {
        System.out.println("Validate user");
        Assert.assertEquals(true, udao.validate("Deco","1234"));
       
    }

    @Test(priority = 3)
    public void testCheckIfAlready() {
        System.out.println("Test Check if already exists");
        Assert.assertEquals(true,udao.CheckIfAlready("Deco"));
    }

    @Test(priority = 2)
    public void testAddUser() {
        System.out.println("Test Add User");

        Assert.assertEquals(1,udao.AddUser("TestUser","123", "test@g.com","2020-05-05"));
    }
}