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
	
	let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)");
	let maxSize = 1024 * 1024 * 5; //5MB (5242880)
	
	function checkExtension(fileName, fileSize) {
		// 파일 용량 체크
		if (fileSize > maxSize) {
			alert("화일용량초과 - 업로드 할 수 없습니다.");
			return false;
		}
		// 확장자 체크
		if (regex.test(fileName)) {
			alert("해당 종류의 파일은 업로드 할 수 없습니다.")
			return false;
		}
		return true;
	}
	
	
	
	$("#uploadBtn").click(function(){
		let formData = new FormData();// 가상의 폼
		
		let inputFile = $("input[name='uploadFile']");
		
		let files = inputFile[0].files;
		
		console.log(files);
		
		for (let i = 0 ; i < files.length ; i++) {
			if (!checkExtension(files[i].name, files[i].size)) {
				return false;
			}
			
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



