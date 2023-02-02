package com.example.pos

class ContactCon {
    var name: String? = null
    var phone: String? = null

    @JvmName("getName1")
    fun getName(): String? {
        return name
    }

    @JvmName("setName1")
    fun setName(name: String?) {
        this.name = name
    }

    @JvmName("getPhone1")
    fun getPhone(): String? {
        return phone
    }

    @JvmName("setPhone1")
    fun setPhone(phone: String?) {
        this.phone = phone
    }
}