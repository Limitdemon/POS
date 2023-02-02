package com.example.pos

import androidx.room.*
    @Entity (tableName = "orderTbl")

    data class Order (
        @PrimaryKey(autoGenerate = true) val uid : Long?,
        @ColumnInfo(name = "branch_id") val branchID : Long,
        @ColumnInfo(name = "staff_id") val staffID : Long,
    )
