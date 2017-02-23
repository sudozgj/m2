$(function(){
	$.ajax({
		type:"post",
		url:"getUserList",
		cache:false,
		dataType:"json",
		data:{"id":714},
		success:function(data){
			debugger;
			if(data.code===1){
				var tableData;
				for(var i=0;i<data.data.length;i++){
					tableData +="<tr>"
									+ "<td>" +data.data[i].id + "</td>"
									+ "<td>" +data.data[i].username + "</td>"
									+ "<td>" +data.data[i].name + "</td>"
									+ "<td>" +data.data[i].email + "</td>"
									+ "<td>" +data.data[i].createTime + "</td>"
								+ "</tr>";
				}
				$("#userTable tbody").html(tableData);
			}else{
				alert("error");
			}
		},
		error:function(jqXHR){
			alert("error");
		}
	});

	$("#learnMore").click(function(){
		alert("...");
	});
});