package urlshortner

import grails.converters.JSON

class UrlController {
    def urlShortenerService
    def index() { }
    def create() {
        def requestJson = request.getJSON()
        def url = requestJson.url
        def result = urlShortenerService.create(url)
        render result as JSON
    }

    def expand(){
        def requestJson = request.getJSON()
        def shortUrl = requestJson.shortUrl
        def result = urlShortenerService.expand(shortUrl)
        render result as JSON
    }
}
