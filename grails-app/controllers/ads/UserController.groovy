package ads

import grails.converters.JSON
import grails.rest.RestfulController

class UserController extends RestfulController<User> {

    static allowedMethods = [getCounts: 'GET']

    UserController() {
        super(User)
    }

    def getCounts() {
        def adCounts = Ad.count()
        def userCounts = User.count()
        response.withFormat {
            json { render (['adCounts': adCounts, 'userCounts':userCounts] as JSON) }
        }
    }

}
