package com.example.pos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pos.R
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.provider.ContactsContract
import android.widget.SearchView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.*
import kotlin.collections.ArrayList

class Contact : AppCompatActivity() {

    var reContact: RecyclerView? = null
    val ContactList: ArrayList<ContactCon> = ArrayList<ContactCon>()
    val searchList: ArrayList<ContactCon> = ArrayList<ContactCon>()
    var adapter: ContactEn? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        checkPermission()
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this@Contact, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@Contact, arrayOf(Manifest.permission.READ_CONTACTS), 100)
        } else {
            PP()
        }
    }

    private fun PP() {
        CS()

        reContact = findViewById(R.id.reContact)
        reContact!!.layoutManager = LinearLayoutManager(this)

        adapter = ContactEn(searchList)
        reContact!!.adapter = adapter

        searchbar()
    }

    @SuppressLint("Range")
    private fun CS() {
        val uri = ContactsContract.Contacts.CONTENT_URI
        val sort = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        val cursor = contentResolver.query(uri, null, null, null, sort)

        if (cursor!!.count > 0) {

            while (cursor.moveToNext()) {
                val contactID = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val uriPhone = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                val selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?"
                val cursorPhone = contentResolver.query(uriPhone, null, selection, arrayOf(contactID), null)

                if (cursorPhone!!.moveToNext()) {
                    val contactPhone = cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    val contact = ContactCon()

                    contact.setName(contactName)
                    contact.setPhone(contactPhone)

                    ContactList.add(contact)
                    searchList.add(contact)

                    cursorPhone.close()
                }
            }
            cursor.close()
        }
    }

    private fun searchbar() {
        val search = findViewById(R.id.searchView) as SearchView

        search.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            @RequiresApi(Build.VERSION_CODES.N)
            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()

//                val searchText = newText!!.toLowerCase(Locale.getDefault())

//                if (searchText.isNotEmpty()) {
//
//                    ContactList.forEach {
//
//                        if (it.getName()?.toLowerCase(Locale.getDefault())?.contains(searchText) == true || it.getPhone()?.toLowerCase(Locale.getDefault())?.contains(searchText) == true) {
//                            searchList.add(it)
//                        }
//                    }
//                    reContact!!.adapter?.notifyDataSetChanged()
//                } else {
//                    searchList.clear()
//                    searchList.addAll(ContactList)
//
//                    reContact!!.adapter?.notifyDataSetChanged()
//                }
                return false
            }
        })
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 100 && grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            PP()
        } else {
            Toast.makeText(this@Contact, "Permission is Denied", Toast.LENGTH_SHORT).show()
            checkPermission()
        }
    }
}