/**
 * Created by Abdullah on 8/8/2017.
 */
$(document).ready(function() {
    $("#shortenUrl").click(function(){
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
                    alert( "Request failed: " + textStatus );
                });
        }
    });

    $("#expandUrl").click(function(){
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
                    alert( "Request failed: " + textStatus );
                });
        }
    });

});

function loadDataCompletionExpand(data){

    $('.success-expand').html("Your Full URL is: "+data.longUrl);
    $('.success-expand').slideDown();

}
function loadDataCompletion(data){
    $('.success-shorten').html("Your Shortened URL is: "+data.shortUrl);
    $('.success-shorten').slideDown();
}
