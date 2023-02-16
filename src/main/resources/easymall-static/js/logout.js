function logout(){
    $.ajax({
        url:"http://127.0.0.1/user/logout",
        dataType:"json",
        type:"GET",
        async: false,
        success:function (data) {
            clearAllCookies();
            window.location.href="./index.html";
        },
        error:function (data) {
            // alert("登出请求发送失败");
        }
    });
}

//清空所有的cookies, 本方法依赖于getAllCookies()，clearCookieByKey(key)
function clearAllCookies() {
    var keys = Object.keys(getAllCookies());
    keys.forEach(function (item) {
        clearCookieByKey(item);
    });
}
//获取所有的cookies
function getAllCookies() {
    var cookies = document.cookie.split(/;\s/g);
    var cookieObj = {};
    cookies.forEach(function (item) {
        var key = item.split('=')[0];
        cookieObj[key] = item.split('=')[1];
    });
    return cookieObj;
}
//通过key来获取cookie，本方法依赖于getAllCookies()
function getCookieByKey(key) {
    return getAllCookies()[key];
}
//通过key来删除cookie
function clearCookieByKey(key) {
    setCookie(key, "", -1);
}