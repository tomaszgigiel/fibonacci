package pl.tomaszgigiel.fibonacci;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SQLFibonacci {

	public static int select(int n) {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream stream = loader.getResourceAsStream("H2/mem.properties");

			Properties properties = new Properties();
			properties.load(stream);
			@SuppressWarnings("unused")
			String driverClassName = properties.getProperty("datasource.driverClassName");
			String url = properties.getProperty("datasource.url");
			String username = properties.getProperty("datasource.username");
			String password = properties.getProperty("datasource.password");

			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT x FROM fibonacci_n WHERE n = " + n);
			rs.next();
			int result = rs.getInt(1);
			rs.close();
			connection.close();
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
