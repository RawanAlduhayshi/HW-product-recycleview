package com.example.hw_product_recycleview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_product_recycleview.PhoneListFragmentDirections
import com.example.hw_product_recycleview.R
import com.example.hw_product_recycleview.data.DataSource


class ProductAdapter(private val context: Context?) : RecyclerView.Adapter
<ProductAdapter.ProductViewHolder>() {
    private val dataset = DataSource.ProductPhone

    class ProductViewHolder(val view: View?) :
        RecyclerView.ViewHolder(view!!) {
        var productImage: ImageView? = view?.findViewById(R.id.product_image)
        val Phonename: TextView? = view?.findViewById(R.id.product_name)
        val Phoneprice: TextView? = view?.findViewById(R.id.product_price)
        val PhonestarImage: ImageView? = view?.findViewById(R.id.star_image)
        val Phonebutton: Button? = view?.findViewById(R.id.button)

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate
                (R.layout.product_item, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        val item = dataset[position]
        holder.productImage?.setImageResource(item.productImage)

        holder.Phonename?.text = context?.getString(item.productName)
        holder.Phoneprice?.text = item.productPrice
        if (item.isVip) {
            holder.PhonestarImage?.visibility = View.VISIBLE
        }
        holder.Phonebutton?.setOnClickListener {
            if (item.productQuantity < 0) {
                Toast.makeText(context, "The item is out of stock", Toast.LENGTH_SHORT).show()
            } else {
                if (item.productQuantity > 0) {
                    val action =
                        PhoneListFragmentDirections.actionPhoneListFragmentToPhoneNameFragment(
                            name = context?.getString(item.productName)!!,
                            price = item.productPrice
                        )
                    holder.view?.findNavController()?.navigate(action)
                }
            }


        }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}














