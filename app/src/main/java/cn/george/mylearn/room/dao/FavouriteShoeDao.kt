package cn.george.mylearn.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import cn.george.mylearn.room.data.FavouriteShoe

/**
 * Created By George
 * Description:操作实体类
 * 收藏记录的Dao
 */
@Dao
interface FavouriteShoeDao {
    @Query("SELECT * From fav_shoe WHERE user_id = :userId")
    fun findFavouriteShoesByUserId(userId:String):LiveData<FavouriteShoe>
}