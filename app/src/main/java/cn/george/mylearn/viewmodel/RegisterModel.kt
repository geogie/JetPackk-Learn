package cn.george.mylearn.viewmodel

import android.os.Looper
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.george.mylearn.room.db.repository.UserRepository
import kotlinx.coroutines.launch

/**
 * Created By George
 * Description:
 */
class RegisterModel constructor(private val repository: UserRepository) : ViewModel() {
    companion object {
        private const val TAG = "RegisterModel"
    }

    val n = MutableLiveData("")
    val p = MutableLiveData("")
    val mail = MutableLiveData("")
    fun onEmailChanged(s: CharSequence) {
        mail.value = s.toString()
    }

    fun onNameChanged(s: CharSequence) {
        n.value = s.toString()
    }

    fun onPwdChanged(s: CharSequence) {
        p.value = s.toString()
    }

    fun register() {
        viewModelScope.launch {
            // 当前为主线程
            Log.d(TAG, "注册-是否是主线程:${Looper.getMainLooper() == Looper.myLooper()}")
            val result = repository.register(mail.value!!, n.value!!, p.value!!)
            Log.d(TAG, "注册-插入数据库的结果:$result")
        }
    }
}