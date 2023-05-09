package com.example.apiexample.repository

import com.example.apiexample.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CommentRepository: JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.postId = :post_id ORDER BY c.createdAt ASC")
    fun findAllByPostId(@Param("post_id") postId: Long):List<Comment>
}