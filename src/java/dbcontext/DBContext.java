/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ACER
 */
public class DBContext {
    private final String serverName = "DINO";
    private final String dbName = "ThueXe";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "12345";

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    public static void main(String[] args) throws Exception {
        try {
            System.out.println(new DBContext().getConnection());
        } catch (Exception e) {
        }
    }
}
