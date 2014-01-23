package com.questions.connect;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
public class DBConnector {
	private static Connection connection = null;
	private static DBConnector dbloader = null;
	static Properties prop = null;
//	public static Logger logger = LoggerFactory.getLogger("DBConnector");
	private static String host="localhost";
	private static String db="question";
	private static String dbuser="root";
	private static String dbpassword="root";

	public static DBConnector getInstance()
	{
		// Load the JDBC driver
		if (dbloader == null || connection==null)
		{
			dbloader = new DBConnector();
			prop = new Properties();
			String driverName = "com.mysql.jdbc.Driver";
			//				logger.info("Loading properties file for db connection");
							System.out.println("connector");
			//				InputStream resourceAsStream =  DBConnector.class.getClassLoader().getResourceAsStream("dbprop.properties");
			//			    prop.load(resourceAsStream);
			//				host = prop.getProperty("mysqlhost");
			//				db = prop.getProperty("db");
			//				dbuser = prop.getProperty("user");
			//				dbpassword = prop.getProperty("password");
			//				System.out.println(db.toString());
							System.out.println(dbuser.toString());
							System.out.println(db.toString());
			//				logger.info("property file loaded!");
			try
			{
//				logger.info("Getting JDBC driver");
				Class.forName(driverName);
				String url = "jdbc:mysql://" + host + ":3306" + "/" + db + "?autoReconnect=true";
//				logger.info("Creating connection with database");
				System.out.println(url);
				Connection connection = DriverManager.getConnection(url, dbuser, dbpassword);
//				logger.info("Setting Connection to global variable very first time");
				dbloader.setConnection(connection);
				System.out.println("donw");
			} catch (SQLException | ClassNotFoundException e)
			{
//				logger.error("Error creation of connection" + e.getMessage());
			}
		}
		return dbloader;
	}

	public ResultSet executePreparedStatement(PreparedStatement stmt) throws SQLException
	{
//		logger.info("Executing prepared statment");
		ResultSet rs = stmt.executeQuery();
		return rs;
	}

	public int queryCount(String query) throws SQLException, IOException
	{
		Statement stmt = connection.createStatement();
		int i = stmt.executeUpdate(query);
		stmt.close();
//		logger.info(query + " Count " + i);
		return i;
	}

	public synchronized PreparedStatement getPrepareStatment(String query) throws SQLException
	{
		PreparedStatement prepared = connection.prepareStatement(query);
		return prepared;
	}

	public Statement getStatement() throws SQLException, IOException
	{
		/*logger.info("Getting connection statment");*/
		Statement prepared = connection.createStatement();
		return prepared;
	}

	private void setConnection(Connection connection)
	{
		DBConnector.connection = connection;
	}
    @Deprecated
	public ResultSet queryResult(String query) throws IOException
	{
		ResultSet rst = null;
		Statement stmt=null;
		try
		{
			stmt = connection.createStatement();
			rst = stmt.executeQuery(query);
		} catch (SQLException e)
		{
//			logger.error("Error while getting result for " + query + e.getMessage());
		}
		
		return rst;
	}
    
/*;*/

	public synchronized Connection getNewConnection() throws SQLException
	{
//		logger.info("Getting a new connection for transaction...");
		String url = "jdbc:mysql://" + host + "/" + db;
		Connection connection = DriverManager.getConnection(url, dbuser, dbpassword);
		return connection;
	}
}
