function checkMember() {
    var memberForm = document.memberForm;
    var userId = memberForm.userId.value;
    var userPw = memberForm.userPw.value;
    var userPw2 = memberForm.userPw2.value;
    var phone = memberForm.phone.value;
    var name = memberForm.name.value;
    var email = memberForm.email.value;

    //아이디 정규 표현식
    const userIdRegex = /^[A-Za-z0-9]{4,10}$/;

    //이메일 정규 표현식
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

    //비밀번호 정규 표현식
    const passRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#])[A-Za-z\d!@#]{6,13}$/;

    //폰번호 정규 표현식
    var phoneRegex = /^010-\d{4}-\d{4}$/;

    //회원가입 유효성 검사 진행
    if (userId.length == 0 || userId == "") {
        alert("아이디는 필수입니다.");
    }
    else if (userId.length < 4 || !userIdRegex.test(userId) || userId.lenght > 10) {
        alert("아이디는 4글자 이상, 10글자 이하여야 하며 특수문자와 공백을 포함할 수 없습니다.")
    }
    else if (email == 0 || email == "") {
        alert("이메일은 필수입니다.");
    }
    else if (!emailRegex.test(email)) {
        alert("이메일 형식으로 입력해주세요.");
    }
    else if (userPw.length == 0 || userPw == "") {
        alert("비밀번호는 필수입니다.");
    }
    else if (!passRegex.test(userPw)) {
        alert('비밀번호 형식을 지켜주세요.')
    }
    else if (userPw !== userPw2) {
        alert("비밀번호가 동일하지 않습니다.");
    }
    else if (name.length == 0 || name == "") {
        alert("이름은 필수입니다.");
    }
    else if (email.length == 0 || email == "") {
        alert("이메일은 필수입니다.");
    }
    else if (phone == "") {
        alert('휴대폰 번호는 필수입니다.');
    }
    else if (!phoneRegex.test(phone)) {
        alert('휴대폰 번호를 입력해주세요.');
    }
    else {
        memberForm.method = "POST";
        memberForm.action = "register/input";
        memberForm.submit();
    }
}