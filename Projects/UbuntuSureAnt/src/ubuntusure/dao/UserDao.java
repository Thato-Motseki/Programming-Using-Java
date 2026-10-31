package ubuntusure.dao;
import ubuntusure.config.Database; import ubuntusure.model.UserRole; import ubuntusure.util.PasswordUtil; import java.sql.*;
public class UserDao {
 public UserRole authenticate(String username,String password) throws SQLException {String sql="SELECT role FROM users WHERE username=? AND password_hash=? AND active=TRUE";try(Connection c=Database.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,username);p.setString(2,PasswordUtil.sha256(password));try(ResultSet r=p.executeQuery()){if(r.next())return UserRole.valueOf(r.getString(1));return null;}}}
}
