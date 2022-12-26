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

        
        return "ye";
    }
}
