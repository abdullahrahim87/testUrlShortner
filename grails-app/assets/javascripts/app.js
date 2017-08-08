/**
 * Created by Abdullah on 8/8/2017.
 */
$(document).ready(function() {
    $('#shortenForm').submit(function(e){
        e.preventDefault();
        createShortUrl();
    });

    $("#shortenUrl").click(function(){
        createShortUrl();
    });
    $('#expandUrlForm').submit(function(e){
        e.preventDefault();
        expandUrl();
    });

    $("#expandUrl").click(function(){
        expandUrl();
    });

});

function loadDataCompletionExpand(data){
    showSuccessMsg('.success-expand', "Your Full URL is: "+data.longUrl, '.success-shorten');
}

function showSuccessMsg(successDiv, msg, hideDiv){
    $(successDiv).slideDown("slow");
    $(successDiv).html(msg);
    $(hideDiv).slideUp("slow");
}

function loadDataCompletion(data){
    showSuccessMsg('.success-shorten', "Your Shortened URL is: "+data.shortUrl, '.success-expand');
}
function createShortUrl(){
    var url = $.trim($("#url").val());
    if(url){
        $.ajax({
            url: "url",
            method: "POST",
            data: JSON.stringify({ url : url }),
            dataType: "json",
            contentType: "application/json"
        }).done(loadDataCompletion)
            .fail(function( jqXHR, textStatus ) {
                showSuccessMsg(".success-shorten",jqXHR.responseJSON.error,".success-expand");
            });
    }
}

function expandUrl() {
    var url = $.trim($("#shortUrl").val());
    if(url){
        $.ajax({
            url: "url/expand",
            method: "POST",
            data: JSON.stringify({ shortUrl : url }),
            dataType: "json",
            contentType: "application/json"
        }).done(loadDataCompletionExpand)
            .fail(function( jqXHR, textStatus ) {
                showSuccessMsg(".success-expand",jqXHR.responseJSON.error,".success-shorten");
            });
    }
}