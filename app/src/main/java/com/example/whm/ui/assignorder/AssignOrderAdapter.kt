package com.example.whm.ui.assignorder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.com.example.whm.ui.assignorder.OrderModel


internal class AssignOrderAdapter(private var orderList: List<OrderModel>,var activity: Context?) :
    RecyclerView.Adapter<AssignOrderAdapter.MyViewHolder>() {




    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var CustomerName: TextView = view.findViewById(R.id.txtCustName)
        var OrderNo: TextView = view.findViewById(R.id.txtOrderNo)
        var OrderDate: TextView = view.findViewById(R.id.txtOrderDate)
        var SalesPerson: TextView = view.findViewById(R.id.txtSalesPerson)
        var PackedBoxes: TextView = view.findViewById(R.id.txtPackedBoxes)
        var PayableAmount: TextView = view.findViewById(R.id.txtPaybleAmount)
        var Stoppage: TextView = view.findViewById(R.id.txtStoppage)
        var ST: TextView = view.findViewById(R.id.txtStatus)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val order = orderList[position]
        holder.CustomerName.text = order.getCustomerName()
        holder.OrderNo.text = order.getOno()
        holder.OrderDate.text = order.getOd()
        holder.SalesPerson.text = order.getSP()
        holder.PackedBoxes.text = order.getPackedBoxes()
        holder.PayableAmount.text = "$"+order.getPayableAmount()
        holder.Stoppage.text = order.getStoppage()
        holder.ST.text = order.getST()
        (activity as? AppCompatActivity)?.setSupportActionBar(holder.toolbar)
        (activity as? AppCompatActivity)?.supportActionBar?.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Unload Orders"+" ["+orderList.size.toString()+"]"
    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}

private fun AppCompatActivity?.setSupportActionBar(toolbar: Toolbar?) {

}
