package com.rajveer.wishlistapp

import android.app.Application
import com.rajveer.wishlistapp.data.Graph

class WishListApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }

}