/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlibrary;

import java.sql.*;

/**
 * @author bikash
 */
public class UsersDao {

    public static boolean validate(String name, String password) {
        boolean status = false;

        try (Connection con = DB.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("select * from Users where UserName=? and UserPass=?")) {
                ps.setString(1, name);
                ps.setString(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    status = rs.next();
                }
            } catch (SQLException e) {
              //  e.printStackTrace();
            }
        } catch (SQLException e) {
        //    e.printStackTrace();
        }
        return status;
    }

    public static boolean checkIfAlready(String UserName) {
        boolean status = false;
        try (Connection con = DB.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("select * from Users where UserName=? ")) {
                ps.setString(1, UserName);
                try (ResultSet rs = ps.executeQuery()) {
                    status = rs.next();
                } catch (SQLException e) {
                //    e.printStackTrace();
                }
            } catch (SQLException e) {
             //   e.printStackTrace();
            }
        } catch (SQLException e) {
         //   e.printStackTrace();
        }
        return status;
    }

    public static int addUser(String User, String UserPass, String UserEmail, String Date) {

        String salt = Secret.getSalt();

        try {
            UserPass = DB.getEncryptedPassword(UserPass, salt);
        } catch (Exception e) {
        //    e.printStackTrace();
        }

        int status = 0;
        try (Connection con = DB.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("insert into Users(UserPass,RegDate,UserName,Email) values(?,?,?,?)")) {
                ps.setString(1, UserPass);
                ps.setString(2, Date);
                ps.setString(3, User);
                ps.setString(4, UserEmail);
                status = ps.executeUpdate();
            } catch (SQLException e) {
             //   e.printStackTrace();
            }

        } catch (SQLException e) {
         //   e.printStackTrace();
        }
        return status;

    }

    public static int cleanup() {
        String name = "TestUser";
        int status = 0;
        try (Connection con = DB.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("delete from Users where UserName=?")) {
                ps.setString(1, name);
                status = ps.executeUpdate();
            } catch (SQLException e) {
              //  e.printStackTrace();
            }
        } catch (SQLException e) {
         //   e.printStackTrace();
        }
        return status;
    }

}
