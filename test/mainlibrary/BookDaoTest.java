package mainlibrary;

import org.testng.Assert;
import org.testng.annotations.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.testng.Assert.*;

public class BookDaoTest {
    BookDao bdao;

    @BeforeTest
    public void init(){
        bdao = new BookDao();

    }
    @AfterTest
    public void endTest(){
        bdao.cleanup();
        bdao = null;

    }

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testSave() {
    }

    @Test(priority= 3)
    public void testPublisherValidate() {
        Assert.assertEquals(true, bdao.PublisherValidate("Test Publisher"));
    }

    @Test(priority=1)
    public void testFailPublisherValidate() {
        Assert.assertEquals(false, bdao.PublisherValidate("Test Publisher"));
    }


    @Test(priority=2)
    public void testAddPublisher() {
        Assert.assertEquals(1, bdao.AddPublisher("Test Publisher"));
    }

    @Test
    public void testSaveBook() {
    }

    @Test
    public void testDelete() {
    }
}