package com.techsultan.contactappzuritask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techsultan.contactappzuritask.contact.ContactActivity
import com.techsultan.contactappzuritask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CategoryAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private var dataList = mutableListOf<CategoryModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.categoryRv
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        categoryAdapter = CategoryAdapter(this@MainActivity)

        recyclerView.adapter = categoryAdapter


        dataList.add(CategoryModel("Family"))
        dataList.add(CategoryModel("Friends"))
        dataList.add(CategoryModel("Workers"))
        dataList.add(CategoryModel("Emergency Nos"))


        categoryAdapter.setDataList(dataList)



    }

    override fun onItemClick(position: Int) {
        //Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ContactActivity::class.java)

        //put items(category) model with put extra
        startActivity(intent)
    }


}