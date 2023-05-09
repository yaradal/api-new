package com.example.apiexample.service

import com.example.apiexample.model.Post
import com.example.apiexample.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class PostService(val repository: PostRepository) {

    fun getAllPosts(): List<Post> =
        repository.findAll()

    fun getPost(id: Long): Post {
        return repository.findById(id)
            .map { post -> Post(post.title, post.content, post.createdAt) }
            .orElse(null)
    }

    fun getPostById(id: Long): Post {
        // var post = repository.findById(id).unwrap()
        return repository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun createPost(post: Post) = repository.save(post)

    fun removePost(id: Long) {
        if (repository.existsById(id))
            repository.deleteById(id)
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun updatePost(id: Long, post: Post): Post {
        return if (repository.existsById(id)) {
            repository.save(post)
        } else
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }


    // change from optional list to list of object
    fun <T> Optional<T>.unwrap(): T? = orElse(null)

}