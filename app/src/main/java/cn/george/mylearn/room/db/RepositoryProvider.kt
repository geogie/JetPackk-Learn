package cn.george.mylearn.room.db

import android.content.Context
import cn.george.mylearn.room.db.repository.ShoeRepository
import cn.george.mylearn.room.db.repository.UserRepository

/**
 * Created By George
 * Description:
 */
object RepositoryProvider {

    fun providerUserRepository(context: Context):UserRepository{
        return UserRepository.getInstance(AppDataBase.getInstance(context).userDao())
    }

    fun provierShoeRepository(context: Context):ShoeRepository{
        return ShoeRepository.getInstance(AppDataBase.getInstance(context).shoeDao())
    }
}