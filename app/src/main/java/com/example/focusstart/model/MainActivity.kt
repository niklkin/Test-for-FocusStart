package com.example.focusstart.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.focusstart.API
import com.example.focusstart.R
import com.example.focusstart.RetrofitHelper
import com.example.focusstart.view.QAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var textInput: EditText
    lateinit var btn: Button
    lateinit var textViewInfo: TextView
    lateinit var rv: RecyclerView
    lateinit var qAdapter: QAdapter
    var qListItem = mutableListOf<Q>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInput = findViewById(R.id.editTextTextPersonName)
        btn = findViewById(R.id.enterBtn)
        textViewInfo = findViewById(R.id.textViewInfo)

//        rv = findViewById(R.id.rv)
//        rv.setHasFixedSize(true)
//        rv.layoutManager = LinearLayoutManager(this)
        //qAdapter = QAdapter(baseContext, responseBody)
        //qAdapter.notifyDataSetChanged()
        //rv.adapter = qAdapter


        btn.setOnClickListener {
            btnClick()

        }
    }

    fun getApiRequest(text: String) {
        val api = RetrofitHelper.getInstance().create(API::class.java)
        val call = api.getQuotes(text)
        //Log.d("thug", call.request().toString())
        call.enqueue(object : Callback<Q> {
            override fun onFailure(call: Call<Q>, t: Throwable) {
                Log.d("thug", "FAIL")


            }

            override fun onResponse(call: Call<Q>, response: Response<Q>) {
                Log.d("thug", response.body()!!.toString())

                qListItem.add(response.body()!!)
                Log.d("list count", qListItem.size.toString())
                qAdapter = QAdapter(qListItem)
                rv = findViewById(R.id.rv)
                rv.setHasFixedSize(true)
                rv.layoutManager = LinearLayoutManager(this@MainActivity)
                rv.adapter = qAdapter


            }
        })
    }

    fun btnClick() {
        val text = textInput.text.toString()
        getApiRequest(text)
    }

}


