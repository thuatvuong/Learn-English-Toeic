$(document).ready(function () {
    var id = new URLSearchParams(window.location.search).get('id');

    $.ajax({
        type: "GET",
        url: "api/client/bai-bao/article/" + id,
        success: function (result) {
            $("#pTag").removeClass().addClass("hidden");
            var html = '<div class="span9">'
                + '<h2 style="font-weight: bold">' + result.title + '</h2>'
                + '<div>' + result.content + '</div>'
                + '<div style="margin-top: 30px"><span style="font-weight: bold">Source:  </span>   <a target="_blank" href="' + result.url + '</a> ">' + result.url + '</div>';
            $('.danhSach').append(html);
        },
        error: function (e) {
            console.log(e);
        }
    })
});
