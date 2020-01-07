package cn.george.mylearn.navigation


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cn.george.mylearn.R

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    companion object{
        private const val TAG="RegisterFragment-nav-"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val param1 = it.getString("EMAIL")
            Log.d(TAG,"name:$param1")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }
}
