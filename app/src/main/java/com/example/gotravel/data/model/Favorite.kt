package com.example.gotravel.data.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Favorite : RealmObject {
    @PrimaryKey
    var idFavorite: String? = null
    var idTarget: String? = null
    var idUser: String? = null

    var type: String? = null

    constructor(idFavorite: String?, idTarget: String?, idUser: String?, type: String?) {
        this.idFavorite = idFavorite
        this.idTarget = idTarget
        this.idUser = idUser
        this.type = type
    }

    constructor(idFavorite: String?, idTarget: String?) {
        this.idFavorite = idFavorite
        this.idTarget = idTarget
    }

    constructor()
}
