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
    val qList: List<Q>
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
        holder.schemeNetwork.text = "Scheme: \n ${qList[position].scheme.toString()}"
        holder.type.text = "Type:\n${qList[position].type.toString()}"
        holder.bank.text = """Bank:
            |${qList[position].bank.name}
            |${qList[position].bank.city}
            |${qList[position].bank.phone}
            |${qList[position].bank.url}
        """.trimMargin()
        holder.brand.text = "Brand:\n${qList[position].brand.toString()}"
        holder.prepaid.text = "Prepaid:\n${qList[position].prepaid.toString()}"
        holder.cardNumber.text = """cardNumber:
            |${qList[position].number.length}
            |Luhn: ${if(qList[position].number.luhn) "Yes" else "No"}
            |""".trimMargin()
        holder.country.text = """Country:
        |${qList[position].country.alpha2} ${qList[position].country.name}
        |Latitude:${qList[position].country.latitude} 
        |Longitude: ${qList[position].country.longitude}
        """.trimMargin()

    }

    override fun getItemCount(): Int {
        return qList.size
    }
}


