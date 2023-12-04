package com.apkdoandroid.fakestorecomteste.domain.model

import com.apkdoandroid.fakestorecomteste.data.dto.Rating

data class Produto(

    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
) {

    constructor(id: Int,title: String) : this(id = id, title = title,category = "",description = "", image = "", price = 10.0){}
    override fun toString(): String {
        return "Produto(category='$category', description='$description', id=$id, image='$image', price=$price, title='$title')"
    }
}