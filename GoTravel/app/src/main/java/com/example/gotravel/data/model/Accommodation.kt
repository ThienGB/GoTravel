package com.example.gotravel.data.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class Accommodation : RealmObject {
    @PrimaryKey
    var accommodationId: String? = null
    var name: String? = null
    var price: Int = 0
    var freeroom: Int = 0
    var currentFreeroom: Int = 0
    var image: String? = null
    var description: String? = null
    var address: String? = null
    var longitude: String? = null
    var latitude: String? = null
    var cityId: String? = null


    constructor(
        accommodationId: String?,
        name: String?,
        price: Int,
        freeroom: Int,
        image: String?,
        description: String?,
        address: String?,
        longitude: String?,
        latitude: String?,
        cityId: String?
    ) {
        this.accommodationId = accommodationId
        this.name = name
        this.price = price
        this.freeroom = freeroom
        this.image = image
        this.description = description
        this.address = address
        this.longitude = longitude
        this.latitude = latitude
        this.cityId = cityId
    }

    constructor(accommodationId: String?, name: String?, price: Int, cityId: String?) {
        this.accommodationId = accommodationId
        this.name = name
        this.price = price
        this.cityId = cityId
    }

    constructor(accommodationId: String?, name: String?, price: Int) {
        this.accommodationId = accommodationId
        this.name = name
        this.price = price
    }

    constructor()
}
