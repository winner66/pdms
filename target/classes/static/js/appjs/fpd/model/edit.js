var prefix = "/fpd/model";

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
            name: {
                required: true
            },
            code: {
                required: true
            },
            idx: {
                required: true,
                number: true,
            }
        },
        messages: {
            name: {
                required: icon + "请输入产品名称"
            },
            code: {
                required: icon + "请输入产品型号"
            },
            idx: {
                required: icon + "请输入序号",
                number: icon + "请输入数字",
            }
        }
    })
}

function setOR(){
    var val = "";
    var formatVal = "";
    $("select[name='or']").each(function () {
        var v = $(this).val();
        var t = $(this).val();
        if ($(this).attr('class').indexOf("_type") != -1) {
            t = $(this).find("option:selected").text();
        }
        val += (v) + "|";
        formatVal += (t);
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

    var posVal = "";
    $("select[name='pos']").each(function () {
        var v = $(this).val();
        posVal += (v) + ",";
    })
    var i = posVal.length;
    for (; i >=0; i--){
        var v = posVal[i - 1];
        if (v != ','){
            break;
        }
    }
    posVal = posVal.substring(0, i);

    $('#orderRuleBit').val(bitVal);
    $('#orderRulePos').val(posVal);
    $('#formatOR').val(formatVal + " (位置:" + posVal + ")" + " (长度:" + bitVal + ")");
}

function initOrderRuleSelect() {
    $("select[name='or']").on('change', function (e) {
       setOR();
    });
    $("select[name='bit']").on('change', function (e) {
        setOR();
    });
    $("select[name='pos']").on('change', function (e) {
        setOR();
    });
}