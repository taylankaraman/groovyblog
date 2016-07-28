<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>${post.title}</title>
    </head>

    <body>
        <h1>${post.title}</h1>
        <p>${post.teaser}</p>
        <div>${post.content}</div>

        <g:each in="${post.comments}" var="comment">
            <div class="comment">
                <p>${comment.comment}</p>
                <p>Made by: ${comment.who.name} on ${comment.dateCreated}</p>
            </div>
        </g:each>

    <div>
        <g:link controller="comment" action="edit" id="${post.id}">
            Add a comment
        </g:link>
    </div>

    <div>
        <g:link controller="post" action="list">
            Go back to my posts page
        </g:link>
    </div>

    </body>
</html>