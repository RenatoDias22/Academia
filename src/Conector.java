import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conector {
	public static Connection getConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/bd_empresa","root","renato17");
	}
}
