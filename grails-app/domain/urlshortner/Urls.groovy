package urlshortner

class Urls {
    String url
    String shortUrl
    Integer userId
    static constraints = {
        url blank: false, validator: {
            if (!(it.startsWith("http://") || it.startsWith("https://")) ) return ['URL must start with http://']
        }
        shortUrl blank: false, validator: {
            if (!(it.startsWith("http://") || it.startsWith("https://"))) return ['URL must start with http://']
        }
        userId blank: true, nullable: true
    }
}
