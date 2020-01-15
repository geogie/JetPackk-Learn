package cn.george.mylearn.databinding

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.george.mylearn.common.BaseApplication
import cn.george.mylearn.room.data.Shoe
import cn.george.mylearn.room.data.User
import cn.george.mylearn.room.db.RepositoryProvider
import cn.george.mylearn.room.db.repository.UserRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

/**
 * Created By George
 * Description:
 * 和xml中对应，属性用 x.name; 方法用 x::name
 */
class LoginModel constructor(private val repository: UserRepository) : ViewModel() {
    val n = MutableLiveData("")
    val p = MutableLiveData("")

    val nameWatcher = object : SimpleWatcher() {
        override fun afterTextChanged(s: Editable?) {
            super.afterTextChanged(s)
            n.value = s.toString()
        }
    }

    fun onPwdChanged(s: CharSequence, start: Int, before: Int, acount: Int) {
        p.value = s.toString()
    }

    fun login(): LiveData<User?>? {
        val pwd = p.value!!
        val account = n.value!!
        return repository.login(account, pwd)
    }

    fun onFirstLaunch():String{
        val context = BaseApplication.context
        context.assets.open("shoe.json").use {
            JsonReader(it.reader()).use {
                val shoeType = object :TypeToken<List<Shoe>>(){}.type
                val shoeList:List<Shoe> = Gson().fromJson(it,shoeType)
                val shoeDao = RepositoryProvider.provierShoeRepository(context)
                shoeDao.insertShoes(shoeList)
                for(i in 0..2){
                    for (shoe in shoeList){
                        shoe.id += shoeList.size
                    }
                    shoeDao.insertShoes(shoeList)
                }
            }
        }
    }
}