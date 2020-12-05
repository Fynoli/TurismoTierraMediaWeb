package database;

import java.sql.*;

public class Database {
	
	public static Connection connect(){
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con =DriverManager.getConnection("jdbc:sqlite:TurismoTierraMedia.db");
            System.out.println("Conexion exitosa");
        }catch (ClassNotFoundException | SQLException exception){
            System.out.println(exception+"");
        }
        return con;
    }
	
	/*private static Database instance = null;
	private Connection con=null;
	
	
	private static final String dbURL="jdbc:sqlite:db/src/TurismoTierraMedia.db";
	
	
	private Database() {
		try {
			con= DriverManager.getConnection(dbURL);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static Database getInstance() {
		if(instance==null) {
			instance=new Database();
				
		}
		return instance;
	}
	
	public Statement createStatement() {
		Statement s=null;
		try {
			s=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return s;
	}*/

}
