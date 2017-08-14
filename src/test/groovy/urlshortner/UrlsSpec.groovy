package urlshortner

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Urls)
class UrlsSpec extends Specification {
    @Unroll('validate on a person with age #personAge should have returned #shouldBeValid')
    void "test url"() {
        expect:
         new Urls(url: url, shortUrl:"http://google.com", userId:  12).validate() == shouldBeValid
        where:
        url | shouldBeValid
        ""       | false
        "asdf"        | false
        "http://google.com"         | true
    }

    @Unroll('validate on a person with age #personAge should have returned #shouldBeValid')
    void "test shorturl"() {
        expect:
        new Urls(url: "http://google.com", shortUrl:url, userId:  12).validate() == shouldBeValid
        where:
        url | shouldBeValid
        ""       | false
        "asdf"        | false
        "http://google.com"         | true
    }


}
