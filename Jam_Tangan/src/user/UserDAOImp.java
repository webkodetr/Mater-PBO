package user;   

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author GRK
 */
public class UserDAOImp implements UserDAO{
    private Koneksi con = new Koneksi();
    private Statement s;
    private PreparedStatement ps;   
    private ResultSet rs;
    private DefaultTableModel dtm;
    private final String[] column = {"ID", "USERNAME", "PASSWORD", "NAMA", "NO.TELP", "ALAMAT"};
    
    private String view = "select * from user";
    private String insert = "insert into user (username, password, nama, no_telp, alamat) values (?, ?, ?, ?, ?)";
            
    private String update = "update user set username=?, password=?, nama=?,"
            + "no_telp=?, alamat=? where id=?";
    private String delete = "delete from user where id=?";
    private String search = "select * from user where nama like %?%";

    @Override
    public void read(JTable table) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(view);  //eksekusi yg tdk merubah isi tabel
            while(rs.next()){
                Object[]col = new Object[6];
                col[0] = rs.getInt("id");
                col[1] = rs.getString("username");
                col[2] = rs.getString("password");
                col[3] = rs.getString("nama");
                col[4] = rs.getString("no_telp");
                col[5] = rs.getString("alamat");
               
                dtm.addRow(col);
            }
            table.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void create(User user) {
        try {
            ps = con.getCon().prepareStatement(insert);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNama());
            ps.setString(4, user.getNoTelp());
            ps.setString(5, user.getAlamat());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tambah data berhasil ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void update(User user) {
        try {
            ps = con.getCon().prepareStatement(update);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNama());
            ps.setString(4, user.getNoTelp());
            ps.setString(5, user.getAlamat());
            
            ps.setString(6, String.valueOf(user.getId()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ubah data berhasil ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            ps = con.getCon().prepareStatement(delete);
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hapus data berhasil ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void search(String key) {
        
    }
}