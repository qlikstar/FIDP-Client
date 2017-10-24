var progressBar = $('.progress-bar');
var percentVal = 100;

window.setInterval(function(){
    //percentVal += 10;
    progressBar.css("width", percentVal + '%').attr("aria-valuenow", percentVal+ '%').text('Waiting for you to respond to the push notification ...');

    /* if (percentVal == 100)
    {
      percentVal = 0;
    } */

}, 500);
