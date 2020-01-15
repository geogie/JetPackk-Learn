package cn.george.mylearn.utils

import android.content.Context
import android.content.SharedPreferences
import cn.george.mylearn.common.BaseApplication
import cn.george.mylearn.databinding.BaseConstant

/**
 * Created By George
 * Description:
 */
object AppPrefsUtils {
    private var sp: SharedPreferences = BaseApplication.context.getSharedPreferences(
        BaseConstant.TABLE_PREFS,
        Context.MODE_PRIVATE
    )
    private var ed: SharedPreferences.Editor

    init {
        ed = sp.edit()
    }

    fun getLong(key: String): Long {
        return sp.getLong(key, 0)
    }

    fun getString(key: String): String? {
        return sp.getString(key, "")
    }

    fun getBoolean(key: String): Boolean {
        return sp.getBoolean(key, false)
    }

    fun putLong(key: String, value: Long) {
        ed.putLong(key, value)
        ed.commit()
    }

    fun putString(key: String, value: String) {
        ed.putString(key, value)
        ed.commit()
    }
}