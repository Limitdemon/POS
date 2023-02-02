package com.example.pos

import android.content.Context
import androidx.room. *
@Database ( entities = [ Order::class ,OrderLine::class],version=1 )
abstract class POSAppDatabase : RoomDatabase( ) {
    abstract fun orderDao(): OrderDao
    abstract fun orderLineDao(): OrderLineDao

    companion object {
        private var INSTANCE: POSAppDatabase? = null
        fun getInstance(context: Context): POSAppDatabase {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    POSAppDatabase::class.java,
                    "pos_app.db"
                )
                    .build()
            }
            return INSTANCE as POSAppDatabase
        }
    }
}

