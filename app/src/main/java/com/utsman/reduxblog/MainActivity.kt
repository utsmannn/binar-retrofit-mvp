package com.utsman.reduxblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.utsman.reduxblog.presenter.MainPresenter
import com.utsman.reduxblog.presenter.MainPresenterImpl
import com.utsman.reduxblog.view.MainView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), MainView {

    companion object {
        private const val TAG = "binar..."
    }

    private val mainPresenter: MainPresenter by lazy {
        MainPresenterImpl(this)
    }

    private val btnGetPosts: Button by lazy { findViewById(R.id.btn_get_posts) }
    private val btnGetPost: Button by lazy { findViewById(R.id.btn_get_post) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetPosts.setOnClickListener {
            mainPresenter.getPosts()
        }

        btnGetPost.setOnClickListener {
            mainPresenter.getPost(329221)
        }

    }

    override fun onItemListLoaded(items: List<Item>) {
        Log.d(TAG, "onItemListLoaded: $items")
    }

    override fun onItemLoaded(item: Item) {
        Log.d(TAG, "onItemLoaded: $item")
    }

    override fun onError(throwable: Throwable) {
        Log.e(TAG, "onError: ${throwable.localizedMessage}")
    }
}