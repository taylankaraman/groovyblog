import groovyblog.PostController

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

//		"/"(view:"/index")

		"/"
			{
				controller = "Post"
			}

		"500"(view:'/error')
	}
}
