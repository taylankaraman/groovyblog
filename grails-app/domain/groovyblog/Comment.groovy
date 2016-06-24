package groovyblog

class Comment implements Comparable {

    static belongsTo = Post

    Post post
    String comment
    Commentor who = new Commentor()
    Date dateCreated

    public int compareTo(Object o) {
        return dateCreated.compareTo(o.dateCreated)
    }
}
