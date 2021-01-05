package login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import koneksi.Koneksi;

/**
 *
 * @author GRK
 */
public class LoginDAOImp implements LoginDAO{
    private String authQuery = "select * from user where username = ? and password= ?";
    private PreparedStatement ps;
    private ResultSet rs;
    private final Koneksi koneksi = new Koneksi();

    @Override
    public void login(String username, String password) {
        try {
            ps = koneksi.getCon().prepareStatement(authQuery);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
                Login.AUTH = true;
                Login.NAMA = rs.getString("nama");
                Login.USER_ID = rs.getInt("id");
            }
        } catch (Exception ex) {
            //Logger.getLogger(LoginDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    @Override
    public void logout() {
        Login.AUTH = false;
        Login.NAMA = "";
        Login.USER_ID = 0;
        Login.STATUS = "";
    }
}