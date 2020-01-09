package cn.george.mylearn.databinding

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.ObservableField
import cn.george.mylearn.MainActivity

/**
 * Created By George
 * Description:
 */
class LoginModel constructor(name:String,pwd:String,context:Context){
    val n = ObservableField<String>(name)
    val p = ObservableField<String>(name)
    val context:Context = context
    val nameWatcher = object :SimpleWatcher(){
        override fun afterTextChanged(s: Editable?) {
            super.afterTextChanged(s)
            n.set(s.toString())
        }
    }

    val pwdWatcher = object :SimpleWatcher(){
        override fun afterTextChanged(s: Editable?) {
            super.afterTextChanged(s)
            p.set(s.toString())
        }
    }

    fun onNameChanged(s:CharSequence){
        n.set(s.toString())
    }

    fun onPwdChanaged(s: CharSequence, start: Int, before: Int, count: Int){
        p.set(s.toString())
    }

    fun login(){
        if (n.get().equals(BaseConstant.USER_NAME) && p.get().equals(BaseConstant.USER_PWD)){
            Toast.makeText(context,"账号密码正确",Toast.LENGTH_SHORT).show()
            val intent = Intent(context,MainActivity::class.java)
            context.startActivity(intent)
        }else{
            Toast.makeText(context,"账号密码错误",Toast.LENGTH_SHORT).show()
        }
    }

    fun enableLogin():Boolean{
        return !(TextUtils.isEmpty(n.get())|| TextUtils.isEmpty(p.get()))
    }
}