package com.apkdoandroid.fakestorecomteste.data.dto

data class Rating(
    val count: Int,
    val rate: Double
){
    constructor() : this(
        count = 0,
        rate = 0.0
    )
}