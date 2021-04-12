package ads

import grails.rest.Resource

@Resource(formats = ['json'])
class Thumbnail {

    static responseFormats = ['json']

    String uri
    Date dateCreated
    Date lastUpdated

    static belongsTo = [
            ad: Ad
    ]

    static constraints = {
    }

    static mapping = {
        autowire true
    }
}
