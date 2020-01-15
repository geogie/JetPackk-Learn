package cn.george.mylearn.paging


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import cn.george.mylearn.databinding.FragmentShoeBinding
import cn.george.mylearn.ui.adapter.ShoeAdapter
import cn.george.mylearn.viewmodel.CustomViewModelProvider
import cn.george.mylearn.viewmodel.ShoeModel
import kotlinx.android.synthetic.main.fragment_shoe.*

/**
 * A simple [Fragment] subclass.
 */
class ShoeFragment : Fragment() {

    private val viewModel:ShoeModel by viewModels {
        CustomViewModelProvider.providerShoeModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeBinding = FragmentShoeBinding.inflate(inflater, container, false)
        context ?: return binding.root
        val adapter = ShoeAdapter(context!!)
        binding.recycler.adapter = adapter
        onSubscribeUi(adapter, binding)
        return binding.root
    }

    private fun onSubscribeUi(adapter: ShoeAdapter, binding: FragmentShoeBinding) {
//        viewModel.shoes.observe(viewLifecycleOwner, Observer {
//            if (it !=null){
//                adapter.submitList(it)
//            }
//        })
    }
}
