import java.sql.*;

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
}
