package database;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DatabaseUtils {
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
