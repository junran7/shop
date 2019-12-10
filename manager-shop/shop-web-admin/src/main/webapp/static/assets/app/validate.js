/**
 * 函数对象 + 闭包 存放私有的js函数
 */
var Validation = function () {

    /**
     * 初始化 jQuery validation
     */
    var handlerInitValidate = function () {
        $("#inputForm").validate({
            errorElement: 'div',
            errorClass: 'is-invalid',

            //追加错误信息元素和class
            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });
    };

    /**
     * 增加自定义校验规则
     */
    var handlerInitCustomeValidate = function () {
        /**
         * 增加自定义验证规则
         */
        $.validator.addMethod("mobile", function (value, element) {
            var length = value.length;
            var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");
    };


    //存放：暴露给外面调用的js函数
    return {
        init: function () {
            handlerInitValidate();
            handlerInitCustomeValidate();
        }
    }

}();

/**
 * 页面初始化时，加载调用的函数
 */
$(document).ready(function () {
    Validation.init();
});