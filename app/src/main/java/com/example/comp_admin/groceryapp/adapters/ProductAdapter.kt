package com.example.comp_admin.groceryapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.comp_admin.groceryapp.R
import com.example.comp_admin.groceryapp.activities.SubCategoryActivity
import com.example.comp_admin.groceryapp.models.Category
import com.example.comp_admin.groceryapp.models.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_products.view.*
import kotlinx.android.synthetic.main.rv_sub_categories.view.*

class ProductAdapter(
    private var mContext: Context,
    private var mList: ArrayList<Product>
) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.rv_sub_categories, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList.get(position))
    }

    fun setData(list: ArrayList<Product>) {
        mList = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            itemView.product_name.text = product.productName
            Picasso.with(mContext)
                .load("http://rjtmobile.com/grocery/images/" + product.productImage)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.my_product_image)
            /*itemView.setOnClickListener {
                var intent = Intent(mContext, SubCategoryActivity::class.java)
                intent.putExtra(Category.KEY_CATEGORY, category)
                mContext.startActivity(intent)
                //  Toast.makeText(mContext, category.catName, Toast.LENGTH_SHORT).show()
                }*/
            }

        }
    }

