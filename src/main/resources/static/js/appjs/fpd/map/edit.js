var prefix = "/fpd/map";

$().ready(function () {
    init();
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function init(){
    $("#fpdModelId").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#paramType").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
}

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
        ignore: ":hidden:not(select)",
        rules: {
            fpdModelId: {
                required: true
            },
            paramType: {
                required: true
            },
            fcode: {
                required: true
            },
            code: {
                required: true
            }
        },
        messages: {
            fpdModelId: {
                required: icon + "请输入产品名称"
            },
            paramType: {
                required: icon + "请输入产品型号"
            },
            fcode: {
                required: icon + "请输入国外参数"
            },
            code: {
                required: icon + "请输入宏科参数",
            }
        }
    })
}

function setOR(){
    var val = "";
    var formatVal = "";
    $("select[name='or']").each(function () {
        var v = $(this).val();
        val += (v) + "|";
        formatVal += (v);
    })
    var i = val.length;
    for (; i >=0; i--){
        var v = val[i - 1];
        if (v != '|' && v != '-' && v != ' '){
            break;
        }
    }
    val = val.substring(0, i);
    $('#orderRule').val(val);


    var bitVal = "";
    $("select[name='bit']").each(function () {
        var v = $(this).val();
            bitVal += (v) + ",";
    })
    var i = bitVal.length;
    for (; i >=0; i--){
        var v = bitVal[i - 1];
        if (v != ','){
            break;
        }
    }
    bitVal = bitVal.substring(0, i);

    $('#orderRuleBit').val(bitVal);
    $('#formatOR').val(formatVal + "(" + bitVal + ")");
}

function initOrderRuleSelect() {
    $("select[name='or']").on('change', function (e) {
       setOR();
    });
    $("select[name='bit']").on('change', function (e) {
        setOR();
    });
}