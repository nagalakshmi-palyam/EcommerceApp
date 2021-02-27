package com.lakshmi.myshoppingapp.Activities.SignUpandLoginDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lakshmi.myshoppingapp.Activities.Database.ProductDao
import com.lakshmi.myshoppingapp.Activities.Database.ProductDatabase

@Database(entities = [UserDetails::class],version = 1,exportSchema = false)
abstract class DetailsDatabase: RoomDatabase(){
    abstract val detailsDao:DetailsDao
    companion object {

        private var INSTANCE: DetailsDatabase? = null

        fun getInstance(context: Context): DetailsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, DetailsDatabase::class.java, "details_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}