import com.sparrow.passport.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) throws SQLException {
        //JDBCUtils.executeSql("SELECT 1;");
        Connection connection = JDBCUtils.getConnection();
        ResultSet rs = JDBCUtils.query(connection, "SELECT user_name,`password` FROM `user` WHERE user_name='admin'");
        try {
            if (rs != null) {
                while (rs.next()) {
                    String userName = rs.getString("user_name");
                    System.out.println(userName);
                    String password = rs.getString("password");
                    System.out.println(password);
                }
            }
        } catch (Exception e) {
            return;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
