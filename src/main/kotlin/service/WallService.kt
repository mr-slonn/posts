package service

import data.Post

class WallService {
    private var posts = emptyArray<Post>()
    private var postId = 0

    fun add(post: Post): Post {
        postId += 1
        posts += post.copy(id = postId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, oldPost) in posts.withIndex()) {
            if (oldPost.id == post.id) {
                posts[index] = post.copy(id=oldPost.id,fromId = oldPost.fromId, date = oldPost.date )
                return true
            }
        }
        return false
    }

    fun removeById(id: Int): Boolean {
        val postsList = posts.toMutableList()
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                postsList.removeAt(index)
                posts = postsList.toTypedArray()
                return true
            }
        }
        return false
    }

    fun likeById(id: Int) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(likes = post.likes.copy(count = +1))
                break
            }
        }
    }
}
