package com.example.gotravel.data.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class City : RealmObject {
    @PrimaryKey
    var idCity: String? = null
    var name: String? = null
    var image: String? = null

    constructor(idCity: String?, name: String?, image: String?) {
        this.idCity = idCity
        this.name = name
        this.image = image
    }

    constructor(idCity: String?, name: String?) {
        this.idCity = idCity
        this.name = name
    }

    constructor()
}
