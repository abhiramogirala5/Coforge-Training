package com.coforge.ems.util;

import java.sql.Connection;
import java.sql.*;

public class DBUtil {
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
				//Step - 1 Loading Driver
				Class.forName(ApplicationProperties.driver);
				
				//Step - 2 Connection with DB
				Connection connection = DriverManager.getConnection(ApplicationProperties.url , ApplicationProperties.userId , ApplicationProperties.password);
				return connection;
	}
}
