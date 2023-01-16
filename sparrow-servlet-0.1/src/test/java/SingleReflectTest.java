import com.sparrow.passport.dao.UserDao;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class SingleReflectTest {
    public static void main(
        String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        Class clazz = UserDao.class;

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor constructor = constructors[0];
        constructor.setAccessible(true);
        UserDao userDao = (UserDao) constructors[0].newInstance();

        System.out.println(userDao.getUserByUserName("admin"));
    }
}
