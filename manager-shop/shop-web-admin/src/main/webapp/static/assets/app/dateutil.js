/**
 * 函数对象 + 闭包 存放私有的js函数
 */
var DateOper = function () {
    var handlerGetDateByTimeStamp = function (timeStamp) {
        if(typeof(timeStamp)=="undefined"){
            return "";
        }
        var oDate = new Date(timeStamp),
            oYear = oDate.getFullYear(),
            oMonth = oDate.getMonth()+1,
            oDay = oDate.getDate(),
            oHour = oDate.getHours(),
            oMin = oDate.getMinutes(),
            oSen = oDate.getSeconds(),
            oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间

        return oTime;
    };
    //补0操作,当时间数据小于10的时候，给该数据前面加一个0
    var getzf = function(num){
        if(parseInt(num) < 10){
            num = '0'+num;
        }
        return num;
    };



    //存放：暴露给外面调用的js函数
    return {
        getDateByTimeStamp : function (timeStamp) {
           return handlerGetDateByTimeStamp(timeStamp);
        }
    }
}();
