package cn.george.mylearn.room.data

import androidx.room.*

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
//    ,// 密码
//    @ColumnInfo(name = "user_name") val name: String,
//    @Embedded val address: Address,// 嵌套 地址
//    @Ignore val state: Int // 状态只是临时的，所以不需要存储到数据库中
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}
