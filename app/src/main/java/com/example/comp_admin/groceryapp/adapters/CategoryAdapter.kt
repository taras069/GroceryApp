package com.example.comp_admin.groceryapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.comp_admin.groceryapp.R
import com.example.comp_admin.groceryapp.activities.SubCategoryActivity
import com.example.comp_admin.groceryapp.models.Category
import kotlinx.android.synthetic.main.rv_categories.view.*

class CategoryAdapter(
    private var mContext: Context,
    private var mList: ArrayList<Category>
) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.rv_categories, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList.get(position))
    }

    fun setData(list: ArrayList<Category>) {
        mList = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            itemView.cat_name.text = category.catName
            itemView.setOnClickListener {
                var intent = Intent(mContext, SubCategoryActivity::class.java)
                intent.putExtra("id", category.catId)
                mContext.startActivity(intent)
              //  Toast.makeText(mContext, category.catName, Toast.LENGTH_SHORT).show()
            }

        }
    }

}