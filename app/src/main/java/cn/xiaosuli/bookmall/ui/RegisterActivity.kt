package cn.xiaosuli.bookmall.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import cn.xiaosuli.bookmall.R
import cn.xiaosuli.bookmall.database.AppDatabase
import cn.xiaosuli.bookmall.databinding.ActivityRegisterBinding
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.registerBtn.setOnClickListener {
            val username = binding.usernameEdit.text.toString().trim { it <= ' ' }
            val password = binding.passwordEdit.text.toString().trim { it <= ' ' }
            val email = binding.emailEdit.text.toString().trim { it <= ' ' }
            val phone = binding.phoneEdit.text.toString().trim { it <= ' ' }
            if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "请输入完整信息!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val userDao = AppDatabase.userDao
            lifecycleScope.launch {
                val user = userDao.findOneByUsername(username)
                if (user != null) {
                    Toast.makeText(
                        this@RegisterActivity,
                        "用户名已存在!",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@launch
                }
                val i = userDao.insert(username, password, email, phone)
                if (i > 0) {
                    finish()
                } else {
                    Toast.makeText(
                        this@RegisterActivity,
                        "注册失败!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}