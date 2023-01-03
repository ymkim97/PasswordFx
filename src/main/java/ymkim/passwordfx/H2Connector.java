package ymkim.passwordfx;

import java.sql.Connection;
import java.sql.DriverManager;

public class H2Connector {

    public Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:./src/main/resources/ymkim/passwordfx/data", "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
