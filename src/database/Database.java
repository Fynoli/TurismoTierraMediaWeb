package database;

import java.sql.*;

public class Database {
	
	private static Database instance = null;
	private Connection con=null;
	
	
	private static final String dbURL="jdbc:sqlite:F:\\Users\\Marcelo\\Java-ServerTurismoTM\\TurismoTierraMediaWeb\\src\\TurismoTierraMedia.db";
	
	
	private Database() {

			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con= DriverManager.getConnection(dbURL);
				System.out.println("conectado");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public static Database getInstance() {
		if(instance==null) {
			instance=new Database();
				
		}
		return instance;
	}
	
	
	public Connection getConnection() {
		return con;
	}
	
	
	public Statement createStatement() {
		Statement s=null;
		try {
			s=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

}
