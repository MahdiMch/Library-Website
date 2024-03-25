package Dao;

import Classes.Livre;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class LivreDao {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibept","root","ahmad0000");
		} catch (Exception e) {
			// TODO Auto-generated catch block         
			System.out.println("hello");
		}
		return conn;
	}
	
	public static int ajouterLivre(Livre book) {
		int st=0;
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        System.out.println(book.getNomLivre());
        connexion = getConnection();
        try {
            preparedStatement = connexion.prepareStatement("INSERT INTO Livre (nom_livre,domaine_id_FK,sous_domaine_id_FK,nom_auteur_FK,Edition) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, book.getNomLivre());
            preparedStatement.setString(2, book.getDomaineIdFk());
            preparedStatement.setString(3, book.getSousDomaineIdFk());
            preparedStatement.setString(4, book.getNomsAuteurFk());
            preparedStatement.setString(5, book.getEdition());
            st = preparedStatement.executeUpdate();
        } catch (Exception e) {
           System.out.println(e);
        }
       return st;
    }
	public static Livre recherche(String s)throws SQLException{
		Livre l = new Livre();
		 Connection connexion = null;
	     String str="select * from Livre where nomLivre = '"+s+"'";
		 PreparedStatement preparedStatement = connexion.prepareStatement(str);
		 ResultSet rs = preparedStatement.executeQuery();
		 if(rs.next()) {
			 l.setDomaineIdFk(rs.getString("domaine_id_FK"));
			 l.setEdition(rs.getString("Edition"));
			 l.setNomLivre(s);
			 l.setNomsAuteurFk(rs.getString("nom_auteur_FK "));
			 l.setSousDomaineIdFk(rs.getString(" sous_domaine_id_FK"));
		 }
		return l;
		
		
			}
	public static int  supprimerLivre(Livre book) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        int st=0;
        try {
            connexion = getConnection();
            preparedStatement = connexion.prepareStatement("delete from Livre WHERE NomLivre=(?);");
            preparedStatement.setString(1, book.getNomLivre());
            st=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
	public ArrayList<Livre> list() {
        ArrayList<Livre> books = new ArrayList<Livre>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT nom_livre, domaine_id_FK, sous_domaine_id_FK, nom_auteur_FK, Edition FROM Livre;");

            while (resultat.next()) {
              
                String title = resultat.getString("nom_livre");
                String category = resultat.getString("domaine_id_FK");
                String author = resultat.getString("sous_domaine_id_FK");
                
                String sousDomaine = resultat.getString("nom_auteur_FK");
                String edition = resultat.getString("Edition");

                Livre book = new Livre();
                book.setNomsAuteurFk(edition);
                book.setDomaineIdFk(sousDomaine);
               
                book.setNomLivre(edition);
                book.setSousDomaineIdFk(sousDomaine);
                book.setEdition(edition);


                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
	
	public Livre getBookByName(String title) {
        ArrayList<Livre> lst = list();
        for (Livre book : lst) {
            if ((book.getNomLivre()).equals(title))
                return book;
        }
        return new Livre();
    }
	public static void main(String[] args) throws SQLException {
		String s ="Algorithmes en c++";
		Livre L=recherche(s);
		System.out.println(L.getNomLivre());
	}
}
