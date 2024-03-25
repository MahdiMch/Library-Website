package Dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import Classes.Livre;
import Classes.Order;

public class OrderDAO {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibept", "root", "ahmad0000");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block         
			e.printStackTrace();
		}
		return conn;
	}
	public static int newOrder(Order order){
        int status=0;
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO orders (id,nomLivre,userName) VALUES(?,?,?)");
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2, order.getBookName());
            preparedStatement.setString(3,order.getStudentName());
            status =preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
	}
       public void returnBookById(int id){
            Connection connexion = null;
            PreparedStatement preparedStatement = null;
            Statement statement=null;
            ResultSet resultat=null;
            try{
                connexion=getConnection();
                preparedStatement = connexion.prepareStatement("SELECT nomLivre FROM orders WHERE  id=?");
                preparedStatement.setInt(1, id);
                resultat=preparedStatement.executeQuery();
                String bookName = null;
                while (resultat.next()) {
                    bookName=resultat.getString("nomLivre");


                }
                System.out.println(bookName);
            }catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                connexion = getConnection();
                preparedStatement = connexion.prepareStatement("DELETE FROM orders WHERE id=?;");
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       
	public ArrayList<Order> getOrdersById(String userName){
        ArrayList<Order> orders=listOrders();
        ArrayList<Order> listorders=new ArrayList<Order>();
        for(Order order:orders){
            if(order.getStudentName()==userName)
                listorders.add(order);
        }
        return listorders;
    }
    public ArrayList<Order> listOrders(){
        ArrayList<Order> orders=new ArrayList<Order>();
        Connection connexion = null;
        Statement statement=null;
        ResultSet resultat = null;

        try {
            connexion = getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT userName,bookName,id FROM orders ");

            while (resultat.next()) {
                String userName = resultat.getString("userName");
                String bookName= resultat.getString("bookName");
                
                int id=resultat.getInt("id");
                Order order=new Order();
                order.setStudentName(userName);
                order.setBookName(bookName);
               
                order.setId(id);

                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    public static ArrayList<Order> notification()throws SQLException{
    	Connection connexion = getConnection();
        PreparedStatement pr = connexion.prepareStatement("select * from orders");   
        ResultSet rs = pr.executeQuery();
        ArrayList<Order> l = new ArrayList();
        while(rs.next()) {
        	Order o = new Order();
        	o.setBookName(rs.getString("nomLivre"));
        	o.setId(rs.getInt(1));
        	o.setStudentName(rs.getString("userName"));
        	l.add(o);
        }
		return l;
    }
   /* public ArrayList<Livre> getBooksOrderedByStudentId(String userName){
        ArrayList<Order> orders=listOrders();
        ArrayList<Livre> books=new ArrayList<Livre>();
        for(Order order:orders){
            if(order.getStudentName()==userName){
                String name=order.getBookName();
                System.out.println(name);
                Livre bb = new Livre();
                books.add(bb);
            }

        }
        return books;
    }*/
}

