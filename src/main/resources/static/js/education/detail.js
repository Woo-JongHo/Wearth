
// 그룹 버튼 누를 때 이벤트 작동
function showContent(contentNumber) {
    // 모든 content 클래스 요소를 선택합니다.
    const contents = document.querySelectorAll('.content');

    // 선택한 contentNumber에 해당하는 요소만 보이도록 스타일을 변경합니다.
    for (let i = 0; i < contents.length; i++) {
        if (i === contentNumber - 1) {
            contents[i].style.display = 'block';
        } else {
            contents[i].style.display = 'none';
        }
    }
}


// 댓글 등록 버튼 누를 때 이벤트 작동
const btnReply = document.getElementById("btnReply");
const commentsContainer = document.querySelector(".comments");

btnReply.addEventListener("click", function() {
	
	event.preventDefault(); // 폼 전송 기본 동작 막기 <db 연동 전,, 임시>
	
  const contentInput = document.getElementById("content").value;
  if (contentInput.trim() !== "") {
    addComment(contentInput);
    document.getElementById("content").value = "";
  }
});

function addComment(content) {
  const currentDate = new Date().toLocaleString();
  const comment = document.createElement("div");
  comment.classList.add("comment");
  comment.innerHTML = `
    <p>${content}</p>
    <p class="date">${currentDate}</p>
  `;
  commentsContainer.appendChild(comment);
}

// 문의 비밀번호 작성 확인 완료 시 게시글 조회
       function checkPassword(postId) {
        var passwordInput = document.getElementById('password' + postId).value;
        // 여기서는 간단한 예시를 위해 비밀번호를 'password'로 가정하고, 실제로는 서버나 데이터베이스에서 확인해야 합니다.
        var correctPassword = '1234';

        if (passwordInput === correctPassword) {
            var postContent = document.getElementById('postContent' + postId);
            postContent.style.display = 'block';
        } else {
            swal('비밀번호 오류','비밀번호가 올바르지 않습니다.','warning');
        }
    }
  
// 문의 등록글 비밀번호 체크 확인 할 때 비밀번호 입력 창 보이게 하기
document.addEventListener("DOMContentLoaded", function() {
  // 비밀글 체크박스 요소 가져오기
  const secretCheckbox = document.getElementById("flexSwitchCheckDefault");
  
  // 비밀글 체크박스 상태 변경 이벤트 리스너 등록
  secretCheckbox.addEventListener("change", function() {
    // 비밀글 체크박스가 체크되었는지 확인
    if (this.checked) {
      // 체크되었을 때, 비밀번호 작성 창 보이도록 설정
      document.getElementById("mb-3").style.display = "block";
    } else {
      // 체크되지 않았을 때, 비밀번호 작성 창 숨기도록 설정
      document.getElementById("mb-3").style.display = "none";
    }
  });
});  
  
    
// 문의 게시글 작성 모달
var myModal = document.getElementById('myModal')
var myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', function () {
  myInput.focus()
})

var exampleModal = document.getElementById('exampleModal')
exampleModal.addEventListener('show.bs.modal', function (event) {
  // Button that triggered the modal
  var button = event.relatedTarget
  // Extract info from data-bs-* attributes
  var recipient = button.getAttribute('data-bs-whatever')
  // If necessary, you could initiate an AJAX request here
  // and then do the updating in a callback.
  //
  // Update the modal's content.
  var modalTitle = exampleModal.querySelector('.modal-title')
  var modalBodyInput = exampleModal.querySelector('.modal-body input')

  modalTitle.textContent = 'New message to ' + recipient
  modalBodyInput.value = recipient
})