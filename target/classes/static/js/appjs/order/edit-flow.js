var prefix = "/order";

$(document).ready(function () {
    selectLoad();
    validateRule();
    load();
});

function reLoad() {
    $('#dataTable').bootstrapTable('refresh');
}

var load = function () {
    $('#dataTable')
        .bootstrapTable(
            {
                method: "GET",
                url: prefix + '/list-order-flow',
                iconSize: 'outline',
                striped: true,
                cache: false,
                pagination: true,
                pageNumber: 1,
                pageSize: 10,
                pageList: [10, 25, 50, 100],
                showColumns: true,
                showRefresh: true,
                sidePagination: "server",
                queryParamsType: '',
                // height: 650,
                queryParams: function (params) {
                    return {
                        pageNum: params.pageNumber,
                        pageSize: params.pageSize,
                        orderId:$('#orderId').val() ? $('#orderId').val() : undefined,
                    };
                },
                columns: [
                    {
                        title: '序号',
                        field: 'idx',
                        align: 'center',
                        valign: 'center',
                        width: '5%'
                    },
                    {
                        title: '处理人',
                        valign: 'center',
                        field: 'opUser',
                        width: '10%'
                    },
                    {
                        title: '处理时间',
                        valign: 'center',
                        field: 'opDatetime',
                        width: '15%',
                        formatter:function (value) {
                            if (!value){
                                return "-";
                            }
                            return dateFormat(new Date(value), 'yyyy-MM-dd HH:mm:ss');
                        }
                    },
                    {
                        title: '处理结果',
                        valign: 'center',
                        field: 'opDesc',
                        width: '80%'
                    },
                ]
            });
}

function view(id) {
    var win = layer.open({
        type: 2,
        title: '清单明细',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '520px'],
        content: prefix + '/order-item?orderId=' + id,
    });
    // layer.full(win);
}

function selectLoad() {
    $("#nextOpUserId").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    var arr = $('#nextOpUserId').val().split(',');
    for (var i = 0; i < arr.length; i++) {
        $("#nextOpUserId option[value='" + arr[i] + "']").attr('selected', 'selected');
    }
    $("#nextOpUserId").trigger("chosen:updated");

    $('#nextOpUserId').on('change', function(e, params) {
        var value = params.selected;
        var text = $("#nextOpUserId").find("option[value="+ value +"]").text();
        $("#nextOpUser").val(text);
    });

    $('#status').on('change', function(e, params) {
        var value = $('#status').val();
        if (value == "9" || value == 9){
            $('#opLabel').css('display','none');
            $('#opDiv').css('display','none');
            $('#nextOpUserId').attr("disabled",true);
        }else{
            $('#opLabel').css('display','block');
            $('#opDiv').css('display','block');
            $('#nextOpUserId').attr("disabled",false);
        }
    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#dataForm").validate({
        ignore: ":hidden:not(select)",
        rules: {
            status: {
                required: true
            },
            nextOpUserId: {
                required: true
            },
            opDesc: {
                required: true
            },
        },
        messages: {
            std: {
                required: icon + "请选择处理状态"
            },
            nextOpUserId: {
                required: icon + "请选择下一处理人"
            },
            opDesc: {
                required: icon + "请输入处理结果"
            },
        }
    })
}

$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function save() {
    var data = new FormData($('#dataForm')[0]);
    $.ajax({
        cache: false,
        type: "POST",
        url: prefix + "/save-order-flow",
        data: data,
        async: false,
        contentType: false,
        processData: false,
        error: function (data) {
            layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("提交成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);
            } else {
                layer.alert(data.msg)
            }
        }
    });

}