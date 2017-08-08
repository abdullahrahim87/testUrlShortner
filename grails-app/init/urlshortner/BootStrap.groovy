package urlshortner

import com.urlshortner.auth.Authority
import com.urlshortner.auth.User
import com.urlshortner.auth.UserAuthority

class BootStrap {

    def init = { servletContext ->
        def role = Authority.findByAuthority("ROLE_USER")?:new Authority(authority:"ROLE_USER").save(flush:true)
        def user = User.findByUsername("newuser")?:new User(username:"newuser",password:"click123").save(flush:true)

        def userAuthority = UserAuthority.create(user,role,true)
    }
    def destroy = {
    }
}
