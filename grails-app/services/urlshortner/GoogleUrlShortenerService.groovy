package urlshortner

import grails.core.GrailsApplication
import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

@Transactional
class GoogleUrlShortenerService {
    GrailsApplication grailsApplication
    def create(url) {
        RestBuilder rb = new RestBuilder()
        def apiKey = grailsApplication.getConfig().getProperty("googleService.apiKey");
        def serviceEndpoint = grailsApplication.getConfig().getProperty("googleService.url")+"?key="+apiKey

        def resp = rb.post(serviceEndpoint){
        contentType "application/json"
                json {
                    longUrl = url
                }
            }
        if(resp.json.error){
            throw new Exception(resp.json.error.message)
        }
        else{
            return [shortUrl:resp.json.id]
        }
    }

    def expand(shortUrl){
        RestBuilder rb = new RestBuilder()
        def apiKey = grailsApplication.getConfig().getProperty("googleService.apiKey");
        def serviceEndpoint = grailsApplication.getConfig().getProperty("googleService.url")+"?key="+apiKey

        def resp = rb.get(serviceEndpoint){
            contentType "application/json"
            json {
                shortUrl = shortUrl
            }
        }
        return [longUrl:resp.json.longUrl]
    }

}
