package cn.xiaosuli.bookmall.ui

import android.app.Activity.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import cn.xiaosuli.bookmall.databinding.FragmentMineBinding

class MineFragment : Fragment() {

    private var _binding: FragmentMineBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMineBinding.inflate(inflater, container, false)

        binding.userInfoBar.setOnClickListener { goUserInfoActivity() }
        binding.userInfoCard.setOnClickListener { goUserInfoActivity() }

        val preferences = requireActivity().getSharedPreferences("app_user", MODE_PRIVATE)
        val username = preferences.getString("login_user", "")
        binding.usernameTv.text = "欢迎你，${username}！"
        binding.logoutBtn.setOnClickListener {
            preferences.edit { remove("login_user") }
            startActivity(Intent(activity, LoginActivity::class.java))
            requireActivity().finish()
        }

        return binding.root
    }

    private fun goUserInfoActivity() {
        startActivity(Intent(activity, UserInfoActivity::class.java))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}