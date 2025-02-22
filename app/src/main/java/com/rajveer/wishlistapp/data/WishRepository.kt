package com.rajveer.wishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {
    suspend fun addAWish(wish: Wish){
        wishDao.addAWish(wish)
    }
    fun getAWishById(id: Long): Flow<Wish> = wishDao.getAWishById(id)

    fun getAllWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    suspend fun updateAWish(wish: Wish){
        wishDao.updateAWish(wish)
    }

    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteAWish(wish)
    }
}