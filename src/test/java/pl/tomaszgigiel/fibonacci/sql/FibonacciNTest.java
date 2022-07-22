package pl.tomaszgigiel.fibonacci.sql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciNTest {

	final int COUNT = 45;

	@Test
	void test() throws Exception {
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
		ResultSet rs = statement.executeQuery("SELECT count(*) FROM fibonacci_n WHERE n < " + COUNT);
		rs.next();
		int count = rs.getInt(1);
		rs.close();
		connection.close();

		Assertions.assertEquals(COUNT, count);
	}
}
