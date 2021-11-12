package com.utsman.reduxblog.presenter

import com.utsman.reduxblog.Item

interface MainPresenter {
    fun getPosts()
    fun getPost(id: Long)
    fun addPost(item: Item)
    fun deletePost(id: Long)
}