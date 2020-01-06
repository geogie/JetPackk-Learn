package cn.george.mylearn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.george.mylearn.liveData.LiveDataFragment


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
}
