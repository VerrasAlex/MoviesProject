package com.movies;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookmarksController {
	
	@RequestMapping(value="/saveMovie")
	public String saveBookmark(@RequestParam("title") String title,HttpSession session) throws ClassNotFoundException, SQLException{
		    System.out.println("IN SAVE MOVIES");
		    System.out.println(title);
		    MoviesDBUtil m = new MoviesDBUtil();
		    m.connect();
		    m.insertBookmark((String) session.getAttribute("user"),title);
            
		    return "mainPage.jsp";
			
			
	}
	
	@RequestMapping(value="/yourBookmarks")
	public ModelAndView getBookmarks(HttpSession session) throws ClassNotFoundException, SQLException{
		    
		    System.out.println("IN BOOKMARKS");
		    String user = (String) session.getAttribute("user");
		    MoviesDBUtil m = new MoviesDBUtil();
		    m.connect();
		    ArrayList<String> bookmarks = (ArrayList<String>) m.getBookmarks(user);
		    
		    ModelAndView mv = new ModelAndView();
			mv.setViewName("bookmarks.jsp");
			mv.addObject("bookmarks",bookmarks);
			System.out.println("ok im returning mv");
			return mv;
					
			
			
	}
	
	@RequestMapping(value="/deleteBookmark")
	public ModelAndView deleteBookmark(@RequestParam("title") String title,HttpSession session) throws ClassNotFoundException, SQLException{
		
		    System.out.println("IN BOOKMARKS");
		    
		    String user = (String) session.getAttribute("user");
		    
		    MoviesDBUtil m = new MoviesDBUtil();
		    m.connect();
		    m.deleteBookmark(user, title);
		    ArrayList<String> bookmarks = (ArrayList<String>) m.getBookmarks(user);
		    
		    ModelAndView mv = new ModelAndView();
			mv.setViewName("bookmarks.jsp");
			mv.addObject("bookmarks",bookmarks);
			System.out.println("ok im returning mv");
			
			return mv;
		    				
			
			
	}

}
