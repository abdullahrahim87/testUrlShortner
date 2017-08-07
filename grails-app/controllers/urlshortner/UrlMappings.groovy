package urlshortner

class UrlMappings {

    static mappings = {
        "/url"(controller:"url", action: "create", method: "POST")
        "/url/expand"(controller:"url", action: "expand", method: "POST")
        /*
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        */
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
