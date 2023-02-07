import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.Dimension;
import java.security.MessageDigest;
import java.awt.*;

import javax.xml.*;

public class Addons {
    static Connection connect = null;

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static Dimension objectSize()
    {
        Dimension ret = new Dimension();

        ret.height = (int)(screenSize.getHeight()/22); //8
        ret.width = (int)(screenSize.getWidth()/8); //22

        return ret;
    }

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

        return "je";
    }

    public static List<String> getZaposleni(String vrt)
    {
        List<String> ret = new ArrayList<String>();

        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getZaposleni('"+vrt+"')");
    
            // Iterate through the results
            while(rst.next())
            {
                ret.add(rst.getString(1));
                ret.add(rst.getString(2));
            }
    
            // Close the connection
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        return ret;
    }

    public static List<String> getZivali(String vrt)
    {
        List<String> ret = new ArrayList<String>();

        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getZivali('"+vrt+"')");
    
            // Iterate through the results
            while(rst.next())
            {
                ret.add(rst.getString(1));
                ret.add(rst.getString(2));
            }
    
            // Close the connection
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        return ret;
    }

    public static List<String> getZaposleniAll()
    {
        List<String> ret = new ArrayList<String>();

        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getZaposleniAll()");
    
            // Iterate through the results
            while(rst.next())
            {
                ret.add(rst.getString(1));
                ret.add(rst.getString(2));
            }
    
            // Close the connection
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        return ret;
    }

    public static List<String> getZivaliAll()
    {
        List<String> ret = new ArrayList<String>();

        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getZivaliAll()");
    
            // Iterate through the results
            while(rst.next())
            {
                ret.add(rst.getString(1));
                ret.add(rst.getString(2));
            }
    
            // Close the connection
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        return ret;
    }

    public static String getUsername(String ime, String priimek)
    {
        String username = "";
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getUsername('"+ime+"', '"+priimek+"')");
    
            // Iterate through the results
            if(rst.next())
            {
                username = rst.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getUsername():: " + e.getMessage());
        }
        return username;
    }

    public static String getGeslo(String ime, String priimek)
    {
        String geslo = "";
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getGeslo('"+ime+"', '"+priimek+"')");
    
            // Iterate through the results
            if(rst.next())
            {
                geslo = rst.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getGeslo():: " + e.getMessage());
        }
        return geslo;
    }

    public static String getSpol(String ime, String priimek)
    {
        String spol = "";
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getSpol('"+ime+"', '"+priimek+"')");
    
            // Iterate through the results
            if(rst.next())
            {
                spol = rst.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getSpol():: " + e.getMessage());
        }
        return spol;
    }

    public static String getVrt(String ime, String priimek)
    {
        String vrt = "";
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getVrt('"+ime+"', '"+priimek+"')");
    
            // Iterate through the results
            if(rst.next())
            {
                vrt = rst.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getVrt():: " + e.getMessage());
        }
        return vrt;
    }

    public static String getVrstaZivali(String ime)
    {
        String vrsta = "";
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getVrstaZivali('"+ime+"')");
    
            // Iterate through the results
            if(rst.next())
            {
                vrsta = rst.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getVrt():: " + e.getMessage());
        }
        return vrsta;
    }

    public static int getOgrozena(String ime)
    {
        int ogrozena = 0;
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getOgrozena('"+ime+"')");
    
            // Iterate through the results
            if(rst.next())
            {
                ogrozena = rst.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getOgrozena():: " + e.getMessage());
        }
        return ogrozena;
    }

    public static void updateUser(String ori_ime, String ori_priimek, String imee, String prii, String uporabnisko, String ges, String spoll, String vrtt)
    {
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            stmt.executeUpdate("SELECT updateUser('"+ori_ime+"', '"+ori_priimek+"', '"+imee+"', '"+prii+"', '"+uporabnisko+"', '"+ges+"', '"+spoll+"', '"+vrtt+"')");
        } catch (Exception e) {
            System.out.println("getVrt():: " + e.getMessage());
        }
    }

    public static void deleteVrt(String imee)
    {
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            stmt.executeUpdate("SELECT deleteVrt('"+imee+"')");
        } catch (Exception e) {
            System.out.println("deleteVrt():: " + e.getMessage());
        }
    }

    public static void deleteZaposleni(String imee, String priimekk)
    {
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            stmt.executeUpdate("SELECT deleteZaposleni('"+getUsername(imee, priimekk)+"')");
        } catch (Exception e) {
            System.out.println("deleteZaposleni():: " + e.getMessage());
        }
    }

    public static void deleteZival(String imee)
    {
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            stmt.executeUpdate("SELECT deleteZival('"+imee+"')");
        } catch (Exception e) {
            System.out.println("deleteZival():: " + e.getMessage());
        }
    }

    public static String myHash(String original)
    {
        String hashed = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            hashed = ""+digest;
        } catch (Exception e) {
            System.out.println("myHash():: "+e.getMessage());
        }
        return hashed;
    }

    public static void insertZival(String imee, String vrstaa, int ogrozenaa)
    {
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            stmt.executeUpdate("SELECT insertZival('"+imee+"', '"+vrstaa+"', "+ogrozenaa+")");
        } catch (Exception e) {
            System.out.println("insertZival():: " + e.getMessage());
        }
    }

    public static void insertVrt(String imee, String naslovv, String krajj)
    {
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            stmt.executeUpdate("SELECT insertVrt('"+imee+"', '"+naslovv+"', '"+krajj+"')");
        } catch (Exception e) {
            System.out.println("insertVrt():: " + e.getMessage());
        }
    }

    public static void updateZival(String ori_ime, String imee, String vrst, int ogr)
    {
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            stmt.executeUpdate("SELECT updateZival('"+ori_ime+"', '"+imee+"', '"+vrst+"', "+ogr+")");
        } catch (Exception e) {
            System.out.println("getZival():: " + e.getMessage());
        }
    }

    public static String getNaslov(String ime)
    {
        String ret = "";

        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getNaslov('"+ime+"')");
    
            // Iterate through the results
            if(rst.next())
            {
                ret = rst.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getNaslov():: " + e.getMessage());
        }

        return ret;
    }

    public static String getKraj(String ime)
    {
        String ret = "";

        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getKraj('"+ime+"')");
    
            // Iterate through the results
            if(rst.next())
            {
                ret = rst.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getKraj():: " + e.getMessage());
        }

        return ret;
    }

    public static void updateVrt(String ori_ime, String imee, String naslov, String kraj)
    {
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            stmt.executeUpdate("SELECT updateVrt('"+ori_ime+"', '"+imee+"', '"+naslov+"', '"+kraj+"')");
        } catch (Exception e) {
            System.out.println("updateVrt():: " + e.getMessage());
        }
    }

    public static void insertRegister(String ime, String priimek, String geslo, String spol, String vrt)
    {
        try {

            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            stmt.executeUpdate("SELECT insertRegister('"+ime+"', '"+priimek+"', '"+geslo+"', '"+spol+"', '"+vrt+"')");
        } catch (Exception e) {
            System.out.println("insertRegister():: " + e.getMessage());
        }
    }

    public static int getAllZaposleni(String vrt)
    {
        int temp = 0;
        try {
            Statement stmt = Addons.connect.createStatement();
    
            // Execute a query
            ResultSet rst = stmt.executeQuery("SELECT * FROM getAllZaposleni('"+vrt+"')");
    
            // Iterate through the results
            if(rst.next())
            {
                temp = rst.getInt(1);
            }
    
            // Close the connection
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        return temp;
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
