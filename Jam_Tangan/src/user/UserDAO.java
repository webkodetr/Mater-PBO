package user;

import javax.swing.JTable;

/**
 *
 * @author GRK
 */
public interface UserDAO {
    public void read(JTable table);
    public void create(User user);
    public void update(User user);
    public void delete (int id);
    public void search(String key);
}