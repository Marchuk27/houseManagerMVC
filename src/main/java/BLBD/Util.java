package BLBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL= "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USERNAME = "system";
    private static final String DB_PASSWORD = "RnkkrsPx333";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            System.out.println("1");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connect OK");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            System.out.println("Connect lost");
        }
    return connection;
    }

}
