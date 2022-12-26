import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            Addons.ConnectionInit();

            GUI gui = new GUI();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        try {
        Statement stmt = Addons.connect.createStatement();

        // Execute a query
        ResultSet rs = stmt.executeQuery("SELECT * FROM Vrti");

        // Iterate through the results
        while (rs.next()) {
            // Retrieve data from each column
            int id = rs.getInt("id");
            String naslov = rs.getString("naslov");
            System.out.println(id);
            System.out.println(naslov);
            // etc.
        }

        // Close the connection
        Addons.connect.close();
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
    }
}
