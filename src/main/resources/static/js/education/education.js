// 좋아요 이미지 변경 자바스크립트
var isLiked = {};

function changeImage(id) {
  var heartImage = document.getElementById(id);
  if (!isLiked[id]) {
    heartImage.src = "/images/education/redHeart.jpg";
    isLiked[id] = true;
  } else {
    heartImage.src = "/images/education/whiteHeart.jpg";
    isLiked[id] = false;
  }
}
