import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            Addons.ConnectionInit();

            GUI_login gui = new GUI_login();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        try {
        Addons.GetAll();
        } 
        catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }
}
