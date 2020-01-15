package cn.george.mylearn.navigation


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import cn.george.mylearn.R
import cn.george.mylearn.databinding.BaseConstant
import cn.george.mylearn.databinding.FragmentRegisterBinding
import cn.george.mylearn.viewmodel.CustomViewModelProvider
import cn.george.mylearn.viewmodel.RegisterModel

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {
    companion object {
        private const val TAG = "RegisterFragment-nav-"
    }

    private var isEnable: Boolean = false
    private val registerModel: RegisterModel by viewModels {
        CustomViewModelProvider.providerRegisterModel(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val param1 = it.getString("EMAIL")
            Log.d(TAG, "name:$param1")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentRegisterBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        initData(binding)
        onSubscribeUi(binding)
        return binding.root
    }

    private fun initData(binding: FragmentRegisterBinding) {
        val safeArgs: RegisterFragmentArgs by navArgs()
        val email = safeArgs.email
        binding.model?.mail?.value = email
        binding.model = registerModel
        binding.isEnable = isEnable
        binding.activity = activity
    }

    private fun onSubscribeUi(binding: FragmentRegisterBinding) {
        binding.btnRegister.setOnClickListener {
            Log.d(TAG, "注册")
            registerModel.register()// 注册不论是否成功都进行下一步跳转到登录界面
            val bundle = Bundle()
            bundle.putString(BaseConstant.ARGS_NAME, registerModel.n.value)
            findNavController().navigate(R.id.login, bundle, null)
        }

        registerModel.p.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "监听密码:$it")
            binding.isEnable =
                it.isNotEmpty()
                        && registerModel.n.value!!.isNotEmpty()
                        && registerModel.mail.value!!.isNotEmpty()
        })

        registerModel.n.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "监听名字:$it")
            binding.isEnable = it.isNotEmpty()
                    && registerModel.p.value!!.isNotEmpty()
                    && registerModel.mail.value!!.isNotEmpty()
        })

        registerModel.mail.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "监听邮箱:$it")
            binding.isEnable = it.isNotEmpty()
                    && registerModel.n.value!!.isNotEmpty()
                    && registerModel.p.value!!.isNotEmpty()
        })
    }
}
