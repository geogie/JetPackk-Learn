//package cn.george.mylearn.room.db.repository
//
//import androidx.lifecycle.LiveData
//import cn.george.mylearn.room.dao.UserDao
//import cn.george.mylearn.room.data.User
//
///**
// * Created By George
// * Description:
// */
//class UserRepository private constructor(private val userDao:UserDao){
//    companion object{
//        @Volatile
//        private var instance:UserRepository?=null
//        fun getInstance(userDao: UserDao):UserRepository = instance ?: synchronized(this){
//            instance ?:UserRepository(userDao).also {
//                instance = it
//            }
//        }
//    }
//    fun getAllUsers() = userDao.getAllUsers()
//    /**
//     * 登录用户
//     */
//    fun login(account: String, pwd: String): LiveData<User?>
//            = userDao.login(account,pwd)
//}