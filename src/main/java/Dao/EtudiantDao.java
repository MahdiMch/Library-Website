package Dao;
import Classes.Etudiant;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EtudiantDao {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibept","root","ahmad0000");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block         
			e.printStackTrace();
		}
		return conn;
	}
	
	public static boolean login (Etudiant u) {
		boolean status = false;
		Connection conn;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("Select * from etudiant Where email=? and password=?");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		}catch(Exception e) {
			System.out.print(e);
		}
		return status;
	}
	public static int register (Etudiant s) {
		int status =0;
		Connection conn;
		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT into etudiant (email,userName,password) values (?,?,?)");
			ps.setString(1, s.getEmail());
			ps.setString(2, s.getUserName());
			ps.setString(3, s.getPassword());
			status = ps.executeUpdate();
		}catch(SQLException e) {
		e.printStackTrace();
		}
		return status;
	}

}