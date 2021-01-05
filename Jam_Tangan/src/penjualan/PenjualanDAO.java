package penjualan;

import javax.swing.JTable;

/**
 *
 * @author GRK
 */
public interface PenjualanDAO {
    public void read(JTable table);
    public void delete(int id);
    public void cetak(String sumber);
}