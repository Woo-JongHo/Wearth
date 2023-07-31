  // Alert Redirect to Another Link
    $(document).on('click', '#link', function(e) {
        swal({
        title: "게시글 삭제", 
        text: "정말 삭제하시겠습니까?", 
        type: "warning",
        confirmButtonText: "삭제",
         cancelButtonText: "취소",
        showCancelButton: true
        })
          .then((result) => {
          if (result.value) {
			  swal(
                '게시글 삭제',
                '게시글이 삭제되었습니다 :)',
                'success'
              )
              window.location = 'localhost:8080/school/trainingRequest/detailAdmin';
          } else if (result.dismiss === 'cancel') {
              swal(
                '게시글 삭제',
                '게시글 삭제를 취소하였습니다.',
                'error'
              )
          }
        })
    });