<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/js/jquery-3.3.1.min..js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#code_register{width:1260px; margin:0 auto;}
#code_list_table{width:800px; margin:0 auto; border-collapse:collapse;}
#code_list_table th{height:40px; border:2px solid #D8D8D8; background:#EAEAEA;}
#code_list_table td{height:30px; border:1px solid #D8D8D8;}

#code_register_table{width:700px; margin:50px auto; border-collapse:collapse;}
#code_register_table td{text-align:center; border:1px solid #D8D8D8;}
#code_register_table .left{width:20%; height:50px; font-weight:bolder;}
#code_register_table .right{width:80%; height:50px;}
#code_register_table input[type='text']{width:80%; height:30px;}
</style>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$(document).on('click','.code_name',function(){
		var code = $(this).attr("param")
		console.log(code)
		$.ajax({
			url : 'code_info',
			type : 'get',
			dataType : 'json',
			data : {'code' : code},
			success : function(data){
				var cvo = data.cvo
				$("#code").val(cvo.code)
				$("#code_td").html(cvo.code)
				$("#up_code").val(cvo.code)
				$("#up_code_td").html(cvo.code)
				$("#code_level").val(cvo.code_level)
				$("#code_level_td").html(cvo.code_level)
			}
		})
	})
	$(document).on('click','#code_register_ok_btn',function(){
		var fd = $("#form").serialize()
		$.ajax({
			url : 'code_register_ok',
			type : 'post',
			dataType : 'json',
			data : fd,
			success : function(data){
				var clist = data.clist
				var clist_html
				clist_html += "<tr>";
				clist_html += 	"<th>CODE</th>";
				clist_html += 	"<th>CODE_NAME</th>";
				clist_html += 	"<th>UP_CODE</th>";
				clist_html += 	"<th>CODE_LEVEL</th>";
				clist_html += "</tr>";
				$("#code_list_table").html(clist_html)
				$.each(clist,function(i){
					clist_html = "";
					clist_html += "<tr>";
					clist_html += 	"<td>"+clist[i].code+"</td>";
					clist_html += 	"<td style='text-align:left; font-weight:bolder;'>"
					for(var j=0; j<clist[i].code_level; j++){
						clist_html += "&nbsp;&nbsp;&nbsp;"
					}
					clist_html +=		"<span class='code_name' param='"+clist[i].code+"' style='font-weight:bold; cursor:pointer;'>"+clist[i].code_name+"</span>"
					clist_html +=	"</td>";
					clist_html += 	"<td>"+clist[i].up_code+"</td>";
					clist_html += 	"<td>"+clist[i].code_level+"</td>";
					clist_html += "</tr>";
					$("#code_list_table").append(clist_html)
				})
			}
		})
	})
})
</script>
<body>
	<div id="code_register">
		<h1>소속을 선택해주세요.</h1>
		<table id="code_list_table">
			<tr>
				<th>CODE</th>
				<th>CODE_NAME</th>
				<th>UP_CODE</th>
				<th>CODE_LEVEL</th>
			</tr>
			<c:forEach var="clist" items="${clist }">
				<tr>
					<td>${clist.code }</td>
					<td style="text-align:left;">
						<c:forEach var="i" begin="0" end="${clist.code_level }">
							&nbsp;
						</c:forEach>
						<span class="code_name" param="${clist.code }" style="font-weight:bold; cursor:pointer;">${clist.code_name }</span>
					</td>
					<td>${clist.up_code }</td>
					<td>${clist.code_level }</td>
				</tr>
			</c:forEach>
		</table>
		<h1>코드 등록</h1>
		<form name="form" id="form">
			<table id="code_register_table">
				<tr>
					<td class="left">코드</td>
					<td class="right" id="code_td">
						
					</td>
				</tr>
				<tr>
					<td class="left">코드명</td>
					<td class="right" id="code_name_td">
						<input type="text" name="code_name" id="code_name">
					</td>
				</tr>
				<tr>
					<td class="left">상위코드</td>
					<td class="right" id="up_code_td">
						
					</td>
				</tr>
				<tr>
					<td class="left">코드레벨</td>
					<td class="right" id="code_level_td">
						
					</td>
				</tr>
				<tr>
					<td colspan="2" style="border:none;">
						<input type="hidden" name="code_level" id="code_level">
						<input type="hidden" name="up_code" id="up_code">
						<input type="hidden" name="code" id="code">
						<input type="button" id="code_register_ok_btn" value="등록">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>