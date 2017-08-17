package urlshortner

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import org.grails.web.converters.exceptions.ConverterException
import org.springframework.http.HttpStatus
@Secured(['permitAll()'])
class UrlController {
    def urlShortenerService
    def springSecurityService

    def index() { }
    def create() {
        try{
            def requestJson = request.getJSON()
            def url = requestJson.url
            if(url){
                def result = urlShortenerService.create(url,springSecurityService.getCurrentUserId()?:0 )
                render result as JSON
            }
            else{
                throwExceptionMsg(["error":message(code:  "urlshortner.please.enterurl")])
            }
        }
        catch(ConverterException ex){
            throwExceptionMsg(["error":message(code:  "urlshortner.please.invalid.json")])
        }
        catch (Exception ex){
            log.info(ex.getMessage())
            throwExceptionMsg(["error":message(code:  "urlshortner.please.serviceunavailable")])
        }
    }

    private def throwExceptionMsg(result){
        response.setStatus(HttpStatus.BAD_REQUEST.value())
        render result as JSON
    }

    def expand(){
        try{
            def requestJson = request.getJSON()
            def shortUrl = requestJson.shortUrl
            if(shortUrl) {
                def result = urlShortenerService.expand(shortUrl, springSecurityService.getCurrentUserId() ?: 0)
                render result as JSON
            }else{
                throwExceptionMsg(["error":message(code:  "urlshortner.please.enterurl")])
            }
        }
        catch (ConverterException ex){
            throwExceptionMsg(["error":message(code:  "urlshortner.please.invalid.json")])
        }
        catch (Exception ex){
            log.info(ex.getMessage())
            throwExceptionMsg(["error":message(code:  "urlshortner.please.serviceunavailable")])
        }
    }
}
