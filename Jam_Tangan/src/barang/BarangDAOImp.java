package barang;

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
public class BarangDAOImp implements BarangDAO{
private Koneksi con = new Koneksi();
    private Statement s;
    private PreparedStatement ps;   //digunakan untuk menampung query yg blm lengkap datanya (yg msh ada tanda tanya)
    private ResultSet rs;
    private DefaultTableModel dtm;
    private final String[] column = {"ID", "NAMA", "DESKRIPSI", "HARGA", "STOK"};
    
    private String view = "select * from barang";
    private String insert = "insert into barang (nama, deskripsi, harga,"
            + "stok) values (?, ?, ?, ?, ?)";
    private String update = "update barang set nama=?, deskripsi=?, harga=?,"
            + " stok=? where id=?";
    private String delete = "delete from barang where id=?";
    private String search = "select * from barang where nama like %?%";
    
    @Override
    public void read(JTable table) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(view);  //eksekusi yg tdk merubah isi tabel
            while(rs.next()){
                Object[]col = new Object[5];
                col[0] = rs.getInt("id");
                col[1] = rs.getString("nama");
                col[2] = rs.getString("deskripsi");
                col[3] = rs.getDouble("harga");
                col[4] = rs.getInt("stok");
                dtm.addRow(col);
            }
            table.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void create(Barang barang) {
        try {
            ps = con.getCon().prepareStatement(insert);
            ps.setString(1, barang.getNama());
            ps.setString(2, barang.getDeskripsi());
            ps.setString(3, String.valueOf(barang.getHarga()));
            ps.setString(4, String.valueOf(barang.getStok()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tambah data berhasil ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void update(Barang barang) {
        try {
            ps = con.getCon().prepareStatement(update);
            ps.setString(1, barang.getNama());
            ps.setString(2, barang.getDeskripsi());
            ps.setString(3, String.valueOf(barang.getHarga()));
            ps.setString(4, String.valueOf(barang.getStok()));
            ps.setString(5, String.valueOf(barang.getId()));
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
