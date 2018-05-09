var username = getCookie('demo_username')
var password = getCookie('demo_password')
var flag = getCookie('demo_flag')
$("#username").val(username!=undefined&&username!=null?username:'')
$("#password").val(username!=undefined&&password!=null?password:'')
if (flag != undefined && flag != null){
    $("#remb").attr('checked','checked')
}

function go_to_register() {
    window.location.href = "register.jsp"
}

//点击登录按钮效果(登录按钮的id为`loginBtn`)
$("#loginBtn").on('click',function () {
    //按照通过input的id获取填写的值
    var username = $('#username').val()
    var password = $('#password').val()
    var param = {'name':username, 'password':password}
    post("user/login",param,function (result) {
        if (result.code == "200"){
            var flag = $('#remb').is(':checked')
            if (flag == true){
                setCookie('demo_username',username)
                setCookie('demo_password',password)
                setCookie('demo_flag',flag)
            }else {
                delCookie('demo_username')
                delCookie('demo_password')
                delCookie('demo_flag')
            }
            window.location.href = "index.jsp"
        }else if (result.code == "400"){
            alert(result.desc)
            window.location.href = "login.jsp"
        }else {
            //TODO:处理其他结果
        }
    });
})

//设置cookie
function setCookie(name,value) {
    var Days = 7
    var exp = new Date()
    exp.setTime(exp.getTime() + Days*24*60*60*1000)
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()
}
// 获取cookie
function getCookie(name) {
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg)){
        return unescape(arr[2])
    } else{
        return null
    }
}
//删除cookies
function delCookie(name) {
    var exp = new Date()
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name)
    if(cval!=null){
        document.cookie= name + "="+cval+";expires="+exp.toGMTString()
    }
}