package cn.george.mylearn.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import cn.george.mylearn.room.dao.FavouriteShoeDao
import cn.george.mylearn.room.dao.ShoeDao
import cn.george.mylearn.room.dao.UserDao
import cn.george.mylearn.room.data.FavouriteShoe
import cn.george.mylearn.room.data.Shoe
import cn.george.mylearn.room.data.User

/**
 * Created By George
 * Description: 抽象类
 * 数据库文件
 */
@Database(
    entities = [User::class
//        , Shoe::class, FavouriteShoe::class
    ],
    version = 1,
    exportSchema = false
)
//@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao():UserDao

    abstract fun shoeDao():ShoeDao

//    abstract fun shoeDao():ShoeDao
//
//    abstract fun favouriteShoeDao():FavouriteShoeDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDataBase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDataBase(context: Context): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, "jetPackDemo-database")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                }).build()
        }
    }
}