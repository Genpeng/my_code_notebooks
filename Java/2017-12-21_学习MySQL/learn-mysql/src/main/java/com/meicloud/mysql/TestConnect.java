package com.meicloud.mysql;

import java.sql.*;

/**
 * Test whether the MySQL Connector/J driver can connected to JDBC.
 *
 * @author Genpeng Xu
 * @date 2017/12/22
 */
public class TestConnect {
    // JDBC driver class and database url
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://10.16.26.215:3306/db_gxt_config_white_test";

    // Database user and password
    private static final String USER = "program";
    private static final String PASSWORD = "cx8sQ1qt";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Obtaining a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Execute query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM t_extr_dict LIMIT 100";
            rs = stmt.executeQuery(sql);

            // Display results
            while (rs.next()) {
                int id = rs.getInt("id");
                String domain = rs.getString("domain");
                String dimension = rs.getString("dimension");
                String attribute = rs.getString("attribute");
                String property = rs.getString("property");

                String output = "id: " + id + "\t" + "domain: " + domain + "\t" +
                                "dimension: " + dimension + "\t" + "attribute: " + attribute + "\t" +
                                "property: " + property;
                System.out.println(output);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // handle any errors
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
