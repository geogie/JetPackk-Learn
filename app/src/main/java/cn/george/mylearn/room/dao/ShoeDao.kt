package cn.george.mylearn.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import cn.george.mylearn.room.data.Shoe

/**
 * Created By George
 * Description:
 */
@Dao
interface ShoeDao {
    @Delete
    fun deleteShoe(shoe: Shoe)

    @Delete
    fun deleteShoes(shoes: List<Shoe>)

    @Update
    fun updateShoe(shoe: Shoe)

    @Update
    fun updateShoes(shoes: List<Shoe>)

    @Query("SELECT * FROM shoe WHERE id=:id")
    fun findShoeById(id:Long):Shoe?
}