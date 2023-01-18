package service

import data.Post

class WallService {
    private var posts = emptyArray<Post>()
    private var postId = 0L

    fun clear() {
        posts = emptyArray()
        postId = 0
    }

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

    fun removeById(id: Long): Boolean {
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

    fun likeById(id: Long): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(likes = post.likes.copy(count = +1))
                return true
            }
        }
        return false
    }

    fun getLikeById(id: Long): Int {
        for (post in posts) {
            if (post.id == id) {
                return post.likes.count
            }
        }
        return 0
    }



}
