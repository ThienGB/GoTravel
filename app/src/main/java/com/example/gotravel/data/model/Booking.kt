package com.example.gotravel.data.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.Date

class Booking : RealmObject {
    @PrimaryKey
    var idBooking: String? = null
    var idTarget: String? = null
    var idUser: String? = null
    var startDay: Date? = null
    var endDay: Date? = null
    var price: Int = 0
    var numOfRooms: Int = 0

    constructor()

    constructor(
        idBooking: String?,
        idTarget: String?,
        idUser: String?,
        startDay: Date?,
        endDay: Date?,
        price: Int,
        numOfRooms: Int
    ) {
        this.idBooking = idBooking
        this.idTarget = idTarget
        this.idUser = idUser
        this.startDay = startDay
        this.endDay = endDay
        this.price = price
        this.numOfRooms = numOfRooms
    }
}
