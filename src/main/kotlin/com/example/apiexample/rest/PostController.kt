package com.example.apiexample.rest

import com.example.apiexample.model.Post
import com.example.apiexample.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException




@Controller
@RestController
@RequestMapping("/posts")
class PostController(val service: PostService) {

    @GetMapping
    fun getAllPosts() = service.getAllPosts()

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getPost(@PathVariable id: Long): Post {
        return service.getPostById(id)
       // throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Available statuses are: CREATED, APPROVED, REJECTED, BLOCKED, DONE.")

    }

    fun isStatusValid(status: String): Boolean {
        return (status.equals("CREATED") || status.equals("CREATED") || status.equals("APPROVED") || status.equals("REJECTED") || status.equals(
            "BLOCKED") || status.equals("DONE"))
    }

    @GetMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.OK)
    fun getPost2(@PathVariable id: Long): Post {
        return service.getPost(id)
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun savePost(@RequestBody post: Post): Post {
        return service.createPost(post)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePost(@PathVariable id: Long) {
        service.removePost(id)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody post: Post): Post {
        return service.updatePost(id, post)
    }

    //    Save a new comment with current date and time for post with passed {id}
//    Return 201 Created if comment is created successfully for post with passed {id}
//    Return 404 Not Found if post with passed {id} does not exist
    @PostMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewCommentToPost(@PathVariable id: Long) {

    }

    //    GET at /posts/{id}/comments which should:
    //    Return all comments sorted by creation date in descending order for a post with passed {id}
    //    Return empty list if a post with passed {id} does not exists or when it does not contain any comments
    @GetMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    fun returnCommentToPost(@PathVariable id: Long) {

    }


    fun parseCommand (input: String){
        input.split(" ")
    }
}