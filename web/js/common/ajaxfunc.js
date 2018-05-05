function post(url,param,callback){
    $.ajax({
        url : url,
        type : 'post',
        data : param,
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            callback(data);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
            enableSearchButton(true);
        },
        complete : function() {
        }
    });
}