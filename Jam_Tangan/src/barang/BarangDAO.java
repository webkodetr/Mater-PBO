package barang;

import javax.swing.JTable;

/**
 *
 * @author GRK
 */
public interface BarangDAO {
    public void read(JTable table);
    public void create(Barang barang);
    public void update(Barang barang);
    public void delete (int id);
    public void search(String key);
    
}
