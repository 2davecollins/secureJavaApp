package mainlibrary;

import java.sql.*;

public class LibrarianDao {

    public static int save(String FName, String UName, String Pass, String EMail) {
        int status = 0;
        try (Connection con = DB.getConnection();) {
            try (PreparedStatement ps = con.prepareStatement("insert into librarian(FullName, UserName, Password,Email) values(?,?,?,?)");) {
                ps.setString(1, FName);
                ps.setString(2, UName);
                ps.setString(3, Pass);
                ps.setString(4, EMail);
                status = ps.executeUpdate();
            } catch (SQLException e) {
                //e.printStackTrace();
            }
        } catch (SQLException e) {
            //System.out.println(e);
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        Connection con = DB.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("delete from Librarian where LibrarianID=?");
            try {
                ps.setInt(1, id);
                status = ps.executeUpdate();
            } catch (SQLException e) {
               // e.printStackTrace();
            } finally {
                ps.close();
            }

        } catch (SQLException e) {
            //System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                //e.printStackTrace();
            }
        }
        return status;
    }

    public static boolean validate(String name, String password) {
        boolean status = false;
        try(Connection con = DB.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("select * from Librarian where UserName=? and password=?")){
                ps.setString(1,name);
                ps.setString(2,password);
                try (ResultSet rs = ps.executeQuery()) {
                    status = rs.next();
                }catch(SQLException e){
                    //e.printStackTrace();
                }
            }catch (SQLException e){
                //e.printStackTrace();
            }

        }catch (SQLException e){
          //  e.printStackTrace();
        }
        return status;
    }

    public static int cleanup() throws SQLException {
        int status = 0;
        String user = "hack";
        try (Connection con = DB.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("delete from librarian where UserName=?")) {
                ps.setString(1, user);
                status = ps.executeUpdate();
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
            // e.printStackTrace();
        }

        return status;
    }

    public static int findHacker() {
        int status = 0;
        String user = "hack";
        try (Connection con = DB.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("select LibrarianID from librarian where UserName=?")) {
                ps.setString(1, user);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        status = rs.getInt("LibrarianID");
                    }
                } catch (SQLException e) {
                    //e.printStackTrace();
                }
            } catch (SQLException e) {
                //e.printStackTrace();
            }
        } catch (SQLException e) {
          //  e.printStackTrace();
        }
        return status;
    }
}
