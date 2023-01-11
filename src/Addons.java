import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Addons {
    static Connection connect = null;

    public static void OutPut()
    {
        System.out.println("outoutout");
    }

    public static void ConnectionInit()
    {
        // Connect to the database
        String url = "jdbc:postgresql://ep-green-sunset-184809.eu-central-1.aws.neon.tech/zivalski_vrt";
        String username = "BernardWasTaken";
        String password = "bi5UQN2cDPVl";
        try {
            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String GetAll()
    {
        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT test()");
    
            // Iterate through the results
            while (rs.next()) {
                // Retrieve data from each column
                String naslov = rs.getString(1);
                System.out.println(naslov);
                // etc.
            }
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }

        return "ye";
    }

    public static int getLoginData(String uporabnisko_input, String geslo_input)
    {
        int temp = 0;
        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getLoginData('"+uporabnisko_input+"', '"+geslo_input+"')");
    
            // Iterate through the results
            if(rst.next())
            {
                if(rst.getInt(1) == 1)
                {
                    temp = 1;
                }
                else
                {
                    temp = 0;
                }
            }
    
            // Close the connection
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }

        return temp;
    }

    public static int getDarkMode()
    {
        int temp = 0;
        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getDarkMode()");
    
            // Iterate through the results
            if(rst.next())
            {
                if(rst.getInt(1) == 1)
                {
                    temp = 1;
                }
                else
                {
                    temp = 0;
                }
            }
    
            // Close the connection
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }

        return temp;
    }

    public static void changeTheme()
    {
        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT changeTheme()");
    
            // Close the connection
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
    }

    public static List<String> getVrti()
    {
        List<String> ret = new ArrayList<String>();

        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getVrti()");
            
            while(rst.next())
            {
                ret.add(rst.getString(1));
            }

            // Close the connection
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }

        return ret;
    }

    public static int getMaxIdVrti()
    {
        int max = 0;

        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getMaxIdVrti()");
            
            while(rst.next())
            {
                max = rst.getInt(1);
            }

            // Close the connection
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }

        return max;
    }

    public static String getVrtiList(int i)
    {
        String ret = "";

        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getVrtiList("+i+")");
            
            while(rst.next())
            {
                ret = rst.getString(1);
            }

            // Close the connection
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }

        return ret;
    }
}
