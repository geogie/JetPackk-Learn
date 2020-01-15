package cn.george.mylearn.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.george.mylearn.room.db.repository.ShoeRepository
import cn.george.mylearn.viewmodel.ShoeModel

/**
 * Created By George
 * Description:
 */

class ShoeModelFactory(private val repository: ShoeRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoeModel(repository) as T
    }
}