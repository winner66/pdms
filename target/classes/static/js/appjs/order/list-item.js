var prefix = "/order";
//清单明细
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
                url: prefix + '/list-item',
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
                        orderId: $('#orderId').val(),
                    };
                },
                columns: [
                    {
                        title: '产品',
                        valign: 'center',
                        field: 'flag',
                        width: '50%'
                    },
                    {
                        title: '数量',
                        valign: 'center',
                        field: 'num',
                        width: '10%'
                    },
                    {
                        title: '备注',
                        valign: 'center',
                        width: '40%',
                        field: 'descr'
                    },
                ]
            });
}
