package com.example.androidnotesapp

import java.util.UUID

/*
*This code defines a special kind of note with three important pieces of information.
*Each note has a unique ID, title and Text
*/
data class Note(
    val id: String = UUID.randomUUID().toString(),
    var title: String,
    var text: String,
)