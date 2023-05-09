package com.example.apiexample.service

import com.example.apiexample.model.Comment
import com.example.apiexample.repository.CommentRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.data.domain.Sort.Direction

@Service
class CommentService(var repository: CommentRepository) {

    /**
     * Returns a list of all comments for a blog post with passed id.
     *
     * @param postId id of the post
     * @return list of comments sorted by creation date descending - most recent first
     */

    fun getCommentsForPost( postId: Long): List<Comment> {
       return repository.findAllByPostId(postId)
        //throw new UnsupportedOperationException(/*TODO*/
    }

    /**
     * Creates a new comment
     *
     * @param postId id of the post
     * @param newCommentDto data of new comment
     * @return id of the created comment
     *
     * @throws IllegalArgumentException if postId is null or there is no blog post for passed postId
     */
    fun addComment(postId: Long, newComment: Comment): Long{

        return 0
    }

}