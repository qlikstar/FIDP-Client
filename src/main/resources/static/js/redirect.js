setInterval(function() {
    $.ajax({
        type: "POST",
        url: "/login?username=sanket",
        data: null,
        success: function () {
            location.reload();
        }
    })
},10000);