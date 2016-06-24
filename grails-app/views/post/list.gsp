<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>My Posts</title>
    </head>
    <body>
        <h1>My Posts</h1>

        <g:each in="${posts}" var="post">
            <div>
                <h2>${post.title}</h2>
                <p>${post.teaser}</p>
                <p>Last Updated: ${post.lastUpdated}</p>

                <g:link controller="post" action="view" id="${post.id}">
                    View this post
                </g:link>
            </div>
            <div>
                <g:link controller="post" action="edit" id="${post.id}">
                    Edit this post
                </g:link>

            </div>
        </g:each>

        <g:link controller="post" action="edit">
            Create a new post
        </g:link>
    </body>
</html>