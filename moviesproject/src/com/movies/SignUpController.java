package com.movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
	
	@RequestMapping(value="/SignUp")
	public String sign(@RequestParam("SignUpEmail") String email,@RequestParam("SignUpPW") String password,HttpSession session) throws ClassNotFoundException, SQLException{
		    
		   session.setAttribute("user", email);
		   System.out.println(session.getAttribute("user"));
		    MoviesDBUtil m = new MoviesDBUtil();
		    m.connect();
		    if(m.signUser(email, password)) {
	        	return "mainPage.jsp";
	        }else {
	        	return "index.jsp";
	        }
		  
			
	}

}
