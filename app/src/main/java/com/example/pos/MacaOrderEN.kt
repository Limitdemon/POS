package com.example.pos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MacaOrderEN(private val ListMacarons: List<Macaronproduct>) : RecyclerView.Adapter<MacaOrderEN.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val macaronView = inflater.inflate(R.layout.macar_order, parent, false)

        return ViewHolder(macaronView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val macaron: Macaronproduct = ListMacarons[position]

        val id = holder.productIDView
        val name = holder.productNameView
        val num = holder.productNumView
        val price = holder.productPriceView

        name.setText(macaron.name)
        price.setText(macaron.price.toString())
        id.setText(macaron.id.toString())
        num.setText(macaron.num.toString())

    }

    //return the number of the items in the list
    override fun getItemCount(): Int {
        return ListMacarons.size
    }

    inner class ViewHolder(ItemView: View) :
        RecyclerView.ViewHolder(ItemView) {
        val productNameView: TextView = ItemView.findViewById(R.id.Name)
        val productPriceView: TextView = ItemView.findViewById(R.id.Price)
        val productIDView: TextView = ItemView.findViewById(R.id.ID)
        val productNumView: TextView = ItemView.findViewById(R.id.Number)
    }
}