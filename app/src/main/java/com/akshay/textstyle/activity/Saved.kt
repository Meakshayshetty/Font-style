package com.akshay.textstyle.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.adapter.SavedAdapter
import com.akshay.textstyle.callback.DeleteCallback
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Saved : AppCompatActivity() ,DeleteCallback{
    private var recyclerview:RecyclerView?=null
    private lateinit var noSaved:TextView
    private var savedText:ArrayList<String> = arrayListOf()
    private var arraySaved:ArrayList<String> = arrayListOf()
    private lateinit var adapter :SavedAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved)
        recyclerview = findViewById(R.id.rv_saved)
        noSaved = findViewById(R.id.tvNoSaved)
        savedText = getSavedList()
        if (savedText.isNotEmpty()){
            noSaved.visibility =View.GONE
            adapter = SavedAdapter(savedText,this)
            recyclerview?.adapter = adapter
        }else{
            noSaved.visibility =View.VISIBLE
        }

        Log.e("SAVEDTEXTDATA",savedText.toString())
    }
    private fun getSavedList():ArrayList<String>{
        val gson = Gson()
        val sharedPreferences = getSharedPreferences("YourSharedPreferencesName", Context.MODE_PRIVATE)
        val json = sharedPreferences.getString("LIST",null)
        if(json != null){
            val type = object : TypeToken<ArrayList<String>>(){}.type//converting the json to list
            return gson.fromJson(json,type)//returning the list
        }
        return ArrayList()
    }
    private fun setSaveLists(list:ArrayList<String>){
        val sharedPreferences = getSharedPreferences("YourSharedPreferencesName", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(list)//converting list to Json
        editor.putString("LIST",json)
        editor.commit()
    }

    override fun deleted(text: String) {
        Toast.makeText(this,"Deleted",Toast.LENGTH_SHORT).show()
        arraySaved =getSavedList()
        arraySaved.remove(text)
        setSaveLists(arraySaved)
        adapter.updateData(arraySaved)
        adapter.notifyDataSetChanged()
        if (arraySaved.isNotEmpty()){
            noSaved.visibility =View.GONE
        }else{
            noSaved.visibility =View.VISIBLE
        }

    }
}