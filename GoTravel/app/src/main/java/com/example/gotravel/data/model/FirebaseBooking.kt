package com.example.gotravel.data.model

class FirebaseBooking {
    var idBooking: String? = null
    var idTarget: String? = null
    var idUser: String? = null
    var startDay: Long = 0
    var endDay: Long = 0
    var price: Int = 0
    var numOfRooms: Int = 0

    constructor()

    constructor(
        idBooking: String?,
        idTarget: String?,
        idUser: String?,
        startDay: Long,
        endDay: Long,
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