package com.example.comp_admin.groceryapp.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.comp_admin.groceryapp.R
import com.example.comp_admin.groceryapp.helpers.DBHelper
import com.example.comp_admin.groceryapp.models.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_cart.view.*


class CartAdapter(
    var mContext: Context,
    var mList: ArrayList<Product>
) : RecyclerView.Adapter<CartAdapter.MyViewHolder>() {
    var myDB = DBHelper(mContext)
    var listener : myCustomInterface? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.rv_cart, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var i = mList.get(position)
        holder.bind(i, position)
    }

    interface myCustomInterface {
        fun onItemClicked(position: Int, view: View)
    }

    fun setMyCustomInterface(myVar: myCustomInterface) {
        listener = myVar
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product, position: Int) {
            itemView.cart_name.text = product.productName
            itemView.cart__price.text = product.price
            itemView.cart_quantity.text = product.quantity.toString()

            itemView.button_minus.setOnClickListener {
                listener?.onItemClicked(position,it)
               /* product.quantity--
                itemView.cart_quantity.text = product.quantity.toString()
                myDB.updateQuantity(product)
                notifyItemChanged(position)*/
            }
            itemView.button_plus.setOnClickListener {
                listener?.onItemClicked(position,it)
               /* product.quantity++
                itemView.cart_quantity.text = product.quantity.toString()
                myDB.updateQuantity(product)
                notifyItemChanged(position)*/
            }
            itemView.icon_delete.setOnClickListener {

                listener?.onItemClicked(position,it)


            }


            Picasso.get()
                .load("http://rjtmobile.com/grocery/images/" + product.productImage)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.my_cart_image)

        }
    }
}
