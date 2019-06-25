package util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Tomek
 */
public class DbUtil {

    private static DataSource ds;

    public static Connection getCon() throws SQLException {

        return getInstance().getConnection();
    }

    private static DataSource getInstance() {

        if (ds == null) {

            try {

                Context ctx = new InitialContext();
                ds = (DataSource) ctx.lookup("java:comp/env/jdbc/bootcamp");

            } catch (NamingException e) {

                e.printStackTrace();
            }
        }
        return ds;
    }
}
