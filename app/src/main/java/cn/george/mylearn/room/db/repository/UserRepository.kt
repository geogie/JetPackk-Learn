package cn.george.mylearn.room.db.repository

import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import cn.george.mylearn.room.dao.UserDao
import cn.george.mylearn.room.data.User
import cn.george.mylearn.viewmodel.RegisterModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

/**
 * Created By George
 * Description:
 */
class UserRepository private constructor(private val userDao: UserDao) {
    companion object {
        private const val TAG="UserRepository"
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(userDao: UserDao): UserRepository = instance ?: synchronized(this) {
            instance ?: UserRepository(userDao).also {
                instance = it
            }
        }
    }

    /**
     * 协程
     */
    suspend fun register(email:String,account:String,pwd:String):Long{
        return withContext(IO){
            // 当前为IO线程（非主线程）
            Log.d(TAG,"注册-io操作-准备插入数据库-是否是主线程:${Looper.getMainLooper() == Looper.myLooper()}")
            userDao.insertUser(User(account,pwd,email,"https://raw.githubusercontent.com/mCyp/Photo/master/1560651318109.jpeg"))
        }
    }

    fun login(account: String,pwd: String):LiveData<User?> = userDao.login(account,pwd)
}