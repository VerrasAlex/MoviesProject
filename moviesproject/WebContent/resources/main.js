'use script';



$(document).ready(function(){

    var typingTimer;    //timer identifier
    var doneTypingInterval = 4000; 
    var movie;
    var page ;

    //after 4 seconds search for movie title
    $('#title').on('keyup', function () {
        clearTimeout(typingTimer);
        movie = $('#title').val();
        page = 1;
        typingTimer = setTimeout(search(movie,page), doneTypingInterval);
    });

    //if user types again restart counting
    $('#title').on('keydown', function () {
        clearTimeout(typingTimer);
    });

    
    var plot;

    function search(movie,page){
    	
    	var movieOb;
    	//if movie empty dont search anything
    	if (movie === undefined) {return;}
        //get users input
        $.ajax({
         
            type:'GET',
            url: 'http://www.omdbapi.com/?t=' + encodeURI(movie) + '&apikey=119e5d5c',
            success: function(response){
            	console.log(movie);
                //console.log(response);               
                
               if(response.Response == "True"){
            	   plot = response.Plot;
                    movieOb = {
                		   title: response.Title,
                           plot: response.Plot,
                           poster: response.Poster ,
                           FullPlot: "No more plot information",
                           director: response.Director,
                           year: response.Year
                   }
               }
               
               $.ajax({

                   type: 'GET',
                   url: 'http://www.omdbapi.com/?t=' + encodeURI(movie) + '&plot=full&apikey=119e5d5c',
                   success: function(response2){
                   	if(response2.Response == "True"){
                   		movieOb.FullPlot = response2.Plot ;
                       	addContent(movieOb,page);
                       }
                   	
                   },
                   error: function(){
                       alert("Could not find Movie Title!")
                   }

               });
            },
            error: function(){
                alert("Could not find Movie Title!")
            }

        });
        
        
        
    }
    
    var contentTemplate = $('#template').html();
    
    function addContent(movieOb,page){
    	if(page ===1){
    		$('.showContent').empty();
        	$('.showContent').append(Mustache.render(contentTemplate,movieOb));
    	}else{
    		$('.showContent').append(Mustache.render(contentTemplate,movieOb));
    	}
    	
    }

    $('.showContent').delegate('.fullPlot','click',function(){
        console.log("butttttooooon");
        var $button = $(this);
        // class = hide --> Short Plot make it class=show --> full plot
        if($button.hasClass("hide")){
                $button.prev().prev().css("display","none"); //go to plot p tag
                $button.prev().css("display","initial");//go to full plot p tag
                $button.html("Hide full plot");
                $button.removeClass('hide');
                $button.addClass('show');
        }else{
            //old (short) plot
            $button.prev().prev().css("display","initial");
            $button.prev().css("display","none");
            $button.html('Click to see full plot');
            $button.removeClass('show');
            $button.addClass('hide');
        }


    });
        
        
    //if im in bookmarks page show bookmarks
    
        $('.movies').each(function(index){
            console.log("val         " +$(this).val());
            page = 2;
            search($(this).val(),page);
        });
 
});