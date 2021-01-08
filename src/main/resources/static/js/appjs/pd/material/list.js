var prefix = "/pd/material";


$(document).ready(function () {
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
                url: prefix + '/list',
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
                        key: $('#key').val() ? $('#key').val() : undefined,
                    };
                },
                columns: [
                    {
                        title: '编号',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        width: '5%'
                    },
                    {
                        title: '产品名称',
                        valign: 'center',
                        field: 'pmName',
                        width: '10%'
                    },
                    {
                        title: '型号',
                        valign: 'center',
                        field: 'model',
                        width: '10%'
                    },
                    // {
                    //     title: '执行标准',
                    //     valign: 'center',
                    //     field: 'std',
                    //     width: '10%'
                    // },
                    {
                        title: '质量等级',
                        valign: 'center',
                        field: 'quality',
                        width: '10%'
                    },
                    {
                        title: '尺寸',
                        valign: 'center',
                        field: 'size',
                        width: '5%'
                    },
                    {
                        title: '通带范围',
                        valign: 'center',
                        field: 'passBandRange',
                        width: '5%'
                    },
                    {
                        title: '频率范围',
                        valign: 'center',
                        field: 'frequencyRange',
                        width: '5%'
                    },
                    {
                        title: '3dB截止频率',
                        valign: 'center',
                        field: 'cutOffFrequency',
                        width: '5%'
                    },
                    {
                        title: '表面代码',
                        valign: 'center',
                        field: 'surfaceCode',
                        width: '5%'
                    },
                    {
                        title: '厚度代码',
                        valign: 'center',
                        field: 'thicknessCode',
                        width: '5%'
                    },
                    {
                        title: '长宽代码',
                        valign: 'center',
                        field: 'lengthWidthCode',
                        width: '5%'
                    },
                    {
                        title: '材料代码',
                        valign: 'center',
                        field: 'materialCode',
                        width: '5%'
                    },
                    {
                        title: '中心频率',
                        valign: 'center',
                        field: 'centerFrequency',
                        width: '5%'
                    },
                    {
                        title: '带宽',
                        valign: 'center',
                        field: 'bandwidth',
                        width: '5%'
                    },

                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="edit(' + row.id + ')"><i class="fa fa-edit"></i></a>';
                            var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="del(' + row.id + ')"><i class="fa fa-remove"></i></a>';
                            return e + d;
                        }
                    }
                ]
            });
}

function add() {

    var win = layer.open({
        type: 2,
        title: '增加产品数据',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '520px'],
        content: prefix + '/add'
    });
    layer.full(win);
}

function edit(id) {
    var win = layer.open({
        type: 2,
        title: '修改产品数据',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '520px'],
        content: prefix + '/get/' + id,
    });
    layer.full(win);
}

function del(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/delete",
            type: "post",
            data: {
                'id': id
            },
            success: function (data) {
                if (data.code == 0) {
                    layer.msg("删除成功");
                    reLoad();
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    })
}

function importData(){
    // layer.open({
    //     type: 2
    //     // ,shade: false
    //     ,time: 5
    // });
    if (!$('#data').val()){
        return false;
    }
    var data = new FormData($('#dataForm')[0]);
    $.ajax({
        cache: false,
        type: "POST",
        url: prefix + "/import-data",
        data: data,
        async: true,
        contentType: false,
        processData: false,
        layerIndex: -1,
        beforeSend: function () {
            this.layerIndex = layer.load(0, {shade: [0.5, '#666c7f']});
        },
        complete: function () {
            $('#data').val('');
            layer.close(this.layerIndex);
        },
        error: function (data) {
            layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                layer.alert(data.msg);
                reLoad();
            } else {
                layer.alert(data.msg, {
                    // area: ['390px', '520px'],
                })
            }
        }
    });
}