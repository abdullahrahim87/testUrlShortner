package urlshortner

import grails.test.mixin.TestFor
import grails.test.mixin.web.ControllerUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UrlController)
class UrlControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test for invalid JSON"() {
        when:
        request.method = "post"
        request.json = "{url:'http://google.com'}"
        controller.create()
        then:
        response.status == 400
    }

}
