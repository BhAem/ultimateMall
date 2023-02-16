var callbackMessage = {
    '没收到货怎么办？': "可以致电xxx询问。",
    '如何查看物流？':"可以通过手机短信收到的邮递单号进行查询。",
    '邮费谁承担？':"具体可查看订货单。",
    '商品下单了发现收货地址填错怎么办':"可致电xxx询问"
}

function send() {
    let mes = document.getElementById("sendMessage");
    console.log(mes.value)
    if (mes.value){
        add(mes.value, "right");
    }else {
        alert("输入不能为空！");
    }
    mes.value = "";
}


function add(mes, direction){
    let body = document.getElementsByClassName("tbody")[0];
    direction = "talk-"+direction;
    body.innerHTML = body.innerHTML + ("<div class='"+direction+"'><p class='bubble'>"+mes+"</p></div>");
    callback(mes);
}

function callback(mes){
    let str = "";
    if(callbackMessage[mes]){
        str = callbackMessage[mes];
    }else {
        str = "我不晓得你在说什么，可以致电人工客服询问"
    }
    let body = document.getElementsByClassName("tbody")[0];
    body.innerHTML = body.innerHTML + ("<div class='talk-left'><p class='bubble'>"+str+"</p></div>");
}