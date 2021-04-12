package ads

class AuthenticationToken {
    String token
    String username

    Date dateCreated

    static mapping = {
        version false
    }

    static constraints = {
        dateCreated nullable: true
    }
}
