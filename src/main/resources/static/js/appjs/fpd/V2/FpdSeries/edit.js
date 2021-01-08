var prefix = "/fpd/V2/fpdSeries";

$().ready(function () {
    validateRule();
    initOrderRuleSelect();
});

$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function save() {
    $.ajax({
        cache: false,
        type: "POST",
        url: prefix + "/save",
        data: serializeNotNull($('#dataForm').serialize()),
        async: false,
        error: function (request) {
            alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg(data.msg);
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            } else {
                parent.layer.msg(data.msg);
            }
        }
    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#dataForm").validate({
        rules: {
            fFactorys: {
                required: true
            },
            fSeries: {
                required: true
            },
            hkSeries: {
                required: true
            },
            code: {
                required: true
            },

        },
        messages: {
            fFactorys: {
                required: icon + "请输入国内/外厂家"
            },
            hkSeries: {
                required: icon + "请输入国内/外系列"
            },
            fSeries: {
                required: icon + "请输入宏科系列"
            },

        }
    })
}
