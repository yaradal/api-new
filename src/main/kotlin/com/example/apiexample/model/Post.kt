package com.example.apiexample.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
class Post (
    @Id
    @GeneratedValue
    var id: Long ,
    var title: String ,
    var content: String,
    @Column(name="created_at")
    var createdAt: Date
){
    constructor(): this(0,"","",Date())
    constructor(title: String, content : String):this(
        0,
        title,
        content,
        Date()

    )
    constructor(title: String, content : String, createdAt: Date):this(
        0,
        title,
        content,
        createdAt

    )
}