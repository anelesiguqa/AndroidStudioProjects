package com.example.userregistrationapp

import java.io.Serializable

data class User(val title: String, val firstName: String,
                val lastName: String, val email: String,
                val number: String) : Serializable