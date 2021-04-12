package ads

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.rest.RestfulController

class AdController extends RestfulController<Ad> {

    SpringSecurityService springSecurityService

    static allowedMethods = [getUserAds: 'GET', ads: 'GET']

    AdController() {
        super(Ad)
    }


    def index() {
        response.withFormat {
            json { render Ad.list(sort: 'dateCreated', order: 'desc') as JSON }
        }
    }

    def save(Ad ad) {
        def authId = springSecurityService.authentication.principal.getId()
        def author = User.findAllById(authId)
        def newAdd = new Ad(
                name: ad.name,
                price: ad.price,
                s_des: ad.s_des,
                b_des: ad.b_des,
                author: author
        ).save()
        response.withFormat {
            json { render newAdd as JSON }
        }
    }

    def getUserAds() {
        def authId = springSecurityService.authentication.principal.getId()
        def author = User.findById(authId)
        response.withFormat {
            json { render Ad.findAllByAuthor(author) as JSON }
        }
    }

    def ads() {
        response.withFormat {
            json { render Ad.where{status == true}.list(sort: 'dateCreated', order: 'desc') as JSON }
        }
    }

}
