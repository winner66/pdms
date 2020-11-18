var prefix = "/order";
//未提交清单
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
                url: prefix + '/list-tmp',
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
                        startDate:$('#startDate').val() ? $('#startDate').val() : undefined,
                        endDate:$('#endDate').val() ? $('#endDate').val() : undefined,
                    };
                },
                columns: [
                    {
                        title: '编号',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        width: '10%'
                    },
                    {
                        title: 'UID',
                        valign: 'center',
                        field: 'uid',
                        width: '10%'
                    },
                    {
                        title: '产品',
                        valign: 'center',
                        field: 'flag',
                        width: '35%'
                    },
                    {
                        title: '数量',
                        valign: 'center',
                        field: 'num',
                        width: '5%'
                    },
                    {
                        title: '日期',
                        valign: 'center',
                        width: '10%',
                        field: 'createTime',
                        formatter:function (value) {
                            return dateFormat(new Date(value), 'yyyy-MM-dd');
                        }
                    },
                    {
                        title: '备注',
                        valign: 'center',
                        width: '35%',
                        field: 'descr'
                    },
                ]
            });
}

function add() {
    var win = layer.open({
        type: 2,
        title: '联系方式',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '520px'],
        content: prefix + '/add',
    });
    layer.full(win);
}

function edit(id) {
    var win = layer.open({
        type: 2,
        title: '联系方式',
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
