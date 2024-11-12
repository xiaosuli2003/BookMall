package cn.xiaosuli.bookmall.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import cn.xiaosuli.bookmall.R
import cn.xiaosuli.bookmall.database.AppDatabase
import cn.xiaosuli.bookmall.databinding.ActivityLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
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

        val userDao = AppDatabase.userDao
        lifecycleScope.launch(Dispatchers.IO) {
            userDao.insert("admin", "123456")
        }
        binding.loginBtn.setOnClickListener {
            val username = binding.usernameEdit.text.toString().trim { it <= ' ' }
            val password = binding.passwordEdit.text.toString().trim { it <= ' ' }
            lifecycleScope.launch {
                userDao.findOne(username, password).collectLatest{
                    if (it == null) {
                        Toast.makeText(this@LoginActivity, "用户名或密码错误！", Toast.LENGTH_SHORT).show()
                        return@collectLatest
                    }
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    } /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("LoginActivity", "requestCode:" + requestCode);
        Log.i("LoginActivity", "resultCode:" + resultCode);
        if (requestCode == 2233) {
            Bundle bundle = data.getExtras();
            String username = bundle.getString("username", "");
            String password = bundle.getString("password", "");
            usernameEdit.setText(username);
            passwordEdit.setText(password);
        }
    }*/
}
