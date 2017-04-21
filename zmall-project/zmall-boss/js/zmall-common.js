/**
 * @Name zmall-common
 * @Author sangaizhi
 * @Date 2017/3/25  23:14
 * @Version 1.0
 */


/**
 * js util（工具）
 * Created by saz on 2017/2/27.
 */

/**
 * 字符串相关
 * @type {{}}
 */
var zmallString = {
    /**
     * 判断是否为空，空格也算为空
     * @param str
     * @return true 不为空， false 为空
     */
    isNotBlank: function (str) {
        if (str == null || str == '' || str == undefined) {
            return false;
        }
        if (str.replace(/(^s*)|(s*$)/g, "").length == 0) {
            return false;
        }
        return true;
    },
    /**
     * 判断字符串是否是以某个字符串开头
     * @param sourceStr
     * @param startStr
     * @returns {boolean}
     */
    isStartWith: function (sourceStr, startStr) {
        if (startStr == null || startStr == "" || sourceStr.length == 0 || startStr.length > sourceStr.length) {
            return false;
        }
        if (sourceStr.substr(0, startStr.length) == startStr) {
            return true;
        }
        return false;
    },
    /**
     * 判断字符是否是以某个字符串结尾
     * @param sourceStr
     * @param endStr
     * @returns {boolean}
     */
    isEndWith: function (sourceStr, endStr) {
        if (endStr == null || endStr == "" || sourceStr.length == 0 || endStr.length > sourceStr.length) {
            return false;
        }
        if (sourceStr.substr(sourceStr.length - endStr.length) == endStr) {
            return true;
        }
        return false;
    },
    /**
     * 去除字符串中的特殊字符（.*+?^=!:${}()'"“’%|[\]/）
     * @param str
     * @returns {XML|*|void|string}
     */
    removeSpecialChar: function (str) {
        var result = str.replace(/([.*+?^=!:${}()'"“‘%|[\]\/\\])/g, ""); //$&表示被匹配的字符串
        return result;
    }
};


/**
 * URL 相关
 * @type {{}}
 */
var zmallURL = {
    /**
     * 获取请求参数列表,
     * @param url
     * @returns {} 参数数组:json 格式
     */
    getURLParams: function (url) {
        url = decodeURI(url);
        var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
        var params = [];
        var i, j;
        for (i = 0; j = paraString[i]; i++) {
            var key = j.substring(0, j.indexOf("=")).toLowerCase();
            var value = j.substring(j.indexOf("=") + 1, j.length);
            var param = {key: key, value: value};
            params.push(param);
        }
        return params;
    },
    /**
     * 获取URL的参数列表，返回一个参数数组，数组元素的下标是参数名，数组元素的值是参数值
     * @param url
     * @returns {{}}
     */
    getURLParamsWithReturnArray: function (url) {
        url = decodeURI(url);
        var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
        var params = {};
        var i, j;
        for (i = 0; j = paraString[i]; i++) {
            params[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
        }
        return params;
    },
    /**
     * 获取请求 URL 中某个参数的值
     * @param url 请求URL
     * @param paramName 参数名称
     * @returns {*}
     */
    getSingleParamValue: function (url, paramName) {
        url = decodeURI(url);
        var params = zmallURL.getURLParams(url);
        if (params != null && params.length > 0) {
            for (var i = 0; i < params.length; i++) {
                var key = params[i].key;
                if (key == paramName) {
                    return params[i].value;
                }
            }
        }
        return null;
    },

    /**
     * 移除请求 URL 中的某个参数
     * @param url url
     * @param param 要去除的参数名
     * @returns 新的URL
     */
    removeParam: function (url, paramName) {
        url = decodeURI(url);
        var oldParams = zmallURL.getURLParams(url);
        var urlWithoutParam = url.substring(0, url.indexOf("?"));
        var newParams = '';
        //遍历旧的参数列表，移除指定参数并拼接新的参数列表
        if (null != oldParams && oldParams.length > 0) {
            for (var i = 0; i < oldParams.length; i++) {
                var key = oldParams[i].key;
                if (key != paramName) {
                    var value = oldParams[i].value;
                    newParams += "&" + key + "=" + value;
                }
            }
        }

        //去除新的参数列表中的第一个 & 符号
        newParams = newParams.substring(0, newParams.indexOf("&"))
            + newParams.substring(newParams.indexOf("&"),
                newParams.length);
        return urlWithoutParam + newParams;
    },
    /**
     * 移除所有参数
     * @param url
     * @returns {string}
     */
    removeAllParam: function (url) {
        url = decodeURI(url);
        var urlWithoutParam = url.substring(0, url.indexOf("?"));
        return urlWithoutParam;
    },
    /**
     * url 是否包含某个参数,忽略大小写
     * @param url
     * @param param
     * @returns {boolean}
     */
    containsParam: function (url, param) {
        url = decodeURI(url);
        if (url.indexOf("?") != -1) {
            var urlParams = url.substr(url.indexOf("?") + 1).split("&");
            for (var i = 0; i < urlParams.length; i++) {
                var paramName = urlParams[i].substr(0, urlParams[i].indexOf("=")).toLowerCase();
                if (paramName == param.toLowerCase()) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    },
    /**
     * 添加一个参数
     * 如果有该参数，则替换该参数的值
     * @param url url
     * @param paramName 参数名
     * @param paramValue 参数值
     * @returns {*} 新的URL
     */
    addParam: function (url, paramName, paramValue) {
        url = decodeURI(url);
        if (url.indexOf("?") != -1) {
            // url 本身有参数
            var urlParamStr = url.substr(url.indexOf("?") + 1);
            if (urlParamStr == null || urlParamStr == '') {
                return url + paramName + "=" + paramValue;
            }
            var urlParams = urlParamStr.split("&");
            if (!zmallURL.containsParam(url, paramName)) {
                // url本身没有这个参数
                return url + '&' + paramName + "=" + paramValue;
            } else {
                // url 本身有这个参数
                for (var i = 0; i < urlParams.length; i++) {
                    var tempParamName = urlParams[i].substr(0, urlParams[i].indexOf("=")).toLowerCase();
                    var tempParamValue = urlParams[i].substr(urlParams[i].indexOf("=") + 1).toLowerCase();
                    if (paramName == tempParamName) {
                        tempParamValue = paramValue;
                        urlParams[i] = tempParamName + "=" + tempParamValue;
                    }
                }
                return url.substr(0, url.indexOf("?") + 1) + urlParams.join("&");
            }
        } else {
            url += "?" + paramName + "=" + paramValue;
            return url;
        }
    }
};

/**
 * 日期相关
 * @type {{}}
 */
var zmallDate = {
    /**
     * 验证日期格式是否合法：不能包含时间信息
     * @param date
     * @returns {boolean}
     */
    isValidDate:function(date){
        var result = date.match(/^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/);
        return null != result;
    },
    /**
     * 日期格式化
     * @see Date.property.format
     * @param fmt
     */
    // 格式化时间
    format: function (val) {
        if (!zmallString.isNotBlank(val)) {
            return '';
        }
        var now = new Date(val);
        return now.format("yyyy/MM/dd hh:mm:ss");
    },
    /**
     * 按指定格式格式化日期
     * @param date 需格式化的日期
     * @param style 格式化的格式
     * @returns {*}
     */
    formatWithStyle: function (date, style) {
        date = new Date(date);
        var o = {
            "M+": date.getMonth() + 1, //月份
            "d+": date.getDate(), //日
            "h+": date.getHours(), //小时
            "m+": date.getMinutes(), //分
            "s+": date.getSeconds(), //秒
            "q+": Math.floor((date.getMonth() + 3) / 3), //季度
            "S": date.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(style)) style = style.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(style)) style = style.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return style;
    },
    /**
     * 获取年龄
     * @param date 年份
     * @returns {*}
     */
    age: function (date) {
        if (!zmallString.isNotBlank(date)) {
            return '';
        }
        var now = new Date();
        return now.getFullYear() - parseInt(date);
    },
    /**
     * 星期几
     * @param date
     * @returns {string}
     */
    weekName: function (date) {
        var time = new Date(date);
        var weeks = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
        var day = time.getDay();
        return weeks[day];
    },
    /**
     * 某个日期据今天的天数
     * @param date
     * @param containToday
     * @returns {*}
     */
    dayDiffToToday: function (date, containToday) {
        if (!zmallString.isNotBlank(date)) {
            return null;
        }
        if (typeof  date == 'string') {
            date = new Date(date);
        }
        if (containToday == '' || containToday == null || containToday == undefined) {
            containToday = true;
        }
        var today = new Date();
        if (today.DateDiff('d', date) < 0) {
            return 0;
        }
        if (containToday) {
            return today.DateDiff('d', date) + 1;
        } else {
            return today.DateDiff('d', date);
        }
    },
    /**
     * 日期比较,startDate > endDate 返回true,否则返回FALSE
     * @param startDateStr 开始日期，字符串类型
     * @param endDateStr 结束日期，字符串类型
     * @returns {boolean}
     */
    compare: function (startDateStr, endDateStr) {
        if (null == startDateStr || null == endDateStr) {
            return null;
        }
        var startDate = new Date(startDateStr);
        var endDate = new Date(endDateStr);
        var startDateTime = startDate.getTime();
        var endDateTime = endDate.getTime();
        return startDateTime > endDateTime;
    },
    /**
     * 获取日期中的一部分
     * @param date
     * @param interval
     *  interval 可选值:
     *      y: 年 真实年份减去1900年
     *      Y: 年 真实年份
     *      M：月
     *      d：日
     *      h：时
     *      m: 分
     *      s：秒
     *      ms：毫秒，
     *      q：季度 1-3为第一季度   4-6为第二季度  7-9为第三季度 10-12为第四季度
     */
    getDatePart: function (date, interval) {
        var newDate = new Date(date);
        var part;
        switch (interval) {
            case 'y':
                part = newDate.getYear();
                break;
            case  'Y':
                part = newDate.getFullYear();
                break;
            case 'M':
                part = newDate.getMonth() + 1;
                break;
            case 'd':
                part = newDate.getDate();
                break;
            case 'h':
                part = newDate.getHours();
                break;
            case 'm':
                part = newDate.getMinutes();
                break;
            case 's':
                part = newDate.getSeconds();
                break;
            case 'ms':
                part = newDate.getMilliseconds();
                break;
            case 'q':
                var month = newDate.getMonth() + 1;
                part = Math.floor(( month % 3 == 0 ? ( month / 3 ) : ( month / 3 + 1 ) ));
        }
        return part;
    },
    /**
     * 某日期是当前的第几周.如果当前年的第一天和上一年的最后一周是在一周，那么从下周开始算
     * @param d
     * @returns {number}
     */
    getWeekNumOfYear: function (d) {
        var date = new Date(d);
        var year = date.getFullYear();
        var date1 = new Date(year, 0, 1);
        var diff = Math.round((date.valueOf() - date1.valueOf()) / 86400000);
        return Math.ceil((diff + ((date1.getDay() + 1) - 1)) / 7);
    },
    /**
     * 某日期在当月的属于第几周
     * @param d
     * @returns {number}
     */
    getWeekNumOfMonth: function (d) {
        var date = new Date(d);
        var day = date.getDay();
        var d1 = date.getDate();
        return Math.ceil((d1 + 6 - day) / 7);
    },
    /**
     * 某日期在当年是第几天
     * @param d
     * @returns {number}
     */
    getDateNumOfYear: function (d) {
        var date = new Date(d);
        var year = date.getFullYear();
        var date1 = new Date(year, 0, 1);
        var diff = Math.round((date.valueOf() - date1.valueOf()) / 86400000);
        return Math.ceil(diff + (date1.getDay() + 1));
    },
    /**
     * 两个日期之间的相隔的天数
     * @param date1
     * @param date2
     * @returns {number}
     */
    dateDiff: function (date1, date2) {
        date1 = zmallDate.formatWithStyle(new Date(date1), 'yyyy-MM-dd');
        date2 = zmallDate.formatWithStyle(new Date(date2), 'yyyy-MM-dd');
        var month1 = date1.substring(5, date1.lastIndexOf('-'));
        var day1 = date1.substring(date1.length, date1.lastIndexOf('-') + 1);
        var year1 = date1.substring(0, date1.indexOf('-'));

        var month2 = date2.substring(5, date2.lastIndexOf('-'));
        var day2 = date2.substring(date2.length, date2.lastIndexOf('-') + 1);
        var year2 = date2.substring(0, date2.indexOf('-'));

        var cha = ((Date.parse(month1 + '/' + day1 + '/' + year1) - Date.parse(month2 + '/' + day2 + '/' + year2)) / 86400000);
        return Math.abs(cha);
    },
    /**
     * 日期加法计算
     * @param date 初始日期
     * @param interval 加的计算单位
     * @param number 加的数值
     */
    dataAdd:function(date, interval, number){
        date = new Date(date);
        interval = interval || 'd';
        switch (interval) {
            case 's' :
                return new Date(Date.parse(date) + (1000 * number));
            case 'm' :
                return new Date(Date.parse(date) + (60000 * number));
            case 'h' :
                return new Date(Date.parse(date) + (3600000 * number));
            case 'd' :
                return new Date(Date.parse(date) + (86400000 * number));
            case 'w' :
                return new Date(Date.parse(date) + ((86400000 * 7) * number));
            case 'q' :
                return new Date(date.getFullYear(), (date.getMonth()) + number * 3, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
            case 'M' :
                return new Date(date.getFullYear(), (date.getMonth()) + number, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
            case 'y' :
                return new Date((date.getFullYear() + number), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
        }
    },
    /**
     * 获取指定日期的周一和周日
     * @returns {{monday: Date, sunday: Date}}
     */
    weekStartAndEnd: function (date) {
        var monday = new Date(date.getTime());
        var sunday = new Date(date.getTime());
        monday.setDate(monday.getDate() + 1 - monday.getDay());
        sunday.setDate(sunday.getDate() + 7 - sunday.getDay());
        return {monday: monday, sunday: sunday};
    },
    /**
     * 下一周
     * @param date
     * @returns {{monday: Date, tues: Date, wednesday: Date, thursday: Date, friday: Date, saturday: Date, sunday: Date}}
     */
    nextWeek:function(date){
        var weekIndex = date.getDay();
        var monday = new Date(date.getTime());
        var tuesday = new Date(date.getTime());
        var wednesday = new Date(date.getTime());
        var thursday = new Date(date.getTime());
        var friday = new Date(date.getTime());
        var saturday = new Date(date.getTime());
        var sunday = new Date(date.getTime());

        monday = monday.setDate(this.getDate() + (1 - weekIndex) + 7);
        tuesday = tuesday.setDate(this.getDate() + (2 - weekIndex) + 7);
        wednesday = wednesday.setDate(this.getDate() + (3 - weekIndex) + 7);
        thursday = thursday.setDate(this.getDate() + (4 - weekIndex) + 7);
        friday = friday.setDate(this.getDate() + (5 - weekIndex) + 7);
        saturday = saturday.setDate(this.getDate() + (6 - weekIndex) + 7);
        sunday = sunday.setDate(this.getDate() + (7 - weekIndex) + 7);
        return {
            monday: new Date(monday),
            tues: new Date(tuesday),
            wednesday: new Date(wednesday),
            thursday: new Date(thursday),
            friday: new Date(friday),
            saturday: new Date(saturday),
            sunday: new Date(sunday)
        };
    },
    /**
     * 上一周
     * @param date
     * @returns {{monday: Date, tues: Date, wednesday: Date, thursday: Date, friday: Date, saturday: Date, sunday: Date}}
     */
    prevWeek:function(date){
        var weekIndex = date.getDay();
        var monday = new Date(date.getTime());
        var tuesday = new Date(date.getTime());
        var wednesday = new Date(date.getTime());
        var thursday = new Date(date.getTime());
        var friday = new Date(date.getTime());
        var saturday = new Date(date.getTime());
        var sunday = new Date(date.getTime());

        monday = monday.setDate(this.getDate() + (1 - weekIndex) - 7);
        tuesday = tuesday.setDate(this.getDate() + (2 - weekIndex) - 7);
        wednesday = wednesday.setDate(this.getDate() + (3 - weekIndex) - 7);
        thursday = thursday.setDate(this.getDate() + (4 - weekIndex) - 7);
        friday = friday.setDate(this.getDate() + (5 - weekIndex) - 7);
        saturday = saturday.setDate(this.getDate() + (6 - weekIndex) - 7);
        sunday = sunday.setDate(this.getDate() + (7 - weekIndex) - 7);
        return {
            monday: new Date(monday),
            tues: new Date(tuesday),
            wednesday: new Date(wednesday),
            thursday: new Date(thursday),
            friday: new Date(friday),
            saturday: new Date(saturday),
            sunday: new Date(sunday)
        };
    }
};


/**
 * 正则相关
 * @type {{checkEmail: zmallRegex.checkEmail, checkMobile: zmallRegex.checkMobile}}
 */
var zmallRegex = {
    /**
     * 邮箱正则
     * @param email
     * @returns {boolean}
     */
    checkEmail: function (email) {
        if ((/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/
                .test(email))) {
            return true;
        }
        return false;
    },
    /**
     * 手机号正则
     * @param mobile
     * @returns {boolean}
     */
    checkMobile: function (mobile) {
        if ((/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(mobile))) {
            return true;
        }
        return false;
    },

    /**
     * 固定号码正则
     * @param tel
     * @returns {boolean}
     */
    checkTel: function (tel) {
        if ((/^((\d{3,4}\-)|)\d{7,8}(|([-\u8f6c]{1}\d{1,5}))$/.test(tel))) {
            return true;
        }
        return false;
    }
};

/**
 * 分页相关
 * @type {{}}
 */
var page = {};

/**
 * 数组相关
 * @type {{}}
 */
var zmallArray = {
    /**
     * 数组去重，去重后会排序
     * @param arr
     * @returns {*[]}
     */
    unique: function (arr) {
        arr.sort();
        var temp = [arr[0]];
        for (var i = 1; i < arr.length; i++) {
            if (arr[i] != temp[temp.length - 1]) {
                temp.push(arr[i]);
            }
        }
        return temp;
    },
    contains: function (arr, item) {
        return RegExp("\\b" + item + "\\b").test(arr);
    }
};


/**
 * 数字相关
 * @type {{cancelScienceNum: zmallNumber.cancelScienceNum}}
 */
var zmallNumber = {

    /**
     * 取消科学计数法
     * @param value
     * @returns {*}
     */
    cancelScienceNum: function (value) {
        value = value.toString();
        if (!this.isEmpty(value)) {
            var num = 0;
            if ((num = value.indexOf('E')) != -1 || (num = value.indexOf('e')) != -1) {
                var doubleStr = value.substring(0, num); //1.25
                var eStr = value.substring(num + 1, value.length); //-7
                eStr = parseInt(eStr); //-7
                var doubleStrList = doubleStr.split('.'); //1
                var doubleStr1 = doubleStrList[0]; //1
                var doubleStr2 = doubleStrList[1]; //25
                if (eStr > 0) {
                    var str = '';
                    var e = Math.abs(eStr) - doubleStr2.length;
                    for (var i = 0; i < e; i++) {
                        str += '0';
                    }
                    return doubleStr1 + doubleStr2 + str;
                } else if (eStr < 0) {
                    var e = Math.abs(eStr);
                    var str = '';
                    for (var i = 0; i < e; i++) {
                        str += '0';
                    }
                    value = "0." + str + doubleStr1 + (doubleStr2 == undefined ? '' : doubleStr2);
                } else {
                    value = doubleStr;
                }
            } else {

            }
        }
        return value;
    },
    /**
     * 获取指定区间的两位随机小数
     * @param min 区间的下限
     * @param max 区间的上限
     * @returns {Number}
     */
    random2Demical: function (min, max) {
        return parseFloat((Math.random() * (max - min) + min).toFixed(2));
    }
};


/**
 * 其它：杂七杂八
 * @type {{}}
 */
var zmall = {
    /**
     * 计算输入框中的字符数量
     * @param input
     * @param num
     * @param label
     */
    calculateCharSumWithInput: function (input, num, label) {
        var tagName = $(input)[0].tagName;
        var text;
        if (tagName != null && tagName != "" && typeof (tagName) != 'undefined') {
            if (tagName.toLowerCase() === 'input') {
                text = $(input).val();
            } else if (tagName.toLowerCase() == "textarea") {
                text = $(input).val();
            }
        }
        var length = text != "" && text != null ? text.length : 0;
        num = parseInt(num);
        if (length <= num) {
            $(label).text(length + "/" + num);
        } else {
            if (tagName.toLowerCase() === 'input') {
                $(input).val(text.substring(0, num));
            } else if (tagName.toLowerCase() == "textarea") {
                $(input).val(text.substring(0, num));
            }
        }
    }
};


/**
 * 窗口相关，依赖于layer 插件
 * @type {{}}
 */
var zmallWindow = {
    /**
     * 重新加载最顶层的窗口
     */
    reloadTopWindow: function () {
        window.top.location.reload();
    },
    /**
     * 重定向最顶层的窗口
     * @param src
     */
    redirectTopWindow: function (src) {
        window.top.location.href = src;
    },

    /**
     * 打开一个内容矿窗口，内容可以是任何字符
     * @param content
     * @param width
     * @param height
     * @param closeCallBack 关闭的回调函数
     */
    openContentWindow:function(content, width, height,title, closeCallBack){
        var index = layer.open({
            zIndex: 999,
            type: 1,
            title: title,
            shadeClose: false,
            shade: 0.5,
            area: [width + "px", height + "px"],
            maxmin: true,
            cancel:function(){
                if(closeCallBack && typeof (closeCallBack) == 'function'){
                    closeCallBack();
                }
                layer.close(index);
            },
            skin: 'layer-iframe',
            content: content
        });
        return index;
    },
    /**
     * 在父页面打开一个内容矿窗口，内容可以是任何字符
     * @param content
     * @param width
     * @param height
     * @param closeCallBack 关闭的回调函数
     */
    openParentContentWindow:function(content, width, height,title, closeCallBack){
        var index = parent.layer.open({
            zIndex: 999,
            type: 1,
            title: title,
            shadeClose: false,
            shade: 0.5,
            area: [width + "px", height + "px"],
            maxmin: true,
            cancel:function(){
                if(closeCallBack && typeof (closeCallBack) == 'function'){
                    closeCallBack();
                }
                layer.close(index);
            },
            skin: 'layer-iframe',
            content: content
        });
        return index;
    },

    /**
     * 开一个iframe窗口
     * @param url 窗口的url
     * @param width
     * @param height
     * @param title
     * @closeCallBack  窗口关闭的回调函数
     */
    openFrameWindow: function (url, width, height, title, closeCallBack) {
        var index = layer.open({
            zIndex: 999,
            type: 2,
            title: title,
            shadeClose: false,
            shade: 0.5,
            area: [width + "px", height + "px"],
            maxmin: true,
            cancel:function(){
                if(closeCallBack && typeof (closeCallBack) == 'function'){
                    closeCallBack();
                }
                layer.close(index);
            },
            skin: 'layer-iframe',
            content: url
        });
        return index;
    },
    /**
     * 在父页面打开一个iframe窗口
     * @param url
     * @param width
     * @param height
     * @param title
     * @closeCallBack  窗口关闭的回调函数
     */
    openParentFrameWindow: function (url, width, height, title, closeCallBack) {
        var index = parent.layer.open({
            zIndex: 999,
            type: 2,
            title: title,
            shadeClose: false,
            shade: 0.5,
            area: [width + "px", height + "px"],
            maxmin: true,
            cancel:function(){
                if(closeCallBack && typeof (closeCallBack) == 'function'){
                    closeCallBack();
                }
                layer.close(index);
            },
            skin: 'layer-iframe',
            content: url
        });
        return index;
    },
    openAlert: function (message, icon, callback) {
        var index = layer.alert(message, {icon: icon}, function (index) {
            layer.close(index);
            if (callback && typeof (callback) == 'function') {
                callback();
            }
        });
        return index;
    },
    openParentAlert: function () {
    }

};