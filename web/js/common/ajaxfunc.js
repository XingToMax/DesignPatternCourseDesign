function post(url,param,callback){
    $.ajax({
        url : url,
        type : 'post',
        data : param,
        dataType : 'json',
        success : function(data, status) {
            if (status == "success") {
                callback(data);
            }
        },
        error : function(data, status, e) {
            alert("连接超时");
        },
        complete : function() {
        }
    });
}