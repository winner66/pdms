var prefix = "/order";
//清单流程
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
