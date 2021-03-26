<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="formId" class="layui-form layui-form-pane" action="">
	  <div class="layui-form-item">
	    <label class="layui-form-label">部门名</label>
	    <div class="layui-input-block">
	      <input type="text" name="name" autocomplete="off" placeholder="请输入用户名" class="layui-input">
	    </div>
	  </div>
	   <input class="layui-btn" type="button" onclick="submitForm()" value="添加"/>
	 </form>

	<script type="text/javascript">
		layui.use(['form','laydate'], function() {
			var form = layui.form;
			var laydate = layui.laydate;
		});
		
		function submitForm() {
			$.post('${path}/dept/insert.action',
					$('#formId').serialize(),
					function(jsonResult) {
						console.log(jsonResult);
						if(jsonResult.ok) {
							
							//当你在iframe页面关闭自身时获得当前弹出框的index索引
	                        var index = parent.layer.getFrameIndex(window.name);
	                        layer.msg(
	    						jsonResult.msg,
    							{icon : 1, time : 2000},
    							function() {// msg消失之后触发的函数
    								// 关闭弹出层
   	                             	parent.layer.close(index);
   	                             	// 刷新父页面
   	                             	window.parent.location.reload();
    							}
	    					);
							
	                         // js一个方法，定时器，1000毫秒之后自动执行function里面的代码
	                        /*
	                        setTimeout(function() {
	                             // 关闭弹出层
	                             parent.layer.close(index);
	                             // 刷新父页面
	                             window.parent.location.reload();
	                         }, 1000); */
						} else {
							mylayer.errorMsg(jsonResult.msg);
						}
				    },
				    'json');
		}
	</script>
</body>
</html>