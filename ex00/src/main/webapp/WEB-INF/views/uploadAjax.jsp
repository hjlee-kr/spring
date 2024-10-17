<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- uploadAjax.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	console.log("jquery 확인");
	
	$("#uploadBtn").click(function(){
		let formData = new FormData();// 가상의 폼
		
		let inputFile = $("input[name='uploadFile']");
		
		let files = inputFile[0].files;
		
		console.log(files);
		
		for (let i = 0 ; i < files.length ; i++) {
			formData.append("uploadFile", files[i]);
		}
		
		$.ajax({
			type: "post",
			url: "/uploadAjaxAction",
			processData: false,
			contentType: false,
			data: formData,
			success: function(result) {
				alert("업로드가 되었습니다.")
			}
		});
	});// end of $("#uploadBtn").click()
	
	
});
</script>
</head>
<body>
<h2>Upload with Ajax</h2>

<div class="uploadDiv">
	<input type="file" name="uploadFile" multiple>
</div>

<button id="uploadBtn">Upload</button>

</body>
</html>



