package penjualan;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author GRK
 */
public class PenjualanDAOImp implements PenjualanDAO{
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel dtm;
    private Koneksi con = new Koneksi();
    
    //query sql
    private String read = "select * from v_penjualan";
    private String delete = "delete from penjualan where id = ?";
    private String [] column = {"ID", "Tanggal/ Waktu", "Total Penjualan", "User"};

    @Override
    public void read(JTable table) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(read);
            while(rs.next()){
                Object[] o = new Object[4];
                o[0] = rs.getInt("id");
                o[1] = rs.getString("tanggal_waktu");
                o[2] = rs.getDouble("total");
                o[3] = rs.getString("user_nama");
                dtm.addRow(o);
            }
            table.setModel(dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(table, e.getMessage());
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
    public void cetak(String sumber) {
        File file = new File("src/report/" + sumber + ".jrxml");
        try {
            JasperDesign design = JRXmlLoader.load(file);
            JasperReport report = JasperCompileManager.compileReport(design);
            HashMap parameter = new HashMap();
            parameter = null;
            JasperPrint print = JasperFillManager.fillReport(report, parameter, new Koneksi().getCon());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(PenjualanDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}