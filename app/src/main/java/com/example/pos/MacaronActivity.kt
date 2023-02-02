package com.example.pos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MacaronActivity : AppCompatActivity() {

    private var macaList = ArrayList<Macaronproduct>()

    companion object {
        var addorsub: Boolean? = null
    }

    fun onclicksubmitorderbtn ( view : View) {
        Log.i ("MacronActivity", "Submit order button clicked. Order is going to be stored.")

        GlobalScope.launch {

            val order1 = Order (null, 5001, 2001 )

            val db = POSAppDatabase . getInstance ( applicationContext )
            val orderID : Long = db.orderDao().insert(order1 )

        }
    }

    fun onclickretrieveordersbtn ( view : View ) {
        Log.i("MacaronActivity", "Retrieve Orders button clicked.")
        GlobalScope.launch {
// Get a reference to database
            val db = POSAppDatabase.getInstance(applicationContext)
            val orders = db.orderDao().getAll()
            Log.i ("MacaronActivity\"", "Orders:")
            for (order in orders) {
                Log.i ("MacaronActivity", "Order ID = ${order.uid}, " +
                        "Branch ID = ${order.branchID} " +
                        "Staff ID = ${order.staffID}")
            }
            Log.i("MacaronActivity", "orderLines:")
            val orderLines = db.orderLineDao().getAll()
            for (orderLine in orderLines) {
                Log . i ("MacaronActivity", "orderLine ID = ${orderLine.uid}, " +
                        "Order ID = ${orderLine.orderID} " +
                        "Product ID = ${orderLine.productID}")
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_macaron)

        val intent = intent
        val catID = intent.getIntExtra("CatID", 0)

        when (catID) {

            MACARON_CONNNID -> {

                val rvMacaron = findViewById(R.id.Recyclelist) as RecyclerView
                val rvorMacaron = findViewById(R.id.recycletotal) as RecyclerView

                rvMacaron.layoutManager = LinearLayoutManager(this)
                rvorMacaron.layoutManager = LinearLayoutManager(this)

                val macaron = Macaronproduct.MacaronList()

                val adapter2 = MacaOrderEN(macaList)
                rvorMacaron.adapter = adapter2

                val adapter = MacaronEn(macaron) { macaron ->

                    if (addorsub == false) {

                        if (!macaList.contains(macaron)) {
                            macaList.add(macaron)
                            adapter2.notifyItemChanged(macaList.size)
                        } else if (macaList.contains(macaron)) {
                            val index = macaList.indexOf(macaron)
                            macaron.num += 1
                            macaron.price = macaron.price * macaron.num
                            macaList.set(index, macaron)
                            adapter2.notifyItemChanged(index)
                        }
                    }
                }
                rvMacaron.adapter = adapter


                Toast.makeText(this, "Macaron Category", Toast.LENGTH_SHORT)
            }
        }
    }
}