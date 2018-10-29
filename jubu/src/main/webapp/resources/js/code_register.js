/**
 * 
 */
$(document).ready(function(){
	$.ajax({
		url : 'code_list',
		dataType : 'json',
		type : 'get',
		success : function(data){
			clist(data)
		}
	})
	function submit(){
		var fd = $("#form").serialize()
		if($("#code_name").val()==""){
			alert("코드명을 입력해주세요.")
			$("#code_name").focus()
			return false
		}else if($("#code_level").val()==""){
			alert("상위 코드를 선택해주세요.")
			return false
		}
		$.ajax({
			url : 'code_register_ok',
			type : 'post',
			dataType : 'json',
			data : fd,
			success : function(data){
				clist(data)
			}
		})
	}
	
	function clist(data){
		var clist = data.clist
		var clist_html
		$("#list_body").html("")
		$.each(clist,function(i){
			clist_html = "<tr>";
			clist_html += 	"<td>"+clist[i].code+"</td>";
			clist_html += 	"<td style='text-align:left; font-weight:bolder;'>"
			for(var j=0; j<clist[i].code_level; j++){
				clist_html += "&nbsp;&nbsp;&nbsp;&nbsp;"
			}
			clist_html +=		"<span class='code_name' param='"+clist[i].code+"' style='font-weight:bold; cursor:pointer;'>"+clist[i].code_name+"</span>"
			clist_html +=	"</td>";
			clist_html += 	"<td>"+clist[i].up_code+"</td>";
			clist_html += 	"<td>"+clist[i].code_level+"</td>";
			clist_html += "</tr>";
			$("#list_body").append(clist_html)
		})
	}
	window.onload = function(){
		
	}
	$(document).on('click','.code_name',function(){
		var code = $(this).attr("param")
		var top = $("#code_register_table").offset().top
		console.log(top)
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
				$("html, body").animate({'scrollTop':top},20)
			}
		})
	})
	$(document).on('keydown','#code_name',function(e){
		if(e.keyCode=='13'){
			submit()
			$("#code_name").val("")
		}
	})
	
	$(document).on('click','#code_register_ok_btn',function(){
		submit()
	})
})