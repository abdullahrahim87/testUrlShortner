package urlshortner

import grails.core.GrailsApplication
import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional
import sun.font.TrueTypeFont

@Transactional
class GoogleUrlShortenerService {
    GrailsApplication grailsApplication
    def create(url) {
        RestBuilder rb = new RestBuilder()
        def apiKey =grailsApplication.getConfig().getProperty("googleService.apiKey");
        def serviceEndpoint = grailsApplication.getConfig().getProperty("googleService.url")+"?key="+apiKey

        def resp = rb.post(serviceEndpoint){
        contentType "application/json"
                json {
                    longUrl = url
                }
            }
        [shortUrl:resp.json.id]
    }

    def expand(shortUrl){
        RestBuilder rb = new RestBuilder()
        def apiKey =grailsApplication.getConfig().getProperty("googleService.apiKey");
        def serviceEndpoint = grailsApplication.getConfig().getProperty("googleService.url")+"?key="+apiKey

        def resp = rb.get(serviceEndpoint){
            contentType "application/json"
            json {
                shortUrl = shortUrl
            }
        }
        [longUrl:resp.json.longUrl]

    }

}
