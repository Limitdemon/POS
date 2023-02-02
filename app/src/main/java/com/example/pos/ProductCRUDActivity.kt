package com.example.pos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.pos.R
import com.example.pos.databinding.ActivityProductCrudactivityBinding


class ProductCRUDActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductCrudactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductCrudactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<ProductFragment>(R.id.product_list_fragmentContainerView)
        }

        val view: FragmentContainerView? = binding.root.findViewById(R.id.show_product_fragmentContainerView)

        if (view != null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ShowProductFragment>(R.id.show_product_fragmentContainerView)
            }
        }
    }
}

