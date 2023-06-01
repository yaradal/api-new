package com.example.apiexample.rest

import com.example.apiexample.model.Comment
import com.example.apiexample.model.Post
import com.example.apiexample.repository.CommentRepository
import com.example.apiexample.repository.PostRepository
import com.example.apiexample.service.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


@Controller
@RestController
@RequestMapping("/comments")
class CommentController(val service: CommentService) {

@Autowired
lateinit var repository : CommentRepository
    @GetMapping
    fun getAll(@RequestParam field: String?): List<Comment?>? {
       return null
    }
    @GetMapping
    fun getAllPosts(){}

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getPost(@PathVariable id: Long): List<Comment> {
         return repository.findAllByPostId(id)
    }

}