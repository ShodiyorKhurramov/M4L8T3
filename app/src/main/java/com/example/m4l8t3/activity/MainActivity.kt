package com.example.m4l8t3.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import com.example.m4l8t3.R
import com.example.m4l8t3.fragment.ContactFragment
import com.example.m4l8t3.fragment.ListFragment
import com.example.m4l8t3.listener.SendContactListener
import com.example.m4l8t3.model.Contact


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = ListFragment().newInstance(getContacts() as ArrayList<Contact>)

        listFragment.clickListener(object : SendContactListener {
            override fun onSendContact(contact: Contact) {
                val contactFragment = ContactFragment().newInstance(contact)
                createContactFragment(contactFragment)
            }

        })

        createListFragment(listFragment)

    }

    private fun createListFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_list, fragment)
            .commit()
    }

    private fun createContactFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_contact, fragment)
            .commit()
    }

    fun getContacts(): List<Contact> {


        val contactList = ArrayList<Contact>()

        contactList.add(Contact("Shodiyor Xurramov", "+998 99 266 79 67", R.drawable.call))
        contactList.add(Contact("Shxzod Mirzayev", "+998 91 563 84 84", R.drawable.call))
        contactList.add(Contact("Abdulaziz Yusopov", "+998 93 544 44 33", R.drawable.call))
        contactList.add(Contact("Javlon Sobirov", "+998 90 512 25 81", R.drawable.call))
        contactList.add(Contact("PDP Academy", "+998 78 777 47 47", R.drawable.call))

        return contactList

    }

}