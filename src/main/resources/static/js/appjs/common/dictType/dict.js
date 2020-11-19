
var prefix = "/common/dictType"
$(function() {
	load();
});
function selectLoad() {
	var html = "";
	$.ajax({
		url : '/common/dict/type',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].type + '">' + data[i].type + '</option>'
			}
			$(".chosen-select").append(html);
			$(".chosen-select").chosen({
				maxHeight : 200
			});
			//点击事件
			$('.chosen-select').on('change', function(e, params) {
				console.log(params.selected);
				var opt = {
					query : {
						type : params.selected,
					}
				}
				$('#exampleTable').bootstrapTable('refresh', opt);
			});
		}
	});
}
function load() {
	// selectLoad();
	$('#dataTable')
		.bootstrapTreeTable(
			{
				id: 'id',
				code: 'id',
				parentCode: 'parentId',
				type: "GET",
				url: prefix + '/list',
				ajaxParams: {},
				expandColumn: '1',
				bordered: true,
				expandAll: true,
				showColumns: true,
				showRefresh: true,
				striped : true, // 设置为true会有隔行变色效果
				// dataType : "json", // 服务器返回的数据类型
				// pagination : true, // 设置为true会在底部显示分页条
				// pageSize : 10, // 如果设置了分页，每页数据条数
				// pageNumber : 1, // 如果设置了分布，首页页码

				queryParams : function(params) {
					return {
						//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						// name:$('#searchName').val(),
						type : $('#searchName').val(),
					};
				},
				// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
				// queryParamsType = 'limit' ,返回参数必须包含
				// limit, offset, search, sort, order 否则, 需要包含:
				// pageSize, pageNumber, searchText, sortName,
				// sortOrder.
				// 返回false将会终止请求
				columns : [
					// {
					// 	checkbox : true
					// },
					{
						field : 'id',
						title : '编号',
						visible: false,
						align: 'center',
						valign: 'center',
						width: '5%',
					},
					{
						field : 'name',
						title : '标签名',
						valign: 'center',
						width: '20%',
					},

					{
						field : 'type',
						title : '类型',
						valign: 'center',
						width: '10%',
					},
					{
						field : 'description',
						title : '描述',
						valign: 'center',
						width: '20%',
					},
					{

						field : 'sort',
						title : '排序（升序）',
						valign: 'center',
						width: '10%',
					},
					{

						field : 'remarks',
						title : '备注信息',
						valign: 'center',
						width: '10%',
					},
					{

						field : 'delFlag',
						title : '删除标记',
						valign: 'center',
						width: '10%',
					},
					{
						title: '层级 ',
						valign: 'center',
						width: '5%',
						field: 'level',
					},
					{
						title : '操作',
						field : 'id',
						valign: 'center',
						align : 'center',
						width: '10%',
						formatter : function(item, index) {

							if (item.description == '禁止修改'){
								return "禁止修改,有需求请联系系统管理员";
							}

							var e = '<a class="btn btn-primary btn-sm " href="#" mce_href="#" title="编辑" onclick="edit('
								+ item.id
								+ ')"><i class="fa fa-edit"></i></a> ';

							var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="remove('
								+ item.id
								+ ')"><i class="fa fa-remove"></i></a> ';

							console.log(item)
							// var f ='<a class="btn btn-success btn-sm " href="#" title="增加"  mce_href="#" onclick="addD('
							// 	+ item.id +","+item.name
							// 	+ ')"><i class="fa fa-plus"></i></a> '; ;
							var f = '<a class="btn btn-success btn-sm " href="#" title="增加"  mce_href="#" onclick="addD(\''
								+ item.id +'\',\''+item.name
								+ '\')"><i class="fa fa-plus"></i></a> ';

							if(item.level == undefined || item.level ==null|| item.level >=2){
								// console.log(item)
								f=""
							}
							return e + d + f ;
						}
					}]
			});
}
function reLoad() {
	load();
}

function addD(pId,type) {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add/'+ pId +'/'+type // iframe的url
	});
}

function edit(id) {


	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				console.log(r);
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}

		});

	})
}


function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {});
}