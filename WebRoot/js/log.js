$(function() {
	$.ajax({
		type : "post",
		url : "getLogList",
		cache : false,
		dataType : "json",
		success : function(data) {
			if(data.code===1){
				var tableData;
				for(var i=0;i<data.data.list.length;i++){
					tableData+="<tr>"
									+"<td>"+data.data.list[i].id+"</td>"
									+"<td>"+data.data.list[i].username+"</td>"
									+"<td>"+data.data.list[i].operation+"</td>"
									+"<td>"+data.data.list[i].time+"</td>"
								+"</tr>";
				}
				$("#logTable tbody").html(tableData);
				alert("count: "+data.data.count);
				var count = data.data.count;
				var page;
				if(count%15===0)
					page=parseInt(count/15);	//除
				else
					page=Math.ceil(count/15);	//上取整	count/15+1
				
				alert("page: "+page);
				
				var pageLi ="<li><a href='#'>Prev</a></li>";
				for(var j=0;j<page;j++){
					var p=j+1;
					pageLi+="<li><a href='#'>"
								+p
							+"</a></li>";
				}
				pageLi +="<li><a href='#'>Next</a></li>";
				
				$("#pageIndex").html(pageLi);
			} else {
				$("#longinWarn").modal('toggle');
			}

		},
		error : function(jqXHR) {
			alert("error");
		}
	});

	$("#loginButton").click(function(){
		var user={
					"username":$("#lUsername").val(),
					"password":$("#lPassword").val()
				};
		$.ajax({
			type:"post",
			url:"login",
			cache:false,
			dataType:"json",
			data:user,
			success:function(data){
				if(data.data){
					location.reload();
					$("#longinWarn").modal('toggle');
				}else{
					alert(data.msg);
				}
			},
			error:function(jqXHR){
				alert("error");
			}
		});
	});
});