package cn.xiaosuli.bookmall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import cn.xiaosuli.bookmall.R;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText usernameEdit = findViewById(R.id.username_edit);
        EditText passwordEdit = findViewById(R.id.password_edit);
        EditText emailEdit = findViewById(R.id.email_edit);
        EditText phoneEdit = findViewById(R.id.phone_edit);
        Button registerBtn = findViewById(R.id.register_btn);
        Button goUserInfo = findViewById(R.id.go_user_info);

        registerBtn.setOnClickListener(v -> {
            String username = usernameEdit.getText().toString().trim();
            String password = passwordEdit.getText().toString().trim();
            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            bundle.putString("password", password);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(2233, intent);
            finish();
        });

        goUserInfo.setOnClickListener(v -> {
            String username = usernameEdit.getText().toString().trim();
            String password = passwordEdit.getText().toString().trim();
            String email = emailEdit.getText().toString().trim();
            String phone = phoneEdit.getText().toString().trim();

            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            bundle.putString("password", password);
            bundle.putString("email", email);
            bundle.putString("phone", phone);

            Intent intent = new Intent(this, UserInfoActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}
