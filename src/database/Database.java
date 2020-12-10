package database;

import java.sql.*;

public class Database {
	
	private static Database instance = null;
	private Connection con=null;
	
	private final static String rutaMarce="F:\\Users\\Marcelo\\Java-ServerTurismoTM\\TurismoTierraMediaWeb\\src\\TurismoTierraMedia.db";
	private final static String rutaAntonio="";
	private final static String rutaEmilio="";
	private final static String rutaFlor="";
	
	private static final String dbURL="jdbc:sqlite:"+rutaMarce;//Cambiar este por el de ustedes
	
	
	private Database() {

			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con= DriverManager.getConnection(dbURL);
				System.out.println("conectado con la base de datos");
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

			try {
				if(con.isClosed()) {
					System.out.println("Nueva conexion abierta");
					Class.forName("org.sqlite.JDBC");
					con= DriverManager.getConnection(dbURL);

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
