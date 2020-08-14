package mainlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Secret {

    static final String connection = "jdbc:mysql://localhost:3306/library" ;


    public Secret(){
       // connection="jdbc:mysql://localhost:3306/library";
       // salt="rgqxY3pU04xmWDWjxGu1KcSdklCyWT";

    }

    static String  getUser()  {

        Properties defaultProps = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("config.txt");
            defaultProps.load(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return defaultProps.getProperty("user");
        }
    }


    static String getPassword(){
        Properties defaultProps = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("config.txt");
            defaultProps.load(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "1Developer1";
        }
    }
    static String getSalt(){
        Properties defaultProps = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("config.txt");
            defaultProps.load(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return defaultProps.getProperty("salt");
        }

    }
}
