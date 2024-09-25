package com.example.gotravel.data.local.dao

import RealmHelper
import com.example.gotravel.data.model.City
import com.example.gotravel.helper.CallbackHelper
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CityDaoImpl @Inject constructor(realmHelper: RealmHelper) {
    private val realm: Realm = realmHelper.realm

    fun addOrUpdateCity(city: City?) {
        if (city == null) return

        CoroutineScope(Dispatchers.IO).launch {
            realm.write {
                val existingCity = query<City>("idCity == $0", city.idCity).first().find()
                if (existingCity != null) {
                    // Cập nhật giá trị của đối tượng đã tồn tại
                    existingCity.apply {
                        name = city.name
                        image = city.image
                    }
                } else {
                    // Nếu chưa tồn tại, thêm đối tượng mới
                    copyToRealm(city)
                }
            }
        }
    }

    fun addOrUpdateListCity(cityResponses: List<City?>, callback: CallbackHelper?) {
        CoroutineScope(Dispatchers.IO).launch {
            realm.write {
                cityResponses.forEach { cityRes ->
                    cityRes?.let {
                        val city = City(it.idCity, it.name, it.image)
                        val existingCity = query<City>("idCity == $0", city.idCity).first().find()

                        if (existingCity != null) {
                            // Cập nhật đối tượng đã tồn tại
                            existingCity.apply {
                                name = city.name
                                image = city.image
                            }
                        } else {
                            // Thêm đối tượng mới
                            copyToRealm(city)
                        }
                    }
                }
            }
            callback?.onComplete()
        }
    }

    fun deleteCity(idCity: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            realm.write {
                val city = query<City>("idCity == $0", idCity).first().find()
                city?.let {
                    delete(it)
                }
            }
        }
    }

    fun deleteAllCity() {
        CoroutineScope(Dispatchers.IO).launch {
            realm.write {
                delete(City::class)
            }
        }
    }

    val cityList: RealmResults<City>
        get() = realm.query<City>().find()

    fun getCityById(idCity: String?): City? {
        return realm.query<City>("idCity == $0", idCity).first().find()
    }

    fun realmResultToList(cityRealm: RealmResults<City>): List<City> {
        return realm.copyFromRealm(cityRealm)
    }
}
