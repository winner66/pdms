var prefix = "/order";
//所有待处理清单
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
                url: prefix + '/list-op-order',
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
                        opUserId:$('#opUserId').val() ? $('#opUserId').val() : undefined,
                    };
                },
                columns: [
                    {
                        title: '编号',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        width: '13%'
                    },
                    {
                        title: '当前处理人',
                        valign: 'center',
                        width: '8%',
                        field: 'opUser'
                    },
                    {
                        title: '类型',
                        valign: 'center',
                        field: 'type',
                        width: '7%'
                    },
                    {
                        title: '公司',
                        valign: 'center',
                        field: 'company',
                        width: '15%'
                    },
                    {
                        title: '联系人',
                        valign: 'center',
                        field: 'contact',
                        width: '8%'
                    },
                    {
                        title: '联系电话',
                        valign: 'center',
                        width: '8%',
                        field: 'phone'
                    },
                    {
                        title: '提交日期',
                        valign: 'center',
                        width: '8%',
                        field: 'createTime',
                        formatter:function (value) {
                            return dateFormat(new Date(value), 'yyyy-MM-dd');
                        }
                    },
                    {
                        title: '备注',
                        valign: 'center',
                        width: '25%',
                        field: 'descr'
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-warning btn-sm" href="#" mce_href="#" title="查看明细" onclick="view(' + "'" + row.id.toString() + "'" + ')"><i class="fa fa-th-list"></i></a>';
                            var d = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="查看处理流程" onclick="viewHandle(' + "'" + row.id.toString() + "'" + ')"><i class="fa fa-search-plus"></i></a>';
                            if ($('#opUserId').val()) {
                                d = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="处理" onclick="edit(' + "'" + row.id.toString() + "'" + ')"><i class="fa fa-edit"></i></a>';
                            }
                            return e + d;
                        }
                    }
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

function viewHandle(id) {
    var win = layer.open({
        type: 2,
        title: '清单流程',
        maxmin: true,
        shadeClose: false,
        area: ['1100px', '520px'],
        content: prefix + '/view-order-flow?orderId=' + id,
    });
    // layer.full(win);
}

function edit(id) {
    var win = layer.open({
        type: 2,
        title: '处理清单',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '520px'],
        content: prefix + '/order-flow?orderId=' + id,
    });
    layer.full(win);
}