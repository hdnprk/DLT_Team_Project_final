
/*댓글 관련 함수*/
//답글 등록
function showReplyForm(cName, bGroup) {
	var commentTextElement = document.getElementById("commentText");
	var insertbtnElement = document.getElementById("insertbtn");
	commentTextElement.value = "@" + cName + " ";
	insertbtnElement.value = "답글 등록";	
	var commentForm = document.getElementById("commentform");
	commentForm.action = "writeComment/" + bGroup; // 원하는 URL로 변경
}

//로그인 시
function loginPage() {
	alert("로그인이 필요합니다.");
	window.location.href = "/senior/member/beforeLogin";
}


//댓글 검사
function commentCheck() {
	var comment = document.getElementById("commentText").value;
	
	if (comment.length == 0) {	
		alert("댓글 내용을 입력해주세요.");
		boardWriteForm.bTitle.focus();
		return;
	}else if(comment.length > 300){
		alert("댓글 수 제한을 넘겼습니다. \n 글자 수 제한 : 300개");
		return;
	}
	
	document.commentform.submit();
}

//댓글 삭제 시 체크
function confirmDeleteComment() {
	if(confirm("댓글을 삭제하시겠습니까?")){
		return true;
	}
	else{
		return false;
	}
}
