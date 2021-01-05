package koneksi;

/**
 *
 * @author GRK
 */
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    private Connection con; //tempat penyimpanan  koneksi
    private final String db = "db_penjualan";   //nama database
    private final String url = "jdbc:mysql://localhost:3306/"+db;   //server link database
    private final String user = "root"; //mysql username
    private final String pass = ""; //mysql password
    
    public Koneksi(){
        if(con == null){
            try {
                //registrasi driver koneksi
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                //login mysql/koneksi dengan syarat yang ada
                con = DriverManager.getConnection(url, user, pass);
                //test message
                //  System.out.println("Connected!!");
            } catch (SQLException | HeadlessException e) { //kesalahan ditampung di variabel e
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public Connection getCon() {
        return con;
    }
    
    public static void main(String[] args) {
        Koneksi con = new Koneksi();
    }
}
