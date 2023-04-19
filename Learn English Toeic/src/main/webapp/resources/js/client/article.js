$(document).ready( function () {
   ajaxGet(1);
   function ajaxGet(page) {
       $.ajax({
           type: "GET",
           url: "/api/client/bai-bao/allArticles?page=" + page,
           success: function (result) {
                if (result.totalElements > 0) {
                    $("#pTag").removeClass().addClass("hidden");
                    $.each(result.content, function (i, baiBao) {
                        var html = '<div class="span9">'
							+ '<div class="span3">'
							+    '<img class="imageExam" src="'+ baiBao.image + '"/>'
							+' </div>'
							+ '<div class="span1"></div>'
							+ '<div class="span5"> '
							+    '<h3 style="font-weight: bold" class="content-heading" id="title"><a href="/article?id='+baiBao.id+'">' +
                            ''+ baiBao.title + '</a></h3>'
                            +    '<p class="">'+ baiBao.description + '</p>'
							+    '<a class="btn btn-primary" href="/article?id='+baiBao.id+'"> Xem thêm</a>'
                            +  '<hr>'
							+  '</div>'
							+ '</div>';
                        $('.danhSach').append(html);
                    });

                    if (result.totalPages > 1) {
                        for ( var numberPage = 1; numberPage <= result.totalPages; numberPage++) {
                            var li = '<li class="page-item "><a class="pageNumber ">'+numberPage+'</a></li>';
                            $('.ul-pagination').append(li);
                        }

                        //active page pagination
                        $(".pageNumber").each(function(index){
				    		if($(this).text() == page){
				    			$(this).parent().removeClass().addClass("page-item active");
				    		}
				       });
                    }
                }
                else {
				   $("#pTag").removeClass("hidden");
			   }
           },
           error : function(e){
				alert("Error: ",e);
				console.log("Error" , e );
           }
        });
    }

    $(document).on('click', '.pageNumber', function (event){
//		event.preventDefault();
		var page = $(this).text();
    	$('.danhSach div').remove();
    	$('.pagination li').remove();
    	ajaxGet(page);
	});
});
