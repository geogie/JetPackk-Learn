package cn.george.mylearn.room.db.repository

import cn.george.mylearn.room.dao.ShoeDao
import cn.george.mylearn.room.data.Shoe

/**
 * Created By George
 * Description:
 */
class ShoeRepository private constructor(private val shoeDao: ShoeDao) {
    companion object{
        @Volatile
        private var instance:ShoeRepository?=null

        fun getInstance(shoeDao: ShoeDao):ShoeRepository = instance?: synchronized(this){
            instance?: ShoeRepository(shoeDao).also {
                instance = it
            }
        }
    }

    fun insertShoes(shoes:List<Shoe>) = shoeDao.ins

//    fun getShoesByBrand(brand:Array<String>) = shoeDao.findShoesByBrandLD(brand)
}