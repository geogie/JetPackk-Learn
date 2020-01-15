package cn.george.mylearn.room.dao

import androidx.paging.DataSource
import androidx.room.*
import cn.george.mylearn.room.data.Shoe

/**
 * Created By George
 * Description:
 */
@Dao
interface ShoeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoes(shoes:List<Shoe>)
//    @Delete
//    fun deleteShoe(shoe: Shoe)

//    @Delete
//    fun deleteShoes(shoes: List<Shoe>)

//    @Update
//    fun updateShoe(shoe: Shoe)
//
//    @Update
//    fun updateShoes(shoes: List<Shoe>)

//    @Query("SELECT * FROM shoe WHERE id=:id")
//    fun findShoeById(id:Long):Shoe?

//    @Query("SELECT * FROM shoe WHERE shoe_brand IN (:brand)")
//    fun findShoesByBrandLD(brand: Array<String>): DataSource.Factory<Int, Shoe>
}