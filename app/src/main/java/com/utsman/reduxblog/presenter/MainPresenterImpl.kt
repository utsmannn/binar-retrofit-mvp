package com.utsman.reduxblog.presenter

import com.utsman.reduxblog.Item
import com.utsman.reduxblog.WebService
import com.utsman.reduxblog.view.MainView
import kotlinx.coroutines.runBlocking

class MainPresenterImpl(private val mainView: MainView) : MainPresenter {

    private val webService: WebService = WebService.retrofit()

    override fun getPosts() = runBlocking {
        val data = webService.getPosts()
        mainView.onItemListLoaded(data)
    }

    override fun getPost(id: Long) = runBlocking{
        val data = webService.getPost(id)
        mainView.onItemLoaded(data)
    }

    override fun addPost(item: Item) = runBlocking {
        val data = webService.addPost(item)
        mainView.onItemLoaded(data)
    }

    override fun deletePost(id: Long) = runBlocking {
        webService.deletePost(id)
    }


}