package com.techsultan.contactappzuritask.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import com.techsultan.contactappzuritask.R
import com.techsultan.contactappzuritask.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpData(binding)
    }


    private fun setUpData(binding: ActivityContactBinding){

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar.title = intent.getStringExtra("CATEGORY")

        binding.contactRv.adapter = adapter
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_contact_dialog, null)
        builder.setView(view)

        val name = view.findViewById<TextView>(R.id.nameEt)
        val number = view.findViewById<TextView>(R.id.numberEt)
        val saveBtn = view.findViewById<TextView>(R.id.saveBtn)

        //Text changed listener allows you to monitor changes while typing  in ad edit text

        number.addTextChangedListener(object:TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveBtn.isEnabled = s?.length == 11
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )

        val alertDialog = builder.create()

        saveBtn.setOnClickListener {

            val contact = ContactModel(name.text.toString(), number.text.toString())
            val contactList = mutableListOf(contact)
            adapter.setDataList(contactList)
            alertDialog.dismiss()

        }



        binding.fabBtn.setOnClickListener {
            alertDialog.show();
        }
    }
}