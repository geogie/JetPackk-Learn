package cn.george.mylearn.room.db.datasource

import androidx.paging.DataSource
import cn.george.mylearn.room.data.Shoe
import cn.george.mylearn.room.db.repository.ShoeRepository

/**
 * Created By George
 * Description:
 */
class CustomPageDataSourceFactory(private val shoeRepository: ShoeRepository):DataSource.Factory<Int,Shoe>() {
    override fun create(): DataSource<Int, Shoe> {
        return CustomPageDataSource(shoeRepository)
    }
}