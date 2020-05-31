package utility;

import oracle.jdbc.OracleConnection.CommitOption;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;

public class ConnectionManager{
	public static Connection getConnection() throws Exception {
		
		Connection con= null;
		Properties p = loadPropertiesFile();
		String driver = p.getProperty("driver");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		Class.forName(driver);
		
		con = DriverManager.getConnection(url,username,password);
		return con;
	}
	
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
}
