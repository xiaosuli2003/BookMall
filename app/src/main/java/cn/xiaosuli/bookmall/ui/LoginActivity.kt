package cn.xiaosuli.bookmall.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import cn.xiaosuli.bookmall.R
import cn.xiaosuli.bookmall.database.AppDatabase
import cn.xiaosuli.bookmall.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
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

        val preferences = getSharedPreferences("app_user", MODE_PRIVATE)

        val loginUser = preferences.getString("login_user", "")
        if (loginUser != "") {
            goMainActivity()
        }

        if (preferences.getBoolean("isChecked", false)) {
            binding.usernameEdit.setText(preferences.getString("username", ""))
            binding.passwordEdit.setText(preferences.getString("password", ""))
            binding.checkbox.isChecked = true
        }

        binding.loginBtn.setOnClickListener {
            val username = binding.usernameEdit.text.toString().trim { it <= ' ' }
            val password = binding.passwordEdit.text.toString().trim { it <= ' ' }
            val isChecked = binding.checkbox.isChecked
            lifecycleScope.launch {
                val user = AppDatabase.userDao.findOne(username, password)
                if (user == null) {
                    Toast.makeText(this@LoginActivity, "用户名或密码错误！", Toast.LENGTH_SHORT)
                        .show()
                    return@launch
                }
                preferences.edit {
                    if (isChecked) {
                        putString("login_user", username)
                        putString("username", username)
                        putString("password", password)
                        putBoolean("isChecked", true)
                    } else {
                        putString("login_user", username)
                        remove("username")
                        remove("password")
                        remove("isChecked")
                    }
                }
                goMainActivity()
            }
        }

        binding.goRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun goMainActivity() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
        this@LoginActivity.finish()
    }
}
