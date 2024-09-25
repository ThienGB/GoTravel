import com.example.gotravel.data.model.Accommodation
import com.example.gotravel.helper.CallbackHelper
import com.google.android.things.update.UpdatePolicy
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccommodationDaoImpl @Inject constructor(private val realm: Realm) {

    // Add or Update a single accommodation
    fun addOrUpdateAccom(accommodation: Accommodation) {
        CoroutineScope(Dispatchers.IO).launch {
            realm.write {
                val existingAccom = query<Accommodation>("accommodationId == $0", accommodation.accommodationId).first().find()
                if (existingAccom != null) {
                    existingAccom.apply {
                        name = accommodation.name
                        price = accommodation.price
                        freeroom = accommodation.freeroom
                        image = accommodation.image
                        description = accommodation.description
                        address = accommodation.address
                        longitude = accommodation.longitude
                        latitude = accommodation.latitude
                        cityId = accommodation.cityId
                    }
                } else {
                    copyToRealm(accommodation)
                }
            }
        }
    }

    // Add or Update a list of accommodations with callback
    fun addOrUpdateListAccom(accomRes: List<Accommodation>, callback: CallbackHelper) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                realm.write {
                    accomRes.forEach { acc ->
                        val accommodation = Accommodation(
                            acc.accommodationId, acc.name, acc.price, acc.freeroom, acc.image,
                            acc.description, acc.address, acc.longitude, acc.latitude, acc.cityId
                        )
                        copyToRealm(accommodation)
                    }
                }
                callback.onComplete()
            } catch (e: Exception) {

            }
        }
    }

    fun addOrUpdateAccomCb(accommodation: Accommodation, callback: CallbackHelper) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                realm.write {
                    val existingAccom = query<Accommodation>("accommodationId == $0", accommodation.accommodationId).first().find()
                    existingAccom?.apply {
                        name = accommodation.name
                        price = accommodation.price
                        freeroom = accommodation.freeroom
                        image = accommodation.image
                        description = accommodation.description
                        address = accommodation.address
                        longitude = accommodation.longitude
                        latitude = accommodation.latitude
                        cityId = accommodation.cityId
                    }
                        ?: // Nếu chưa tồn tại, thêm đối tượng mới
                        copyToRealm(accommodation)
                }
                callback.onComplete()
            } catch (e: Exception) {

            }
        }
    }

    // Delete accommodation by id
    fun deleteAccom(idAccom: String) {
        CoroutineScope(Dispatchers.IO).launch {
            realm.write {
                val accommodation: Accommodation? = query<Accommodation>("accommodationId == $0", idAccom).first().find()
                accommodation?.let { delete(it) }
            }
        }
    }

    // Delete accommodation by city id
    fun deleteAccomByCityId(idCity: String) {
        CoroutineScope(Dispatchers.IO).launch {
            realm.write {
                val results: RealmResults<Accommodation> = query<Accommodation>("cityId == $0", idCity).find()
                delete(results)
            }
        }
    }

    // Delete all accommodations
    fun deleteAllAccom() {
        CoroutineScope(Dispatchers.IO).launch {
            realm.write {
                delete(query<Accommodation>().find())
            }
        }
    }

    // Get list of accommodations
    fun getAccomList(): RealmResults<Accommodation> {
        return realm.query<Accommodation>().find()
    }

    // Get list of accommodations by city id
    fun getAccomListByCity(idCity: String): RealmResults<Accommodation> {
        return realm.query<Accommodation>("cityId == $0", idCity).find()
    }

    // Get list of accommodations by list of ids
    fun getAccomListById(listIdAccom: List<String>): RealmResults<Accommodation> {
        return realm.query<Accommodation>("accommodationId IN $0", listIdAccom).find()
    }

    // Get accommodation by id
    fun getAccomnById(idAccom: String): Accommodation? {
        return realm.query<Accommodation>("accommodationId == $0", idAccom).first().find()
    }

    // Convert RealmResults to List
    fun realmResultToList(accomRealm: RealmResults<Accommodation>): List<Accommodation> {
        return accomRealm.toList()
    }
}
