package penjualan.detail;

import barang.Barang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import penjualan.Penjualan;

/**
 *
 * @author GRK
 */
public class PenjualanDetailDAOImp implements PenjualanDetailDAO{
    private Koneksi con = new Koneksi();
    private PreparedStatement ps;
    private Statement s;
    private ResultSet rs;
    private Penjualan p;
    
    private String loadBarang = "select * from barang";
    
    private String insertPenjualan = "insert into penjualan (user_id, total)"
            + "values (?, ?)";
    private String insertPenjualanDetail = "insert into penjualan_detail (qty, sub_total,"
            + "penjualan_id, barang_id) values (?, ?, ?, ?)";
    private String loadItem = "select * from v_item_penjualan where penjualan_id =  ?";
    
    private List<PenjualanDetail> listPenjualanDetail;
    
    public PenjualanDetailDAOImp(){
        listPenjualanDetail = new ArrayList<>();
    }

    @Override   //1
    public List<Barang> loadBarang() {
        //instansiasi barangList
        List<Barang> barangList = new ArrayList<>();
        
        try {
            s = con.getCon().createStatement();
            rs = s.executeQuery(loadBarang);
            
            //proses pengisian barangList
            while(rs.next()){
              Barang barang = new Barang();
              barang.setId(rs.getInt("id"));
              barang.setNama(rs.getString("nama"));
              barang.setHarga(rs.getDouble("harga"));
              
              barangList.add(barang);
            }
        } catch (Exception ex) {
            Logger.getLogger(PenjualanDetailDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        //pengembalian nilai supplierList
        return barangList;
    }

    @Override   //2
    public DefaultTableModel refreshItem() {
        String[] column = {"ID Barang", "Nama Barang", "Harga", "Qty", "Sub Total"};
        DefaultTableModel dtm = new DefaultTableModel(null, column);
        
        for(int i=0; i<listPenjualanDetail.size(); i++){
            Object []o = new Object[5];
            o[0] = listPenjualanDetail.get(i).getBarang().getId();
            o[1] = listPenjualanDetail.get(i).getBarang().getNama();
            o[2] = listPenjualanDetail.get(i).getBarang().getHarga();
            o[3] = listPenjualanDetail.get(i).getQty();
            o[4] = listPenjualanDetail.get(i).getSubTotal();
            dtm.addRow(o);
        }
        return dtm;
    }

    @Override   //3
    public DefaultTableModel read(int penjualanId) {
        String columns[] = {"ID Barang", "Nama Barang", "Harga", "Qty", "Sub Total"};
        DefaultTableModel dtm = new DefaultTableModel(null, columns);
        try {
            ps = con.getCon().prepareStatement(loadItem);
            ps.setInt(1, penjualanId);
            ResultSet rs=  ps.executeQuery();
            while(rs.next()){
                Object [] o = new Object [5];
                o[0] = rs.getInt("barang_id");
                o[1] = rs.getString("nama");
                o[2] = rs.getDouble("harga");
                o[3] = rs.getInt("qty");
                o[4] = rs.getDouble("sub_total");
                dtm.addRow(o);
            }
        } catch (Exception ex) {
            Logger.getLogger(PenjualanDetailDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }         
        return dtm;
    }
    
    @Override   //4
    public Double getTotalBayar(){
        double total = 0;
        
        for(PenjualanDetail pd:listPenjualanDetail){
            total += pd.getSubTotal();
        }
        return total;
    }
    
    @Override   //5
    public void addItem(PenjualanDetail penjualanDetail) {
        listPenjualanDetail.add(penjualanDetail);
    }

    @Override   //6
    public void editItem(PenjualanDetail penjualanDetail, int row) {
        listPenjualanDetail.set(row, penjualanDetail);
    }

    @Override   //7
    public void deleteItem(int row) {
        listPenjualanDetail.remove(row);
    }

    @Override   //8
    public void create(Penjualan penjualan) {
        try {
            //simpan data penjualan
            ps = con.getCon().prepareStatement(insertPenjualan, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, penjualan.getUser().getId());
            ps.setDouble(2, penjualan.getTotal());
            ps.executeUpdate();
            
            //ambil generate key
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            this.p = new Penjualan();
            p.setId(rs.getInt(1));
            this.savePenjualanDetail(p.getId());
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void savePenjualanDetail(int id){
        try {
            ps = con.getCon().prepareStatement(insertPenjualanDetail);
            for(PenjualanDetail pd:listPenjualanDetail){
                ps.setInt(1, pd.getQty());
                ps.setDouble(2, pd.getSubTotal());
                ps.setInt(3, id);
                ps.setInt(4, pd.getBarang().getId());
                ps.executeUpdate();
            }
            listPenjualanDetail.clear();
            JOptionPane.showMessageDialog(null, "Data Penjualan Berhasil Disimpan ^^");
        } catch (Exception ex) {
            Logger.getLogger(PenjualanDetailDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
