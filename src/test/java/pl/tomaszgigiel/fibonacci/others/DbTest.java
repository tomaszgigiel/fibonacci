package pl.tomaszgigiel.fibonacci.others;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;
import pl.tomaszgigiel.fibonacci.utils.Fibonacci45Const;

@Log4j2
public class DbTest {

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
		ResultSet rs = statement.executeQuery("SELECT * FROM fibonacci_n");

		while (rs.next()) {
			Assertions.assertEquals(Fibonacci45Const.fibonacci.get(rs.getInt("n")), rs.getInt("x"));
		}
		rs.close();
		connection.close();

		Assertions.assertTrue(true);
		log.info("ok (java)");
	}
}
