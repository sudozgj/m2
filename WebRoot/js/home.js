$(document).ready(function() { // 返回顶部按钮
	$.goup({
		trigger : 100,
		bottomOffset : 100, // 距离下
		locationOffset : 20, // 距离右
		// title: 'This is a Demo',
		titleAsText : true
	});
});
$(function() {
	checkLogin(); // 加载页面时判断

	function checkLogin() { // 验证是否登录
		$.ajax({
			type : "post",
			url : "getSession",
			cache : false,
			dataType : "json",
			success : function(data) {
				if (data.code === 1) {
					$("#nav_user").html(data.data.username); //登录过，右上角显示用户名
				} else {
					$("#longinWarn").modal('toggle'); // 没有登录，则弹出登录框
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	}
	function getUserList() { // 加载用户列表，显示
		$.ajax({
			type : "post",
			url : "getUserList",
			cache : false,
			dataType : "json",
			success : function(data) {
				if (data.code === 1) {
					var tableData;
					for ( var i = 0; i < data.data.length; i++) {
						tableData += "<tr>" + "<td>" + data.data[i].id
								+ "</td>" + "<td>" + data.data[i].username
								+ "</td>" + "<td>" + data.data[i].name
								+ "</td>" + "<td>" + data.data[i].email
								+ "</td>" + "<td>" + data.data[i].createTime
								+ "</td>" + "</tr>";
					}
					$("#userTable tbody").html(tableData);
				} else {
					$("#longinWarn").modal('toggle');
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	}

	$("#editUserInfo").click(function() { // 编辑用户信息按钮（点击事件）
		$.ajax({
			type : "post",
			url : "getUser",
			cache : false,
			dataType : "json",
			success : function(data) {
				if (data.code === 1) {	//获取用户数据，填充编辑信息模态框，用于编辑
					$("#emId").val(data.data.id);
					$("#emUsername").val(data.data.username);
					$("#emName").val(data.data.name);
					$("#emEmail").val(data.data.email);
					$("#emTime").val(data.data.createTime);
					$("#nav_user").html(data.data.username);
					$("#editModal").modal('toggle');	//显示编辑信息模态框
				} else {
					$("#longinWarn").modal('toggle'); // 弹出登录模态框（没有登录，被拦截器拦截后进入）
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	});
	
	$("#editUserBtn").click(function() {	//提交编辑的用户信息（提交事件）
		var n = $("#emName").val();
		var e = $("#emEmail").val();
		$.ajax({
			type : "post",
			url : "updateUserDetail",
			cache : false,
			dataType : "json",
			data : {
				"name" : n,
				"email" : e
			},
			success : function(data) {
				if (data.data) {
					alert(data.msg);
					$("#editModal").modal('toggle');	
				} else {
					alert(data.msg);
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	});
	
	$("#chgPwdButton").click(function() { 	//提交修改的密码（提交事件）
		var op = $("#coPassword").val();
		var np = $("#cnPassword").val();
		var cp = $("#caPassword").val();
		if (op == "" || np == "" || cp == "") {
			alert("信息不完整");
		} else if (np != cp) {
			alert("两次密码不一致");
		} else {
			$.ajax({
				type : "post",
				url : "updateUserPassword",
				cache : false,
				dataType : "json",
				data : {
					"oPwd" : op,
					"nPwd" : np
				},
				success : function(data) {
					if (data.data) {
						alert(data.msg);
						$("#pwdModal").modal('toggle');
					} else {
						alert(data.msg);
					}
				},
				error : function(jqXHR) {
					alert("error");
				}
			});
		}
	});
	
	$("#logoutBtn").click(function() {			//注销按钮（提交事件）
		$.ajax({
			type : "post",
			url : "logout",
			dataType : "json",
			success : function(data) {
				if (data.data)
					location.href = "login.html";
			}
		});
	});
	
	$("#loginButton").click(function() { 		//登录按钮提交事件（提交事件）
		var u = $("#lUsername").val();
		var p = $("#lPassword").val();
		if (u == "" || p == "") {
			alert("信息不完整");
			return;
		}
		$.ajax({
			type : "post",
			url : "login",
			cache : false,
			dataType : "json",
			data : {
				"username" : u,
				"password" : p
			},
			success : function(data) {
				if (data.data) {
					location.reload();
					$("#longinWarn").modal('toggle');
				} else {
					alert(data.msg);
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	});
	
	$("#userList li").hover(function() {		//用户下拉列表的经过变色（经过事件）
		$(this).toggleClass("active");
	});
});