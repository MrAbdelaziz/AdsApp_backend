package ads

class BootStrap {

    def init = { servletContext ->

        User user = new User(
                username: "user",
                password: 'user',
                enabled: true
        ).save(flush:true, failOnError: true)

        User a_user = new User(
                username: "admin",
                password: 'admin',
                enabled: true
        ).save(flush:true, failOnError: true)

        Ad ad = new Ad(
                name: "ad__1",
                b_des: "big",
                s_des: "small",
                status: true,
                price: 12,
                author: user
        ).save(flush:true, failOnError: true)

        new Thumbnail(
                uri: "aa",
                ad: ad
        ).save(flush:true, failOnError: true)

        Role role = new Role(
                authority: "ROLE_USER"
        ).save(flush:true, failOnError: true)

        Role r_admin = new Role(
                authority: "ROLE_ADMIN"
        ).save(flush:true, failOnError: true)

        UserRole.create(user, role)
        UserRole.create(a_user, r_admin)

    }

    def destroy = {
    }
}
