package com.example.task10

data class Option(
    val title: String,
    val type: Type,
    val icon: Int
)

enum class Type{
    NORMAL,
    LANGUAGE,
    DARK_MODE,
    EXIT
}
