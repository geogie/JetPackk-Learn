package cn.george.mylearn.navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import cn.george.mylearn.R
import kotlinx.android.synthetic.main.fragment_welcome.*

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvNext.setOnClickListener {
            val navOption = navOptions {
                anim {
                    enter = R.anim.common_slide_in_right
                    exit = R.anim.common_slide_out_left
                    popEnter = R.anim.common_slide_in_left
                    popExit = R.anim.common_slide_out_right
                }
            }
            val bundle = Bundle()
            bundle.putString("name", "TeaOf")
            // 利用id导航
            findNavController().navigate(R.id.login, bundle, navOption)
        }

        tvRegister.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeToRegister().setEMAIL("email ok")
            findNavController().navigate(action)

        }
        super.onViewCreated(view, savedInstanceState)
    }
}
