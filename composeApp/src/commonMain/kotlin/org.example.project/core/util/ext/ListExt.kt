package org.example.project.core.util.ext

fun <T> List<T>.isLast(index: Int): Boolean {
    if (isEmpty()) return false

    return size - (index + 1) <= 0
}