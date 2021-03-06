package com.lakshmi.myshoppingapp.Activities.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Products::class], version = 2, exportSchema = false)
abstract class ProductDatabase:RoomDatabase() {
    abstract val productDao:ProductDao
    companion object {

        private var INSTANCE:ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, ProductDatabase::class.java, "pro_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}