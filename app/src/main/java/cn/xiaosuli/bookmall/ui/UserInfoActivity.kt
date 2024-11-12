package cn.xiaosuli.bookmall.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import cn.xiaosuli.bookmall.database.AppDatabase
import cn.xiaosuli.bookmall.databinding.ActivityUserInfoBinding
import kotlinx.coroutines.launch

class UserInfoActivity : AppCompatActivity() {

    private val binding: ActivityUserInfoBinding by lazy {
        ActivityUserInfoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.topAppBar) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0, 0)
            insets
        }

        binding.topAppBar.setNavigationOnClickListener { finish() }

        val preferences = getSharedPreferences("app_user", MODE_PRIVATE)
        val username: String = preferences.getString("login_user", "")!!
        lifecycleScope.launch {
            val user = AppDatabase.userDao.findOneByUsername(username) ?: return@launch
            binding.usernameTv.text = user.username
            binding.emailTv.text = user.email
            binding.phoneTv.text = user.phone
            binding.passwordTv.text = user.password
        }
    }
}