String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};

(function($){
  function getValueOf(el) {
    return $(el).val();
  }
  function addAnswer (e) {
    console.log(e);
    e.preventDefault();

    var formData = {
      title: getValueOf($('#writer')[0]),
      body: getValueOf($('#contents')[0])
    }

    var querystring  = $('.answerWrite form').serialize()

    console.log(querystring);

    $.ajax({
      type: 'post',
      url: '/api/qna/addanswer',
      data: querystring,
      error: onError,
      success: onSuccess
    });

    function onError(e) {
      console.log(e);
    }

    function onSuccess(r) {
      console.log(r);
    }
  }


  $('.answerWrite input[type=submit]').click(addAnswer);

})(jQuery)