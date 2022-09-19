<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieDb</title>
<link rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
    
    <h1 id = "mybookmarks" style ="color: #F5C518;">Your Bookmarks</h1>
    
    <div>
       <form action = "mainPage.jsp" style = "margin:1%;">
          <input type = "submit" value = "Back to main Page" style = "padding: 0.5%;" />
       </form>
       
       <form action="index.jsp" style = "margin:1%;">
	        <input type="submit" value="LOG OUT"  style="padding:0.5%;">
	    </form>
    </div>
    
		
	

    <div class = "bookmarks">
        <input type = "hidden" id = "movies" value = '${bookmarks}' />
         
        
        
	    <c:forEach var = "tit" items = "${bookmarks}">
	    
	        <input type = "hidden" class = "movies" value = '<c:out value = '${tit}'/>' />


	       
	    </c:forEach>
	    
	    
	    
	    <!-- display search results -->
        <div class = "showContent">
        <template id = "template">
           <div>
           <p> {{title}}</p>
           <div>Director: {{director}}</div>
           <div>Year: {{year}}</div>
           <img src='{{poster}}' alt="poster" class ="poster">
           <p class = "plot">{{plot}}</p>
           <p class = "full" style = "display:none;">{{FullPlot}}</p>
           <button class="fullPlot hide" >Click to see full plot</button>
           <!-- delete movie from bookmarks -->
           <form action = "deleteBookmark" >
             <input type = "hidden" name = "title" value = '{{title}}'  />
             <input type="submit" value="Remove Bookmark" class = "delete"/>
           </form>
           </div>
        </template>
        </div>
        
	       
	    
     </div>




    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/mustache.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/main.js"></script>
</body>
</html>