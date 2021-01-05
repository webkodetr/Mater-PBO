package penjualan.detail;

import barang.Barang;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import penjualan.Penjualan;

/**
 *
 * @author GRK
 */
public interface PenjualanDetailDAO {

    public List<Barang> loadBarang();

    public DefaultTableModel refreshItem();

    public DefaultTableModel read(int penjualanId);

    public Double getTotalBayar();

    public void addItem(PenjualanDetail penjualanDetail);

    public void editItem(PenjualanDetail penjualanDetail, int row);

    public void deleteItem(int row);

    public void create(Penjualan penjualan);
}
