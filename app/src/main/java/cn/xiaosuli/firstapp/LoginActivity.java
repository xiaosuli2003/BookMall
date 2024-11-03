package cn.xiaosuli.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText usernameEdit;
    private TextInputEditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEdit = findViewById(R.id.username);
        passwordEdit = findViewById(R.id.password);

        MaterialButton loginBtn = findViewById(R.id.loginBtn);

        TextView goRegister = findViewById(R.id.go_register);

        goRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivityForResult(intent,2233);
        });

        loginBtn.setOnClickListener(v -> {
            String username = usernameEdit.getText().toString().trim();
            String password = passwordEdit.getText().toString().trim();
            if ("xiaosuli".equals(username) && "123456".equals(password)) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
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
    }
}
