import android.content.Context
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.RealmObject
import org.reflections.Reflections
import kotlin.reflect.KClass

class RealmHelper(context: Context?) {
    var realm: Realm

    init {
        val config = RealmConfiguration.Builder(
            schema = getAllRealmObjects()
        )
            .name("qlphongban1.realm")
            .schemaVersion(1)
            .build()

        // Mở Realm với cấu hình
        realm = Realm.open(config)
    }

    fun closeRealm() {
        realm.close()
    }

    fun openRealm() {
        // Đảm bảo Realm đã được mở trước khi sử dụng
        if (!realm.isClosed()) {
            realm = Realm.open(realm.configuration)
        }
    }
    private fun getAllRealmObjects(): Set<KClass<out RealmObject>> {
        val reflections = Reflections("com.example.gotravel")
        val classes = reflections.getSubTypesOf(RealmObject::class.java)

        return classes.map { it.kotlin }.toSet()
    }
}
