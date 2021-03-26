<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div class="layui-btn-group demoTable">
	  <button id="insert" class="layui-btn">添加</button>
	  <button id="deleteAll" class="layui-btn">批量删除</button>
	  <button class="layui-btn">验证是否全选</button>
	</div>
	<table class="layui-hide" id="test" lay-filter="tableFilter"></table>
	
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	</script>

	<script type="text/javascript">
		layui.use('table', function() {
			var table = layui.table;
			table.render({
			    elem: '#test'
			    ,url:'${path}/dept/selectByPage.action'
			    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
			    ,cols: [[
			      {checkbox: true, fixed: true}
			      ,{field:'id', title: 'ID', sort: true}
			      ,{field:'name', title: '用户名'}
			      ,{toolbar: '#barDemo'} 
			    ]]
				,page: true
				,id:'tableRelaod'
			});
			
			//监听工具条
			 table.on('tool(tableFilter)', function(obj){
				// data是这一行的数据
				// {id: 17, name: "er", password: "123", age: 3, email: "3", …}
			    var data = obj.data;
			    console.log(obj);
			    console.log(obj.data);
			    if(obj.event === 'del'){
			      layer.confirm('真的删除行么', {icon:3}, function(index){
			    	  $.post(
			    		  '${path}/dept/deleteById.action',
			    		  {'id':data.id},
			    		  function(jsonResult) {
			    			  if(jsonResult.ok) {
			    				  // mylayer.okMsg(jsonResult.msg);
			    				  layer.msg(
			    						jsonResult.msg,
		    							{icon : 1, time : 2000},
		    							function() {// msg消失之后触发的函数
		    							   // 重新加载表格
		  			    				   table.reload('tableRelaod');
		    							}
		    						);
			    			  } else {
			    				  mylayer.errorMsg(jsonResult.msg);
			    			  }
			    		  },
			    		  'json'
			    	  );
			      });
			    } else if(obj.event === 'edit'){
			    }
			  });
			
			  $('#insert').on('click', function() {
				  console.log('insert');
				  // location.href='${path}/dept_insert.jsp';
				  layer.open({
					  type : 2,
					  area : ['500px', '400px'],
					  content : '${path}/dept/getDeptInsertPage.action'
				  });
			  });
			  
			  $('#deleteAll').on('click', function() {
				  console.log('deleteAll');
				  var checkStatus = table.checkStatus('tableRelaod')
			      var data = checkStatus.data;
				  console.log(data);
				  // [{id: 1, name: "zh3", password: "123"},{id:2,...}]
				  // "1,2"
				  var ids = new Array(); // [1,2]
				  $(data).each(function() {
					  ids.push(this.id);
				  });
				  var idsStr = ids.join(',');// "1,2"
				  console.log(idsStr);
				  
				  $.post(
		    		  '${path}/dept/deleteAll.action',
		    		  {'ids':idsStr},
		    		  function(jsonResult) {
		    			  if(jsonResult.ok) {
		    				  // mylayer.okMsg(jsonResult.msg);
		    				  layer.msg(
		    						jsonResult.msg,
	    							{icon : 1, time : 2000},
	    							function() {// msg消失之后触发的函数
	    							   // 重新加载表格
	  			    				   table.reload('tableRelaod');
	    							}
	    						);
		    			  } else {
		    				  mylayer.errorMsg(jsonResult.msg);
		    			  }
		    		  },
		    		  'json'
			      );
				  
			  });
			
		});
	
	</script>
</body>
</html>