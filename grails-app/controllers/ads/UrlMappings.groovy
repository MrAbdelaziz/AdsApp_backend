package ads

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {

            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        group "/api", {
            "/ads"(resources: "ad")
            "/users"(resources: "user")
            "/thumbnails"(resources: "thumbnail")
            "/user/ads"(controller:'ad', action:'getUserAds')
            "/counts"(controller:'user', action:'getCounts')
            "/homeAds"(controller:'ad', action:'ads')
            "/ad/$id/thumbnails"(controller:'thumbnail', action:'getThumbnailAds')
        }

    }
}
