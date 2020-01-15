package cn.george.mylearn.room.db.datasource

import androidx.paging.PageKeyedDataSource
import cn.george.mylearn.room.data.Shoe
import cn.george.mylearn.room.db.repository.ShoeRepository

/**
 * Created By George
 * Description:
 */
class CustomPageDataSource (private val shoeRepository: ShoeRepository):PageKeyedDataSource<Int, Shoe>(){
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Shoe>
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Shoe>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Shoe>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}