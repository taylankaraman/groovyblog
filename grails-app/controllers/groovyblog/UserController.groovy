package groovyblog

class UserController {

    def index() { }

    def login(){
        render(view:'login')
    }

    def doLogin = {
        def user = User.findWhere(email:params['email'],
                password:params['password'])
        session.user = user
        if (user)
            redirect(controller:'post',action:'list')
        else
            redirect(controller:'user',action:'login')
    }

}
