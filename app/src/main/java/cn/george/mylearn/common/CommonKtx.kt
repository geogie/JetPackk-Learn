package cn.george.mylearn.common

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList


/**
 * Created By George
 * Description:
 */

fun <T> DataSource.Factory<Int, T>.createPagerList(
    pageSize: Int,
    defaultSize: Int
): LiveData<PagedList<T>> {
    return LivePagedListBuilder<Int, T>(
        this, PagedList.Config.Builder()
            .setPageSize(2)
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(2).build()
    ).build()
}