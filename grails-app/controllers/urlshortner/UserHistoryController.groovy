package urlshortner

import grails.plugin.springsecurity.annotation.Secured

class UserHistoryController {
    def springSecurityService
    def urlShortenerService
    @Secured(['ROLE_USER'])
    def index() {
            def userId = springSecurityService.getCurrentUserId()
            def userUrls = urlShortenerService.getUserUrls(Integer.valueOf(userId.intValue()))
            render(view: "index", model: [userUrls: userUrls])
    }
}
