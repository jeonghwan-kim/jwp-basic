// $(".qna-comment").on("click", ".answerWrite input[type=submit]", addAnswer);
$(".answerWrite input[type=submit]").click(addAnswer);

function addAnswer(e) {
  e.preventDefault();

  var queryString = $("form[name=answer]").serialize();

  $.ajax({
    type : 'post',
    url : '/api/qna/addAnswer',
    data : queryString,
    dataType : 'json',
    error: onError,
    success : onSuccess,
  });
}

function onSuccess(json, status){
  var answer = json.answer;
  var answerTemplate = $("#answerTemplate").html();
  var template = answerTemplate.format(answer.writer, new Date(answer.createdDate), answer.contents, answer.answerId, answer.answerId);
  $(".qna-comment-slipp-articles").prepend(template);
}

function onError(xhr, status) {
  alert("error");
}

String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};

// 질문하기
$('.addQuestion button[type=submit]').click(addQuestion);
function addQuestion(e) {
  e.preventDefault();

  var queryString = $("form[name=question]").serialize();

  $.ajax({
    type : 'post',
    url : '/api/qna/addQuestion',
    data : queryString,
    dataType : 'json',
    error: function onError(e) {
      console.log(e);
    },
    success : function onSuccess(json, status){
      console.log(json, status);
      window.location.replace('/');
    }
    ,
  })
}