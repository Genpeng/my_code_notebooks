import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMysql {
	// JDBC driver class and database url
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";

	// Database user and password
	private static final String USER = "root";
	private static final String PASSWORD = "911227";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// register JDBC driver
			Class.forName(JDBC_DRIVER);

			// obtaining a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			// execute query
			stmt = conn.createStatement();
			String sql = "SELECT * FROM websites";
			rs = stmt.executeQuery(sql);

			// display results
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");

				String output = "id: " + id + "\t" + 
								"name: " + name + "\t" +
								"url: " + url;
				System.out.println(output);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}