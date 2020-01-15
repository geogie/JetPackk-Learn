package cn.george.mylearn.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import cn.george.mylearn.room.data.User

/**
 * Created By George
 * Description:
 */
@Dao
interface UserDao {
    /**
     * 查询
     */
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    /**
     * 插入：增加数据
     */
    @Insert
    fun insertUser(user: User): Long

    /**
     * 删除指定user：需要根据主键id删除，否则不行
     */
    @Delete
    fun deleteUser(user: User)

    /**
     * 清除表中全部数据
     */
    @Query("DELETE FROM user")
    fun deleteAll()

    /**
     * 修改：需要根据user-->需要根据主键id进行修改，否则修改不成
     */
    @Update
    fun updateUser(user: User)

    @Query("SELECT * FROM user WHERE user_account = :account AND user_pwd = :pwd")
    fun login(account: String, pwd: String): LiveData<User?>
}