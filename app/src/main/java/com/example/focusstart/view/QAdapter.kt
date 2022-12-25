package com.example.focusstart.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.focusstart.R
import com.example.focusstart.model.Q

class QAdapter(
    val q: Q
) : RecyclerView.Adapter<QAdapter.QViewHolder>() {

    private lateinit var qListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        qListener = listener
    }

    class QViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val schemeNetwork = view.findViewById<TextView>(R.id.scheme_network)
        val type = view.findViewById<TextView>(R.id.type)

        val bank = view.findViewById<TextView>(R.id.bank)
        val brand = view.findViewById<TextView>(R.id.brand)

        val prepaid = view.findViewById<TextView>(R.id.prepaid)
        val cardNumber = view.findViewById<TextView>(R.id.card_number)

        val country = view.findViewById<TextView>(R.id.country)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.bank_user_item, parent, false)
        return QViewHolder(v)
//        return QViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.bank_user_item, parent, false)
    }

    override fun onBindViewHolder(holder: QViewHolder, position: Int) {
        holder.schemeNetwork.text = "Scheme: \n ${q.scheme.toString()}"
        holder.type.text = "Type:\n${q.type.toString()}"
        holder.bank.text = "Bank:\n${q.bank.toString()}"
        holder.brand.text = "Brand:\n${q.brand.toString()}"
        holder.prepaid.text = "Prepaid:\n${q.prepaid.toString()}"
        holder.cardNumber.text = "cardNumber:\n${q.number.toString()}"
        holder.country.text = """Country:
            $|${q.country.alpha2} ${q.country.name}
            |Latitude:${q.country.latitude} Longitude: ${q.country.longitude}
            """.trimMargin()

    }

    override fun getItemCount(): Int = 1
}


