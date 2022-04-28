package com.example.m4l8t3.fragment

import com.example.m4l8t3.R
import com.example.m4l8t3.model.Contact


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class ContactFragment : Fragment() {

    private lateinit var photo: ImageView
    private lateinit var name: TextView
    private lateinit var number: TextView

    private lateinit var call: ImageView
    private lateinit var sms: ImageView
    private lateinit var video: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    fun newInstance(contact: Contact): ContactFragment {
        val contactFragment = ContactFragment()
        val bundle = Bundle()
        bundle.putParcelable("contact", contact)
        contactFragment.arguments = bundle
        return contactFragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val person = arguments?.getParcelable<Contact>("contact")

        photo = view.findViewById(R.id.iv_person_photo)
        name = view.findViewById(R.id.tv_person_name)
        number = view.findViewById(R.id.tv_person_number)

        photo.setImageResource(person!!.photo)
        name.text = person.name
        number.text = person.number

        call = view.findViewById(R.id.person_call)
        sms = view.findViewById(R.id.person_sms)
        video = view.findViewById(R.id.person_video)

        call.setOnClickListener {
            callToNumber(number.text.toString())
        }

        sms.setOnClickListener {
            sendSMS(
                number.text.toString()
            )
        }

        video.setOnClickListener {
            Toast.makeText(requireContext(), "We don't support Video Call yet\nIt is coming", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendSMS(number: String) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("sms", number, null))
        startActivity(intent)
    }

    private fun callToNumber(number: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$number")
        startActivity(intent)
    }

}