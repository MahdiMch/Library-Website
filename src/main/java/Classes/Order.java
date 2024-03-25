package Classes;

import java.sql.Date;

public class Order {
	    private int id;
	    private String nomLivre;
	    private String userName;
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getBookName() {
	        return nomLivre;
	    }

	    public void setBookName(String nomLivre) {
	        this.nomLivre = nomLivre;
	    }

	    public String getStudentName() {
	        return userName;
	    }

	    public void setStudentName(String userName) {
	        this.userName = userName;
	    }

}
