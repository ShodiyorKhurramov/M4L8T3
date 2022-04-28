package com.example.m4l8t3.listener

import com.example.m4l8t3.model.Contact


interface SendContactListener {
    fun onSendContact(contact: Contact)
}