package com.movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class MoviesDBUtil {
	
	
	static Connection con = null;
	
	
	
	public void connect() throws ClassNotFoundException, SQLException {
       
	    Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies?allowPublicKeyRetrieval=true&useSSL=false","alex3","alex3");

	}
	
	
	public boolean getUser(String email,String password) throws SQLException {
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("SELECT password from users where email =" + "\"" +email + "\"" +";" );

		boolean result = false;
		while(rs.next()){

			String passwordDB=rs.getString(1);

			if(passwordDB.equals(password)){	
				//int user_id=Integer.parseInt(rs.getString(1));		
				result =  true;
			}else {
				result =  false;
			}
		}
		con.close();
		return result;

	}
	
	public boolean signUser(String email,String password) throws SQLException {
		
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("SELECT * from users where email =" + "\"" +email + "\"" +";" );

		if(rs.next()){
			return false;
		}else {
			PreparedStatement ps= con.prepareStatement("INSERT INTO users(email, password) VALUES(?,?);");
			ps.setString(1,email);
			ps.setString(2,password);
			int x = ps.executeUpdate();	
			return true;
		}
		
		
		
		
	}
	
	public static List<String> getBookmarks(String email) throws ClassNotFoundException, SQLException{
		ArrayList<String> bookmarks = new ArrayList();
		
		
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select bookmark from bookmarks where email =" + "\"" + email + "\"" + ";");
;	
		while(rs.next()) {
			String movie = rs.getString(1);
			bookmarks.add(movie);
		}
		
		for(int i = 0; i<bookmarks.size();i++) {
			System.out.println(bookmarks.get(i));
		}
		
		con.close();
		return bookmarks;
	}
	
    public void insertBookmark(String email,String bookmark) throws SQLException {
    	boolean flag =true;
    	Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select bookmark from bookmarks where email =" + "\"" + email + "\"" + ";");
		
		while(rs.next()) {
			String movie = rs.getString(1);
			System.out.println("-----------------------"+movie+"-----------------------");
			if(movie.equals(bookmark)) {
				flag=false;
				System.out.println("+++++++++++++++++++++"+movie+"++++++++++++++++++++++++");
				return;
			}
		}
		
		if(flag) {
			PreparedStatement ps= con.prepareStatement("INSERT INTO bookmarks(email, bookmark) VALUES(?,?);");
			ps.setString(1,email);
			ps.setString(2,bookmark);
			int x = ps.executeUpdate();	
			con.close();
		}
		
	}
    
    public void deleteBookmark(String email,String bookmark) throws SQLException, ClassNotFoundException {
		
		Statement st= con.createStatement();
		st.executeUpdate("DELETE FROM bookmarks where email =" + "\"" + email + "\" and bookmark =" + "\"" + bookmark + "\""  + ";");
		
		//con.close();
	}
	
	

}
