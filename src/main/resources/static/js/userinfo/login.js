/**
 * 
 */
function closeModal() {
	document.getElementById('findIdForm').reset();
}

function handleRadioChange() {
	var optionValue = document.querySelector('input[name="type"]:checked').value;
	console.log("ov : " + optionValue)
	if (optionValue === 'email' || optionValue == 'email2') {
		document.getElementById('div-email').style.display = 'inline-flex';
		document.getElementById('div-phone').style.display = 'none';
	} else if (optionValue === 'phone' || optionValue == 'phone2') {
		document.getElementById('div-email').style.display = 'none';
		document.getElementById('div-phone').style.display = 'inline-flex';
	}
}

var radioButtons = document.querySelectorAll('input[name="type"]');

radioButtons.forEach(function(radioButton) {
	radioButton.addEventListener('change', handleRadioChange);
});


function searchId() {
	var header = $("meta[name='_csrf_header']").attr('content');
	var token = $("meta[name='_csrf']").attr('content');
	var id;
	var optionValue = document.querySelector('input[name="type"]:checked').value;
	if (optionValue === 'email') {
		if (document.getElementById('inputEmail').value == "" || document.getElementById('inputEmail').value == null ||
			document.getElementById('inputEmailUrl').value == 'none') {
			swal('이메일 입력 오류', "올바른 이메일을 입력하세요.", 'warning');
			return;
		}
		var email = document.getElementById('inputEmail').value + '@' + document.getElementById('inputEmailUrl').value;
		console.log(email);
		$.ajax({
			url: "/userinfo/findIdByEmail",
			data: { email: email },
			beforeSend: function(xhr) {
				xhr.setRequestHeader(header, token);
			},
			method: "POST",
			success: function(result) {
				if (result == null || result == "") {
					document.getElementById('result').textContent = '존재하지 않는 회원입니다.';
				} else {
					document.getElementById('result').textContent = '아이디는 ' + result + '입니다.';
				}
			}
		})
	} else if (optionValue === 'phone') {
		var phone = document.getElementById('inputPhoneId1').value + document.getElementById('inputPhoneId2').value + document.getElementById('inputPhoneId3').value;
		if (phone.length != 11) {
			swal('전화번호 입력 오류', "올바른 전화번호를 입력하세요.", 'warning');
			return;
		}
		console.log(phone);
		$.ajax({
			url: "/userinfo/findIdByPhone",
			data: { phone: phone },
			beforeSend: function(xhr) {
				xhr.setRequestHeader(header, token);
			},
			method: "POST",
			success: function(result) {
				if (result == null || result == "") {
					document.getElementById('result').textContent = '존재하지 않는 회원입니다.';
				} else {
					document.getElementById('result').textContent = '아이디는 ' + result + '입니다.';
				}
			}
		})

	}
}

function kakaoLogin() {
	var header = $("meta[name='_csrf_header']").attr('content');
	var token = $("meta[name='_csrf']").attr('content');
	window.location.href = 'https://kauth.kakao.com/oauth/authorize?client_id=29ba16db25cdb9eb61b39a437825310b&redirect_uri=http://localhost:8080/kakao/callback&response_type=code';
}
