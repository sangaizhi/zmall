/**
 * @Name zmall-validate
 * @Author sangaizhi
 * @Date 2017/4/10  22:03
 * @Version 1.0
 */
$().ready(function(){
    $.validator.setDefaults({
        debug: false,
        ignore: ""
    });
    $.validator.addMethod("phone", function (value, element) {
        var mobile = /^1\d{10}$/;
        return this.optional(element) || mobile.test(value);
    }, "请正确填写您的手机号码");
    $.validator.addMethod("telephone", function (value, element) {
        var tel = /^\d{3,4}-?\d{7,9}$/;
        return this.optional(element) || tel.test(value);
    }, "请正确填写您的固定电话");
    $.validator.addMethod("contact", function (value, element) {
        var mobile = /^1\d{10}$/;
        var tel = /^\d{3,4}-?\d{7,9}$/;
        return this.optional(element) || (tel.test(value) || mobile.test(value));
    }, "请正确填写您的联系方式");
    $.validator.addMethod("ltNow", function (value, element) {
        var now = new Date();
        var date = new Date(value);
        return this.optional(element) || date < now;
    }, "必须小于当前日期");
    $.validator.addMethod("selfEmail", function () {
        var tel = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[a-zA-Z0-9](?:[\w-]*[\w])?$/;
        return this.optional(element) || (tel.test(value));

    }, "邮箱格式不正确");
    //年龄段的正则验证
    $.validator.addMethod("ageBracket",function(value, element){
        var ageBracket = /^\d{1,2}\/-?\d{1,2}$/;
        return this.optional(element) || ageBracket.test(value);
    },"年龄段格式不正确，例：10-20");
    $.validator.addMethod("code",function(value,element){
        var code = /^[0-9a-zA-Z]/;
        return this.optional(element) || code.test(value);
    },"编码只能是数字，大小写字母");
    $.validator.addMethod("payAmount",function(value, element){
        var allCost = parseFloat($("#allCostHidden").val());
        return value <= allCost;
    },"已收款金额不能大于合约金额");
    $.validator.addMethod("email", function (value, element) {
        var email = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        return this.optional(element) || email.test(value);
    });
    $.validator.addMethod("notChinese", function (value, element) {
        var codeValue = $.trim(value.replace(/\s/g,""));
        var reg = /^[u4E00-u9FA5]+$/;
        return this.optional(element) || (reg.test(codeValue) || reg.test(codeValue));
    }, "编码不能输入中文");
});