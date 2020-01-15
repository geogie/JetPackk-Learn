package cn.george.mylearn.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.george.mylearn.databinding.LoginModel
import cn.george.mylearn.room.db.repository.UserRepository

/**
 * Created By George
 * Description:
 */
class LoginModelFactory (private val repository: UserRepository,private val context: Context):ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginModel(repository) as T
    }
}