package urlshortner

import grails.core.GrailsApplication
import grails.transaction.Transactional

@Transactional
class UrlShortenerService {
    GrailsApplication grailsApplication
    def googleUrlShortenerService
    def create(url, userId = 0) {
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
                newUrl.userId = userId
                newUrl.save (flush:true, failOnError: true)
            }
            return [shortUrl: shortUrl]
        }
        catch (Exception ex){
            throw new Exception(ex.getMessage())
        }
    }

    def expand(shortUrl,userId = 0){
        try{
            def dbUrlObject = Urls.findByShortUrl(shortUrl)
            def longUrl
            if(dbUrlObject){
                longUrl = dbUrlObject.url
            }
            else{
                def urlObject = googleUrlShortenerService.expand(shortUrl)
                longUrl = urlObject.longUrl
                Urls newUrl = new Urls()
                newUrl.shortUrl  = shortUrl
                newUrl.url = fullUrl
                newUrl.userId = userId
                newUrl.save (flush:true, failOnError: true)
            }
            return [longUrl: longUrl]
        }
        catch (Exception ex){
            throw new Exception(ex.getMessage())
        }
    }

    def getUserUrls(userId){
         Urls.findAllByUserId(userId)
    }
}