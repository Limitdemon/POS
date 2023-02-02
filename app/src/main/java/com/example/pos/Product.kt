package com.example.pos

import androidx.room.*

@Entity ( tableName = "productTbl")
 data class ProductDB (
@PrimaryKey ( autoGenerate = true ) var uid : Long?,
@ColumnInfo ( name = "name") var name : String,
@ColumnInfo ( name = "price") var price : Int,
)