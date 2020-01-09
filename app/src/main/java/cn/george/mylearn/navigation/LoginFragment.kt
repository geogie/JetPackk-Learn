package cn.george.mylearn.navigation


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import cn.george.mylearn.R
import cn.george.mylearn.databinding.FragmentLoginBinding
import cn.george.mylearn.databinding.LoginModel

private const val ARG_PARAM1 = "name"

class LoginFragment : Fragment() {
    companion object{
        private const val TAG="LoginFragment-nav-"
    }
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            Log.d(TAG,"name:$param1")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentLoginBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        val loginModel = LoginModel("","",context!!)
        binding.model = loginModel
        binding.activity = activity
        return binding.root
    }
}
