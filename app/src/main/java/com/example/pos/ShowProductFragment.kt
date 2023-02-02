package com.example.pos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShowProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowProductFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_show_product, container, false)
        val macaronID = arguments?.getInt("macaron_id_int")?: 1001
        val macaron = Macaronproduct.MacaronList()

        val macaronNameTV = rootView.findViewById(R.id.textfrang) as TextView
        macaronNameTV.text = macaron[macaronID - 1001].name


        val macaronImg = rootView.findViewById(R.id.imagefrag) as ImageView

        when (macaronID) {
            1001 -> macaronImg.setImageResource(R.drawable.rose_lychee_macaron)
            1002 -> macaronImg.setImageResource(R.drawable.macha_macarons)
            1003 -> macaronImg.setImageResource(R.drawable.blue_macaron)
            1004 -> macaronImg.setImageResource(R.drawable.chocolate_mint_macarons)
            1005 -> macaronImg.setImageResource(R.drawable.chocolate_macarons)
            else -> {
                macaronImg.setImageResource(R.drawable.rose_lychee_macaron)
            }
        }
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShowProductFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShowProductFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}