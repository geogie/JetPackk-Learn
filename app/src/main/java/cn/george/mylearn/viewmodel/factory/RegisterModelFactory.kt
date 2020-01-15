package cn.george.mylearn.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.george.mylearn.room.db.repository.UserRepository
import cn.george.mylearn.viewmodel.RegisterModel

/**
 * Created By George
 * Description:
 */
class RegisterModelFactory(private val repository:UserRepository):ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RegisterModel(repository) as T
    }
}