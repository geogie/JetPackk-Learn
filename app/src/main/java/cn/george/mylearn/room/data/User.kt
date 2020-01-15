package cn.george.mylearn.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By George
 * Description:需要映射的实体类
 * 用户表
 */

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "user_account") val account: String
    ,// 账号
    @ColumnInfo(name = "user_pwd") val pwd: String
    , @ColumnInfo(name = "user_name") val name: String
    , @ColumnInfo(name = "user_url") val headImage: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}
