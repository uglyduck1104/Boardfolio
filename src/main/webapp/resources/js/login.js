function formChk(f){
	var id = f.id;
	var pw = f.pw;
	if( id.value == "" ){
		alert("아이디를 입력해주세요.");
		id.focus();
		return false;
	}
	if( pw.value == "" ){
		alert("비밀번호를 입력해주세요.");
		pw.focus();
		return false;
	}
	return true;
}