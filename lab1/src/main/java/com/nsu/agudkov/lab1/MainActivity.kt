package com.nsu.agudkov.lab1

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException
import java.io.StringReader
import java.lang.reflect.Array
import java.lang.reflect.InvocationTargetException


class MainActivity : ComponentActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView: ListView = findViewById(R.id.list_view)
        val spinner: Spinner = findViewById(R.id.spinner)
        var text: TextView = findViewById(R.id.rub)
        val button: Button = findViewById(R.id.button)
        var curr: TextView = findViewById(R.id.currency)

        val policy = ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)

        var client: OkHttpClient = OkHttpClient()
        var request: Request =
            Request.Builder().url("https://www.cbr-xml-daily.ru/daily_json.js").build()

        var responseBody: ResponseBody?
        var currencyConverter: CurrencyConverter? = null
        var gson: Gson = Gson()

        var response: Response = client.newCall(request = request).execute()
        responseBody = response.body
//        client.newCall(request).enqueue(object : Callback
//            override fun onFailure(call: Call, e: IOException) {
//                e.printStackTrace()
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                response.use {
//                    if (!response.isSuccessful) {
//                        throw IOException("Запрос к серверу не был успешен:" +
//                                " ${response.code} ${response.message}")
//                    }
////                    runOnUiThread {
////                    }
//                }
//            }
//        })

        currencyConverter =
            gson.fromJson(response.body!!.string(), CurrencyConverter::class.java)


        var arr: kotlin.Array<String> = emptyArray()
        for (item in currencyConverter!!.valute) {
            arr = arr.plus("${item.value.nominal} ${item.value.name} = ${item.value.value} рублей")
        }

        var arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this@MainActivity, R.layout.item_list_view, R.id.text, arr)
        listView.adapter = arrayAdapter

        var arrr: kotlin.Array<String> = emptyArray()
        for (item in currencyConverter!!.valute.values) {
            arrr = arrr.plus(item.name)
        }
        var spinnerAdapter: ArrayAdapter<String> =
            ArrayAdapter(this@MainActivity, R.layout.spinner, R.id.spinner_text, arrr)
        spinner.adapter = spinnerAdapter


        button.setOnClickListener {
            var curr_sum: Double = 0.0;

            for (item in currencyConverter!!.valute.values) {
                if (item.name == spinner.selectedItem) {
                    try {
                        curr_sum = item.value / (item.nominal * 1.0) * text.text.toString().toDouble()
                        curr.text = curr_sum.toString()
                        curr_sum = 0.0
                    } catch (e: NumberFormatException) {
                        Log.e("1", "NaN")
                    }
                }
            }
        }
    }
}