//package com.example.gotravel.ui.factory
//
//import androidx.lifecycle.ViewModel
//import kotlinx.coroutines.channels.Channel
//import javax.inject.Inject
//import javax.inject.Provider
//
//class ViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, Provider<ViewModel>>) :
//    Channel.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        var creator: Provider<out ViewModel>? = creators[modelClass]
//        if (creator == null) {
//            for ((key, value) in creators) {
//                if (modelClass.isAssignableFrom(key)) {
//                    creator = value
//                    break
//                }
//            }
//        }
//        requireNotNull(creator) { "Unknown model class: $modelClass" }
//        try {
//            return creator.get() as T
//        } catch (e: Exception) {
//            throw RuntimeException(e)
//        }
//    }
//}