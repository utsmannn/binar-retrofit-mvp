package com.utsman.reduxblog.view

import com.utsman.reduxblog.Item

interface MainView {
    fun onItemListLoaded(items: List<Item>)
    fun onItemLoaded(item: Item)
    fun onError(throwable: Throwable)
}