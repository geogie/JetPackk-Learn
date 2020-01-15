package cn.george.mylearn.navigation


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import cn.george.mylearn.MainActivity
import cn.george.mylearn.R
import cn.george.mylearn.databinding.BaseConstant
import cn.george.mylearn.databinding.FragmentLoginBinding
import cn.george.mylearn.databinding.LoginModel
import cn.george.mylearn.utils.AppPrefsUtils
import cn.george.mylearn.viewmodel.CustomViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val ARG_PARAM1 = "name"

class LoginFragment : Fragment() {
    companion object {
        private const val TAG = "LoginFragment-nav-"
    }

    private var param1: String? = null
    private val loginModel: LoginModel by viewModels {
        CustomViewModelProvider.providerLoginModel(requireContext())
    }
    private var isEnable: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            Log.d(TAG, "name:$param1")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        onSubscribeUi(binding)

        var isFirstLaunch = AppPrefsUtils.getBoolean(BaseConstant.IS_FIRST_LAUNCH)
        if (isFirstLaunch){
            on
        }

        return binding.root
    }

    private fun onSubscribeUi(binding: FragmentLoginBinding) {
        binding.model = loginModel
        binding.isEnable = isEnable
        binding.activity = activity

        binding.btnLogin.setOnClickListener {
            Log.d(TAG, "登录")
            loginModel.login()?.observe(this, Observer {
                it?.let {
                    AppPrefsUtils.putLong(BaseConstant.SP_USER_ID, it.id)
                    AppPrefsUtils.putString(BaseConstant.SP_USER_NAME, it.account)
                    val intent = Intent(context, MainActivity::class.java)
                    context!!.startActivity(intent)
                    Toast.makeText(context, "登录成功!", Toast.LENGTH_SHORT).show()
                }
            })

            loginModel.p.observe(viewLifecycleOwner, Observer {
                binding.isEnable = it.isNotEmpty() && loginModel.n.value!!.isNotEmpty()
            })

            val name = arguments?.getString(BaseConstant.ARGS_NAME)
            if (!TextUtils.isEmpty(name))
                loginModel.n.value = name!!
        }
    }

    private fun onFirstLaunch(){
        GlobalScope.launch(Dispatchers.Main) {
            val str = withContext(Dispatchers.IO){
                loginModel.on
            }
        }
    }
}
