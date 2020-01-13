package cn.george.mylearn.room

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import cn.george.mylearn.R
import cn.george.mylearn.room.data.User
import cn.george.mylearn.room.db.AppDataBase

class RoomActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "RoomActivity-"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
    }

    fun onRoomTest(view: View) {
        Thread(Runnable {
            val user = User("hello", "123")
            val result = AppDataBase.getInstance(this).userDao().insertUser(user)
            Log.d(TAG, "插入-result:$result")
        }).start()
    }

    fun onDelete(view: View) {
        Thread(Runnable {
            val userList = AppDataBase.getInstance(this).userDao().getAllUsers()
            val id = userList[0].id
            val user = User("hello", "123")
            user.id = id
            val result = AppDataBase.getInstance(this).userDao().deleteUser(user)
            Log.d(TAG, "删除-result:$result")
        }).start()
    }

    fun onQuery(view: View) {
        Thread(Runnable {
            val userList = AppDataBase.getInstance(this).userDao().getAllUsers()
            Log.d(TAG, "获取-userList:$userList")
        }).start()
    }

    fun onUpdate(view: View) {
        Thread(Runnable {
            val userList = AppDataBase.getInstance(this).userDao().getAllUsers()
            val id = userList[0].id
            val user = User("hello", "1234")
            Log.d(TAG,"准备-user:$user id:$id")
            user.id=id
            val result = AppDataBase.getInstance(this).userDao().updateUser(user)
            Log.d(TAG, "修改-result:$result")
        }).start()

    }
}