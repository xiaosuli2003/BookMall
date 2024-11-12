package cn.xiaosuli.bookmall.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.tooling.data.EmptyGroup.data
import androidx.fragment.app.Fragment
import cn.xiaosuli.bookmall.adapter.ToolbarAdapter
import cn.xiaosuli.bookmall.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val toolbarAdapter = ToolbarAdapter(activity, data)
        binding.toolbar.apply {

            adapter = toolbarAdapter
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}