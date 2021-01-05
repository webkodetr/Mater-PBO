package login;

/**
 *
 * @author GRK
 */
public interface LoginDAO {
    public void login (String username, String password);
    public void logout();
}
