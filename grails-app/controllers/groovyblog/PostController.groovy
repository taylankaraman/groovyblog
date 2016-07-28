package groovyblog

class PostController {

    static defaultAction = 'list'


    def beforeInterceptor = [action:this.&checkUser,except: ['list','view']]

    def checkUser() {
        if(!session.user) {
            // i.e. user not logged in
            redirect(controller:'user',action:'login')
            return false
        }
    }



    def edit = {
        def post = Post.get(params.id)
        if(!post) {
            post = new Post()
        }
        render(view:'edit', model:[post:post])
    }

    def list = {
        render(
                view:'list',
                model:[posts:Post.list(
                        sort:'lastUpdated',
                        order:'desc')])
    }

    def view = {
        def post = Post.get(params.id)
        render(view:'view', model:[post:post])
    }

    def save = {
        def post = loadPost(params.id)
        post.properties = params
        if(post.save()) {
            redirect(action:'list')
        } else {
            render(view:'edit', model:[post:post])
        }
    }

    private loadPost(id) {
        def post = new Post();
        if(id) {
            post = Post.get(id)
        }
        return post
    }

}
