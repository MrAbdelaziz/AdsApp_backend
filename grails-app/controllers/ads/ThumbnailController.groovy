package ads

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.rest.RestfulController

class ThumbnailController extends RestfulController<Thumbnail> {

    SpringSecurityService springSecurityService

    static allowedMethods = [getThumbnailAds: 'GET']

    ThumbnailController() {
        super(Thumbnail)
    }

    def getThumbnailAds() {
        def ad_id = params.id
        def ad = Ad.findAllById(ad_id)
        response.withFormat {
            json { render Thumbnail.findAllByAd(ad) as JSON }
        }
    }

    def save(Thumbnail thumbnail) {
        def t = new Thumbnail(uri: thumbnail.uri, ad: thumbnail.ad).save()
        response.withFormat {
            json { render t as JSON }
        }
    }

}
