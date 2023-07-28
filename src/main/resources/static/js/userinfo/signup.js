/**
 * 
 */

   // 유효성 검사를 위한 변수들
	  let isVaildId = false;
	  let isVaildPwd = false;
	  let isVaildEmail = false;
	  let isVaildNickname = false;
	  let isVaildPhone = false;
	  
	  //입력 유효성 검사 드읃ㅇ
	 $(document).ready(function() {
		 // 비밀번호 일치 검사
		 	var item = document.getElementById('labelPwdCheck');
		 	document.getElementById('inputPwdCheck').addEventListener('keyup', function() {
		    var pwd =  document.getElementById('inputPwd').value;
		    var pwdCheck = this.value; 
		    if(pwd==pwdCheck){
				item.textContent = '비밀번호가 일치합니다.';
				item.style.color = "blue";
				isVaildPwd = true;
			} else {
				item.textContent = '비밀번호가 일치하지않습니다.';
				item.style.color = "red";
				isVaildPwd = false;
			}
		  });
		  document.getElementById('inputPwd').addEventListener('keyup', function() {
		    var pwdCheck =  document.getElementById('inputPwdCheck').value;
		    var pwd = this.value; 
		    if(pwd==pwdCheck){
				item.textContent = '비밀번호가 일치합니다.';
				item.style.color = "blue";
				isVaildPwd = true;
			} else {
				item.textContent = '비밀번호가 일치하지않습니다.';
				item.style.color = "red";
				isVaildPwd = false;
			}
		  
		  });
		  // 아이디 keyup
		  document.getElementById('inputId').addEventListener('keyup', function() {
		    isVaildId = false;
		  });
		  // 닉네임 keyup
		  document.getElementById('inputNickname').addEventListener('keyup', function() {
		    isVaildNickname = false;
		  });
		  
		  // 이메일 keyup
		  document.getElementById('inputEmail').addEventListener('keyup', function() {
		    isVaildEmail = false;
		  });
		  document.getElementById('inputEmailUrl').addEventListener('click', function() {
		    isVaildEmail = false;
		  });
		  // 전화번호 keyup
		  document.getElementById('inputPhone1').addEventListener('keyup', function() {
		      if(document.getElementById('inputPhone1').value.length>=3){
				  let tmp = document.getElementById('inputPhone1').value.substring(0,3);
				  document.getElementById('inputPhone1').value = tmp;
				  document.getElementById('inputPhone2').focus();
			  }
		  });
		  document.getElementById('inputPhone2').addEventListener('keyup', function() {
		      if(document.getElementById('inputPhone2').value.length>=4){
				  let tmp = document.getElementById('inputPhone2').value.substring(0,4);
				  document.getElementById('inputPhone2').value = tmp;
				  document.getElementById('inputPhone3').focus();
			  }
		  });
		  document.getElementById('inputPhone3').addEventListener('keyup', function() {
		      if(document.getElementById('inputPhone3').value.length>=4){
				  let tmp = document.getElementById('inputPhone3').value.substring(0,4);
				  document.getElementById('inputPhone3').value = tmp;
			  }
		  });
		  
		  
	});
	
	// 전화번호 중복 검사
	  function checkPhone(phone) {
	    return $.ajax({
	     url: "/userinfo/checkPhone",
	     data: { phone: phone },
	     method: "get",
	     success : function(result){
			 if(result=='T'){
				 isvalisVaildPhone = true;
			 }
		 }
	    });
	  }
	  
	//아이디 중복확인
	function checkId(){
		var id = document.getElementById('inputId').value;
		if(id==null || id==''){
			swal('아이디 중복 검사 오류', "아이디를 입력하세요.", 'warning');
		} else if(id.length<4 || id.length>12) {
			swal('아이디 중복 검사 오류', "4~12글자 이내로 입력하세요.", 'warning');
		} else {
			$.ajax({
				url : "/userinfo/checkId",
				data : {id:id},
				method : "get",
				success : function(result){
					if(result =='T'){
						swal('아이디 중복 검사 완료', "사용가능한 아이디입니다.", 'success');
						isVaildId = true;						
					} else{
						swal('아이디 중복 검사 완료', "존재하는 아이디입니다.\n다른 아이디를 입력해주세요.", 'warning');						
					}
				}
			});
		}
	};
	
	//닉네임 중복확인
	function checkNickname(){
		var nickname = document.getElementById('inputNickname').value;
		if(nickname==null || nickname==''){
			swal('닉네임 중복 검사 오류', "닉네임을 입력하세요.", 'warning');
		} else if(nickname.length<3 || nickname.length>7) {
			swal('닉네임 중복 검사 오류', "3~7글자 이내로 입력하세요.", 'warning');
		} else {
			$.ajax({
				url : "/userinfo/checkNickname",
				data : {nickname:nickname},
				method : "get",
				success : function(result){
					if(result =='T'){
						swal('닉네임 중복 검사 완료', "사용가능한 닉네임입니다.", 'success');
						isVaildNickname = true;						
					} else{
						swal('닉네임 중복 검사 완료', "존재하는 닉네임입니다.\n다른 닉네임 입력해주세요.", 'warning');						
					}
				}
			});
		}
	};
	
	//이메일 중복확인
	function checkEmail(){
		var email = document.getElementById('inputEmail').value+'@'+document.getElementById('inputEmailUrl').value;
		if(document.getElementById('inputEmail').value==null || document.getElementById('inputEmail').value==""
		|| document.getElementById('inputEmailUrl').value=="none"){
			swal('이메일 입력 오류', "올바른 이메일을 입력하세요.", 'warning');
		} else {
			$.ajax({
				url : "/userinfo/checkEmail",
				data : {email:email},
				success : function(msg){
					if(msg==null ||  msg == ""){
						document.getElementById('divEmailCheck').style.display = 'block';
						document.getElementById("inputEmailCheck").disabled = false;
						$.ajax({
							url : "/userinfo/isVaildEmail",
							data : {email:email},
							method : "get",
							success : function(msg){
								swal(msg,'인증번호를 입력해주세요.', 'info');
							}
						})
					} else {
						swal('이메일 중복 오류', msg, 'warning');
					}
			}
		})
		}
		
	
	};
	//이메일 인증
	function checkEmailCheck(){
		var code = document.getElementById('inputEmailCheck').value;
		var header = $("meta[name='_csrf_header']").attr('content');
		var token = $("meta[name='_csrf']").attr('content');
		$.ajax({
			url : "/userinfo/isVaildEmail",
			data : { code : code},
			beforeSend: function(xhr){
		        xhr.setRequestHeader(header, token);
		    },
			method : "post",
			success : function(msg){
				if(msg=='T'){
					swal('이메일 인증 완료', "인증이 완료되었습니다.", 'success');
					isVaildEmail=true;
				} else {
					swal('이메일 인증 오류', "인증번호가 올바르지 않습니다. 다시 인증해주세요.", 'warning');
				}
			}
		});
	};
	
	// 회원가입 버튼 눌렀을때
	function submitForm(){
		 var myForm = document.getElementById('form');
		 document.getElementById("finalPhone").value=
	     document.getElementById('inputPhone1').value+document.getElementById('inputPhone2').value+document.getElementById('inputPhone3').value;
	     document.getElementById("finalEmail").value = 
	  	 document.getElementById('inputEmail').value+document.getElementById('inputEmailUrl').value;
		// 변수들의 값을 확인하여 모두 true인 경우에만 폼을 전송
		if(document.getElementById('inputResidence').value=="" || document.getElementById('inputResidence').value==null){
			swal('회원가입 실패', '주소를 입력해주세요.', 'warning');
		} else if (isVaildId && isVaildPwd && isVaildEmail && isVaildNickname && isVaildPhone) {
      	  myForm.method="post";
      	  myForm.action="/userinfo/signup";
      	  $("#form").submit();  
	    } else if(!isVaildId){
			swal('회원가입 실패', '아이디 중복검사를 해주세요.', 'warning');
		} else if(!isVaildPwd){
			swal('회원가입 실패', '동일한 비밀번호를 입력해주세요.', 'warning');
		} else if(!isVaildNickname){
			swal('회원가입 실패', '닉네임 중복검사를 해주세요.', 'warning');
		} else if(!isVaildEmail){
			swal('회원가입 실패', '이메일 인증을 해주세요.', 'warning');
		} else if(!isVaildPhone){
			swal('회원가입 실패', '중복되는 전화번호가 있습니다.', 'warning');
		}  else {
			swal('회원가입 실패', '잠시후 다시 시도해주세요.', 'warning');
		}
	
	};
	  
	  
	//카카오로그인
	 Kakao.init("805b5d2e52d8f6303fb372ca5efd7e30");
	  function kakaoLogin(){
		  Kakao.Auth.loginForm({
			scope:"account_email, gender, birthday, profile_image",
			success:function(){
				Kakao.API.request({
					url:"/v2/user/me",
				}).then(function(data){
					var userInfo = {email: data.kakao_account.email ,
						birthday : data.kakao_account.birthday ,
						gender : data.kakao_account.gender ,
						image : data.kakao_account.profile.profile_image_url
					}
					
					location.href = "";
				}).catch(function(error){
					console.log(error);
				})
			}
	      });
	  }
	  
	  // 주소 검색 api
	  function searchResidence(){
	      new daum.Postcode({
	         oncomplete: function(data) {
		            document.getElementById('inputResidence').value = data.address;
	        	}
		    }).open();
		    
	  }
	  
	  