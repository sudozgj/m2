$(function(){
	$.ajax({
		type:"post",
		url:"getUserList",
		cache:false,
		dataType:"json",
		data:{"id":714},
		success:function(data){
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
				$("#longinWarn").modal('toggle');
			}
		},
		error:function(jqXHR){
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