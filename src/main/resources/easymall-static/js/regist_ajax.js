$(function() {
	//给验证码图片注册事件
	/*$("#vcode").click(
			function() {
				// $(this).attr("src","/VerifyCodeServlet?"+Math.random());
				$(this).attr("src",
						"user_ajax/verifyCode?" + new Date().toLocaleString());
			});*/
	
	// $("input[name=username]").blur(
	// 		function() {
	// 			var userName = $(this).val();
	// 			if (!formObj.checkNull("username", "用户名不能为空")) {
	// 				formObj.setMsg("username", "用户名不能为空");
	// 			} else {
	// 				$.ajax({
	// 					url:"/user/checkUserName",
	// 					type:"post",
	// 					data:{"userName":userName},
	// 					dataType:"json",
	// 					success:function(result){
	// 						if (result.status!=200) {
	// 							$("#username_msg").html("用户名已存在");
	// 						} else{
	// 							$("#username_msg").html("<font color='green'>用户名可用</font>");
	// 						}
	// 					},
	// 					error:function(){
	// 						alert("请求失败！");
	// 					}
	// 				});
	// 			}
	// 		});
	//给注册表单注册submit事件
	$("form").submit(function(){
		return register();
	});
});

function register(){
	var userName=$("form input[name=username]").val();
	var userPassword=$("form input[name=password]").val();
	var userPassword2=$("form input[name=password2]").val();
	// var userNickName=$("form input[name=nickname]").val();
	var userEmail=$("form input[name=email]").val();
	var vcode=$("form input[name=vcode]").val();
	var flag=formObj.checkForm();
	if(flag){
		var mydata = {
			"userName":userName,
			"userPassword":userPassword,
			"userMail":userEmail,
			"userKind": 0
		};
		mydata = JSON.stringify(mydata);
		$.ajax({
			url:"http://127.0.0.1/user/regist",
			type:"post",
			dataType:"json",
			data:mydata,
			contentType:'application/json;charset=UTF-8',
			success:function(result){
				// console.log(result)
				alert("注册成功,转向登录页面")
				window.location.href="../login.html";
			},
			error:function(){
				alert("请求失败！");
			}
		});
	}
	
	return false;
}

var formObj = {
	checkForm : function() {
		var flag = true;
		// 非空验证
		flag = this.checkNull("username", "用户名不能为空!");
		flag = this.checkNull("password", "密码不能为空") && flag;
		flag = this.checkNull("password2", "确认密码不能为空") && flag;
		// flag = this.checkNull("nickname", "昵称不能为空") && flag;
		flag = this.checkNull("email", "邮箱不能为空") && flag;
		// 两次输入的密码是否相同
		flag = this.checkPassword("password", "两次密码不相同") && flag;
		// 邮箱格式
		flag = this.checkEmail("email", "邮箱格式不正确") && flag;
		flag = this.checkNull("vcode", "验证码不能为空") && flag;
		// 返回flag
		return flag;
	},
	checkNull : function(name, msg) {
		var value = $("input[name=" + name + "]").val();
		if ($.trim(value) == "") {
			this.setMsg(name, msg);
			return false;
		}
		return true;
	},
	checkPassword : function(name, msg) {
		var pwd = $("input[name=" + name + "]").val();
		var pwd2 = $("input[name=" + name + "2]").val();
		if ($.trim(pwd) != "" && $.trim(pwd2) != "") {
			if (pwd != pwd2) {
				this.setMsg(name, msg);
				return false;
			}
		}
		return true;
	},
	checkEmail : function(name, msg) {
		var value = $("input[name=" + name + "]").val();
		var reg = /^\w+@\w+(\.\w+)+$/;
		if (!reg.test(value)) {
			this.setMsg(name, msg);
			return false;
		}
		return true;
	},
	setMsg : function(name, msg) {
		$("#" + name + "_msg").text(msg);
	}
};



function send_vcode(){
	var flag = true;
	var name = "email";
	var msg = "邮箱不能为空";
	var value = $("input[name=" + name + "]").val();
	if ($.trim(value) == "") {
		$("#" + name + "_msg").text(msg);
		flag = false;
	}

	if (flag) {
		var mydata = {'userMail': value};
		mydata = JSON.stringify(mydata);
		$.ajax({
			url:"http://127.0.0.1/user/sendMail",
			type:"POST",
			data: mydata,
			dataType:"json",
			contentType:'application/json;charset=UTF-8',
			success: function(res){
				var code = res.code;
				if (code == 1) {
					document.getElementById('mycode').value=res.data;
					$("#" + "vcode" + "_msg").text("验证码发送成功");
				} else {
					$("#" + "vcode" + "_msg").text(res.data);
				}
			},
			error:function(res){
				console.log(res)
				alert("验证码请求失败！");
			}
		});
	}
}