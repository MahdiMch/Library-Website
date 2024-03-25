package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Classes.Contact;

public class ContactDao {
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
	public static int ajouter_message (Contact s) {
		int status =0;
		Connection conn;
		conn = getConnection();
		try {
			System.out.println("nnn");
			PreparedStatement ps = conn.prepareStatement("INSERT into contact (email,userName,message) values (?,?,?)");
			ps.setString(1, s.getEmail());
			ps.setString(2, s.getUserName());
			ps.setString(3, s.getMessage());
			status = ps.executeUpdate();
		}catch(SQLException e) {
		e.printStackTrace();
		}
		return status;
	}
	public void supprimerMessage(Contact s) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = getConnection();
            preparedStatement = connexion.prepareStatement("delete from contact WHERE email=(?);");
            preparedStatement.setString(1, s.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
