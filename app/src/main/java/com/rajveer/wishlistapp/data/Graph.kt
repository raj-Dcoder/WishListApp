package com.rajveer.wishlistapp.data

import android.content.Context
import androidx.room.Room

object Graph {//Centralized Dependency Management
    //help not to create multiple objects of same class in different places
    lateinit var database: WishDatabase

    val wishRepository by lazy {// here wishRepository has given the value, but it is not initialized yet, it will when it will be called or needed
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){ //Object is created once and used everywhere
        database = Room.databaseBuilder(context,
            WishDatabase::class.java,
            "wishlist.db").build()
    }
}