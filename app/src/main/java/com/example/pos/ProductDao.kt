package com.example.pos

import androidx.room. *
@Dao
interface ProductDao {
    @Query ("SELECT * FROM productTbl")
    fun getAll() : List<ProductDB>
    @Query ("SELECT * FROM productTbl WHERE uid = :id")
    fun loadAllByIds ( id : IntArray ) : List<ProductDB>
    @Query ("SELECT * FROM productTbl WHERE uid LIKE :id LIMIT 1")
    fun findByID ( id : Long ) : ProductDB
    @Insert
    fun insertAll ( vararg products : ProductDB )
    @Delete
    fun delete ( product : ProductDB )
}