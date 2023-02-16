//@ sourceURL=login_ajax.js
$(function(){

	//给form表单添加submit事件
	$("form").submit(function(){
		return login();
	});
	
});
function login(){
	//获取页面数据
	var userName=$("form input[name=username]").val();
	var userPassword=$("form input[name=password]").val();
	if(userName==""){
		$("form table tr:eq(0) td span").html("用户名不能为空");
		return false;
	}
	if(userPassword==""){
		$("form table tr:eq(1) td span").html("密码不能为空");
		return false;
	}

	var mydata = {"userName":userName,"userPassword":userPassword};
	mydata = JSON.stringify(mydata);
	console.log(mydata);
	$.ajax({
		url:"http://127.0.0.1/user/loginByPassword",
		type:"post",
		data:mydata,
		contentType:'application/json;charset=UTF-8',
		dataType:"json",
		success:function(result){
			console.log(result)
			if (result.code == 0) {
				alert(result.msg);
			} else if (result.code == 1) {
				alert("登陆成功！");
				// result是服务端返回的数据
				document.cookie = "userName="+userName;
				document.cookie = "userPassword="+userPassword;
				window.location.href="index.html";
			}
		},
		error:function(){
			alert("请求失败!");
		}
	});
	
	return false;
}
