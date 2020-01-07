package cn.george.mylearn

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import cn.george.mylearn.liveData.LiveDataFragment
import cn.george.mylearn.retrofit.Test


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager    //
            .beginTransaction()
            .add(
                R.id.fragmentContainer,
                LiveDataFragment.getInstance()
            )   // 此处的R.id.fragment_container是要盛放fragment的父容器
            .commit()


    }

    fun onTest(view: View) {
        Test.test()
    }
}
