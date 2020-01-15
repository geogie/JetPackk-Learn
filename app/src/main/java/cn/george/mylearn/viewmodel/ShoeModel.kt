package cn.george.mylearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import cn.george.mylearn.common.createPagerList
import cn.george.mylearn.room.data.Shoe
import cn.george.mylearn.room.db.datasource.CustomPageDataSourceFactory
import cn.george.mylearn.room.db.repository.ShoeRepository

/**
 * Created By George
 * Description:
 */
class ShoeModel constructor(shoeRepository: ShoeRepository) : ViewModel() {
    companion object {
        const val ALL = "所有"
        public const val NIKE = "Nike"
        public const val ADIDAS = "Adidas"
        public const val OTHER = "other"
    }

    private val brand = MutableLiveData<String>().apply {
        value = ALL
    }

//    val shoes: LiveData<PagedList<Shoe>> = brand.switchMap {
//        if (it == ALL) {
//            LivePagedListBuilder(
//                CustomPageDataSourceFactory(shoeRepository)
//                , PagedList.Config.Builder()
//                    .setPageSize(10)
//                    .setEnablePlaceholders(false)
//                    .setInitialLoadSizeHint(10)
//                    .build()
//            ).build()
//        } else {
//            val array: Array<String> =
//                when (it) {
//                    NIKE -> arrayOf("Nike", "Air Jordan")
//                    ADIDAS -> arrayOf("Adidas")
//                    else -> arrayOf("Converse", "UA", "ANTA")
//                }
//            shoeRepository.getShoesByBrand(array)
//                .createPagerList(6, 6)
//        }
//    }
}