var prefix = "/order";
//产品清单
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
                        startDate: $('#startDate').val() ? $('#startDate').val() : undefined,
                        endDate: $('#endDate').val() ? $('#endDate').val() : undefined,
                        status: $('#status').val() ? $('#status').val() : undefined,
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
                        formatter: function (value) {
                            return dateFormat(new Date(value), 'yyyy-MM-dd');
                        }
                    },
                    {
                        title: '备注',
                        valign: 'center',
                        width: '20%',
                        field: 'descr'
                    },
                    {
                        title: '状态',
                        valign: 'center',
                        width: '5%',
                        field: 'status',
                        formatter: function (value) {
                            if (value == "9") {
                                return "完成";
                            } else {
                                return "处理中";
                            }
                        }
                    },
                    {
                        title: '当前处理人',
                        valign: 'center',
                        width: '8%',
                        field: 'opUser'
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-warning btn-sm" href="#" mce_href="#" title="查看明细" onclick="view(' + "'" + row.id.toString() + "'" + ')"><i class="fa fa-th-list"></i></a>';
                            var d = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="查看处理流程" onclick="viewHandle(' + "'" + row.id.toString() + "'" + ')"><i class="fa fa-search-plus"></i></a>';
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

function exportFlow() {
    var startDate = $('#startDate').val();
    var endDate = $('#endDate').val();
    var status = $('#status').val();
    if (startDate == '' || endDate == ''){
        parent.layer.msg('请选择时间段，最多只能导出31天的数据');
        return;
    }
    var days = datedifference(startDate, endDate);
    if (days >= 31){
        parent.layer.msg('最多只能导出31天的数据');
        return;
    }
    var url = prefix + '/export-order-flow';
    url = url + "?" + "startDate=" + startDate + "&endDate=" + endDate;
    if (status){
        url = url + "&status=" + status;
    }
    window.open(url);
}

function datedifference(sDate1, sDate2) {    //sDate1和sDate2是2006-12-18格式
    var dateSpan,
        tempDate,
        iDays;
    sDate1 = Date.parse(sDate1);
    sDate2 = Date.parse(sDate2);
    dateSpan = sDate2 - sDate1;
    dateSpan = Math.abs(dateSpan);
    iDays = Math.floor(dateSpan / (24 * 3600 * 1000));
    return iDays;
};