package mainlibrary;

import java.sql.*;

public class LibrarianDao {

    public static int save(String name, String password, String email, String address, String city, String contact) {
        int status = 0;
        try {

            Connection con = DB.getConnection();
//            PreparedStatement ps = con.prepareStatement("insert into librarian(name,password,email,address,city,contact) values(?,?,?,?,?,?)");
//            ps.setString(1, name);
//            ps.setString(2, password);
//            ps.setString(3, email);
//            ps.setString(4, address);
//            ps.setString(5, city);
//            ps.setString(6, contact);
            System.out.println("Fn "+ name+" Un "+address+" pass "+ password+" email "+email);

            PreparedStatement ps = con.prepareStatement("insert into librarian(FullName, UserName, Password,Email) values(?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, password);
            ps.setString(4, email);

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from Librarian where LibrarianID=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean validate(String name, String password) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            String select = "select * from Librarian where UserName= '" + name + "' and Password='"+ password +"'";
            Statement selectStatement = con.createStatement();
            ResultSet rs = selectStatement.executeQuery(select);
          
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    public static int cleanup() {
        int status = 0;
        String user = "hack";
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from librarian where UserName=?");
            ps.setString(1, user);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int findHacker() {
        int status = 0;
        String user = "hack";
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select LibrarianID from librarian where UserName=?");
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                status = rs.getInt("LibrarianID");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

}
