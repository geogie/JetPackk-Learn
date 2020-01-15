package cn.george.mylearn.common

import android.app.Application
import android.content.Context

/**
 * Created By George
 * Description:
 */
open class BaseApplication :Application(){
    companion object{
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = this
    }
}