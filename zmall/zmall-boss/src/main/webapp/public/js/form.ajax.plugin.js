(function ($) {
    $.fn.ajaxSubmit = function (options, param) {
        if (typeof options == 'string') {
            return $.fn.ajaxSubmit.methods[options](this, param);
        }
        options = $.extend({}, $.fn.ajaxSubmit.defaults, options || {});
        if (options.beforeSend) {
            if (!options.beforeSend()) {
                options.complete();
                return;
            }
        }
        ajaxLoad(options, this);

        function ajaxLoad(options, obj) {
            var target = $(obj);
            var actionUrl;
            if (null == options.url) {
                actionUrl = target.attr("action");
            } else {
                actionUrl = options.url;
            }
            var dataPara = getFormJson(obj);
            $.ajax({
                url: actionUrl,
                type: target.attr("method"),
                data: dataPara,
                success: options.success,
                error: options.error,
                complete: options.complete
            });
        }

        function getFormJson(frm) {
            var o = {};
            var a = $(frm).serializeArray();
            $.each(a, function () {
                if (o[this.name] !== undefined) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        }

    }

    $.fn.ajaxSubmit.methods = {
        test: function (jq) {
            return jq.attr("id");
        }
    };

    $.fn.ajaxSubmit.defaults = {
        url: null,
        beforeSend: function () {
        },
        success: function (result) {
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        },
        complete: function (value) {
        }
    };
})(jQuery);