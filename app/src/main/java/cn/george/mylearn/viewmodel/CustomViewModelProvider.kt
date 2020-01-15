package cn.george.mylearn.viewmodel

import android.content.Context
import cn.george.mylearn.room.db.RepositoryProvider
import cn.george.mylearn.room.db.repository.ShoeRepository
import cn.george.mylearn.room.db.repository.UserRepository
import cn.george.mylearn.viewmodel.factory.LoginModelFactory
import cn.george.mylearn.viewmodel.factory.RegisterModelFactory
import cn.george.mylearn.viewmodel.factory.ShoeModelFactory

/**
 * Created By George
 * Description:
 */
object CustomViewModelProvider {

    fun providerRegisterModel(context: Context):RegisterModelFactory{
        val repository:UserRepository = RepositoryProvider.providerUserRepository(context)
        return RegisterModelFactory(repository)
    }

    fun providerShoeModel(context: Context): ShoeModelFactory {
        val repository: ShoeRepository = RepositoryProvider.provierShoeRepository(context)
        return ShoeModelFactory(repository)
    }

    fun providerLoginModel(context: Context): LoginModelFactory {
        val repository: UserRepository = RepositoryProvider.providerUserRepository(context)
        return LoginModelFactory(repository,context)
    }
}