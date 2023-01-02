package ymkim.passwordfx;

import java.sql.Connection;
import java.sql.DriverManager;

public class H2Connector {

    public Connection getConnection() throws Exception{

        try {
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection("jdbc:h2:./src/main/resources/ymkim/passwordfx/data", "sa", "");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
