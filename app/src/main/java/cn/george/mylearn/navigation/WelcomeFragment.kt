package cn.george.mylearn.navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import cn.george.mylearn.R
import cn.george.mylearn.databinding.BaseConstant
import cn.george.mylearn.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.fragment_welcome.*

/**
 * 欢迎界面
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener {
            val navOption = navOptions {
                anim {
                    enter = R.anim.common_slide_in_right
                    exit = R.anim.common_slide_out_left
                    popEnter = R.anim.common_slide_in_left
                    popExit = R.anim.common_slide_out_right
                }
            }

            val name = AppPrefsUtils.getString(BaseConstant.SP_USER_NAME)
            val bundle = Bundle()
            bundle.putString(BaseConstant.ARGS_NAME, name)
            findNavController().navigate(R.id.login, bundle, navOption)
        }

        btn_register.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeToRegister()
                .setEMAIL("george@Gamil.com")
            findNavController().navigate(action)
        }
    }
}
