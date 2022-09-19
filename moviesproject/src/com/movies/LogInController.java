package com.movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogInController {
	
	@RequestMapping("/LogIn")
	public String sign(@RequestParam("LogInEmail") String email,@RequestParam("LogInPW") String password, HttpSession session) throws ClassNotFoundException, SQLException{
		
		session.setAttribute("user", email);
		System.out.println(session.getAttribute("user"));
        MoviesDBUtil m = new MoviesDBUtil();
        m.connect();
        if(m.getUser(email, password)) {
        	return "mainPage.jsp";
        }else {
        	return "index.jsp";
        }
		
		
}

}
