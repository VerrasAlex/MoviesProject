<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/style.css">
    <title>MovieDb</title>
</head>
<body>
      
      <!-- user types movie -->
      <div align="center">
         <form action="#" id = "form">
             <label for="title" style = "color:white;">Movie Title:</label> <br> <br>
             <input type="text" id="title" name="title" placeholder="Enter Movie Title" style = "width:30%;"> <br>                
      	 </form> <br>
      	 
      	 <!-- click to go to users bookmarks -->
        <form action = "yourBookmarks">
           <input type="submit" value="Your Bookmarks" id = "bookmarks" style = "width:30%;"/>
        </form>
       </div>
      
        
        
        
        <!-- display search results -->
        <div class = "showContent search">
        <template id = "template">
        <div>
           <p>{{title}}</p>
           <div>Director: {{director}}</div>
           <div>Year: {{year}}</div>
           <img src='{{poster}}' alt="poster" class ="poster">
           <p class = "plot">{{plot}}</p>
           <p class = "full" style = "display:none;">{{FullPlot}}</p>
           <button class="fullPlot hide" >Click to see full plot</button>
           <!-- save movie to bookmarks -->
           <form action = "saveMovie">
                <input type = "hidden" class="movies"  name = "title" value = '{{title}}' />
                <input type="submit" value="Save to Bookmarks" id = "bookmarks" style = "width:100%;" />
           </form>
           </div>
        </template>
        </div>
        
          
    
	<footer style="margin-top:20%;"  align="center">
		<form action="index.jsp">
	        <input type="submit" value="LOG OUT"  style="padding:1%;" >
	    </form>
	</footer>


    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/mustache.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/main.js"></script>
</body>
</html>