package com.example.comp_admin.groceryapp.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.example.comp_admin.groceryapp.R
import com.example.comp_admin.groceryapp.activities.adapterFragment
import com.example.comp_admin.groceryapp.adapters.ProductAdapter
import com.example.comp_admin.groceryapp.models.Product
import com.example.comp_admin.groceryapp.models.ProductResponse
import com.example.comp_admin.groceryapp.models.SubCategoryResponse
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_sub_category.*
import kotlinx.android.synthetic.main.fragment_product.view.*


private const val ARG_PARAM1 = "param1"

class ProductFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var subId: Int? = null

    lateinit var productAdapter: ProductAdapter
    var mList: ArrayList<Product> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            subId = it.getInt(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_product, container, false)
        view.my_fragment_product.text = subId.toString()
        init(view)
        return view

    }

    private fun init(view: View) {
        getData(subId)
        view.my_product_rv.layoutManager = LinearLayoutManager(activity)
        productAdapter = ProductAdapter(view.context, mList)
        view.my_product_rv.adapter = productAdapter

    }


    private fun getData(subId: Int?) {
        val url = "https://apolis-grocery.herokuapp.com/api/products/" + subId
        var requestQueue = Volley.newRequestQueue(activity)

        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener {
                var gson = GsonBuilder().create()
                var productResponse = gson.fromJson(
                    it.toString(), ProductResponse::class.java
                )
                mList = productResponse.data
                productAdapter.setData(mList)
            },
            Response.ErrorListener {
                Log.e("data", it.message)
            })

        requestQueue.add(stringRequest)
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: Int) =
            ProductFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)

                }
            }
    }
}
