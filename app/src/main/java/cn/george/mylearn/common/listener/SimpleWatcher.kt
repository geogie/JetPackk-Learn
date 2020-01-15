package cn.george.mylearn.common.listener

import android.text.Editable
import android.text.TextWatcher

/**
 * Created By George
 * Description:
 */
open class SimpleWatcher : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

}