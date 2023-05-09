package com.example.apiexample.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Comment {
    @Id
    var id: Long = TODO("initialize me")
    var postId: Long
    var createdAt: LocalDateTime
}