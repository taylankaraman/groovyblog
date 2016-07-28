package groovyblog

class CommentController {

    def edit = {
        render(view:'edit',
                model:[
                        comment:new Comment(),
                        postId:params.id])
    }

    def save = {
        def comment = new Comment(params)
        comment.dateCreated = new Date();
        comment.post = Post.get(params.postId)
        if(comment.save()) {
            redirect(
                    controller:'post',
                    action:'view',
                    id:params.id)
        } else {
            render(view:'edit',
                    model:[comment:comment,
                           postId:params.id])
        }
    }
}
