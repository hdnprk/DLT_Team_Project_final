function loginCheck() {
    let loginForm = document.loginForm;
    let id = loginForm.userId.value;
    let pw = loginForm.userPw.value;

    if (id.length == 0 || id == "") {
        alert("아이디는 필수입니다.");
        return false; //서버 이동 방지
    }
    else if (pw.length == 0 || pw == "") {
        alert("비밀번호는 필수입니다.");
        return false;
    }

    return true;
}