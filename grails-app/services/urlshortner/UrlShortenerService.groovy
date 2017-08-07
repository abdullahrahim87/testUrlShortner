package urlshortner

import grails.core.GrailsApplication
import grails.transaction.Transactional

@Transactional
class UrlShortenerService {
    GrailsApplication grailsApplication
    def googleUrlShortenerService
    def create(url) {
        try{
            def dbUrlObject = Urls.findByUrl(url)
            def shortUrl
            if(dbUrlObject){
                shortUrl = dbUrlObject.shortUrl
            }
            else{
                def urlObject = googleUrlShortenerService.create(url)
                shortUrl = urlObject.shortUrl
                Urls newUrl = new Urls()
                newUrl.shortUrl  = urlObject.shortUrl
                newUrl.url = url
                newUrl.userId = 1
                newUrl.save (flush:true, failOnError: true)
            }
            return [shortUrl: shortUrl]
        }
        catch (Exception ex){
            return ["error": "Service Unavailable"]
        }
    }

    def expand(shortUrl){
        try{
            def dbUrlObject = Urls.findByShortUrl(shortUrl)
            def longUrl
            if(dbUrlObject){
                longUrl = dbUrlObject.url
            }
            else{
                def urlObject = googleUrlShortenerService.expand(shortUrl)
                fullUrl = urlObject.longUrl
                Urls newUrl = new Urls()
                newUrl.shortUrl  = shortUrl
                newUrl.url = fullUrl
                newUrl.userId = 1
                newUrl.save (flush:true, failOnError: true)
            }
            return [longUrl: longUrl]
        }
        catch (Exception ex){
            return ["error": "Service Unavailable"]
        }
    }

}
