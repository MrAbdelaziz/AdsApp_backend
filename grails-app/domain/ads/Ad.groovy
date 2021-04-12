package ads

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.Resource

@Secured(["permitAll"])
@Resource(formats = ['json'])
class Ad {

    String name
    String b_des
    String s_des
    Boolean status = Boolean.FALSE
    Float price
    Date dateCreated
    Date lastUpdated

    static belongsTo = [
            author: User
    ]

    static hasMany = [
            thumbnails: Thumbnail
    ]

    static constraints = {}

    static mapping = {
        autowire true
    }

}
