package com.example.pos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pos.R

class MacaronEn(private val ListMacarons: List<Macaronproduct>, private val onItemClicked: (Macaronproduct) -> Unit) : RecyclerView.Adapter<MacaronEn.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val macaronView = inflater.inflate(R.layout.all_item, parent, false)

        return ViewHolder(macaronView) {
            onItemClicked(ListMacarons[it])
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val macaron: Macaronproduct = ListMacarons[position]
        val image = holder.productImageView
        val name = holder.productNameView
        val price = holder.productPriceView

        when (position) {
            0 -> image.setImageResource(R.drawable.rose_lychee_macaron)
            1 -> image.setImageResource(R.drawable.macha_macarons)
            2 -> image.setImageResource(R.drawable.blue_macaron)
            3 -> image.setImageResource(R.drawable.chocolate_mint_macarons)
            4 -> image.setImageResource(R.drawable.chocolate_macarons)

            else -> {
                image.setImageResource(R.drawable.rose_lychee_macaron)
            }
        }

        name.setText(macaron.name)
        price.setText(macaron.price.toString())
    }

    //return the number of the items in the list
    override fun getItemCount(): Int {
        return ListMacarons.size
    }

    inner class ViewHolder(ItemView: View, onItemClickedfun: (Int) -> Unit) :
        RecyclerView.ViewHolder(ItemView) {
        val productImageView: ImageView = ItemView.findViewById(R.id.product_img)
        val productNameView: TextView = ItemView.findViewById(R.id.name_of_product)
        val productPriceView: TextView = ItemView.findViewById(R.id.price_of_product)
        val addbtnproduct: Button = ItemView.findViewById(R.id.btn_add)
        val deletebtnproduct: Button = ItemView.findViewById(R.id.btn_delete)
        init {
            ItemView.setOnClickListener {
                onItemClickedfun(adapterPosition)
            }
            addbtnproduct.setOnClickListener {
                onItemClickedfun(adapterPosition)
                MacaronActivity.addorsub = false
            }
            deletebtnproduct.setOnClickListener {
                onItemClickedfun(adapterPosition)
                MacaronActivity.addorsub = true
            }
        }
    }
}