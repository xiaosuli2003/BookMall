package cn.xiaosuli.bookmall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.xiaosuli.bookmall.R;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView usernameTv = findViewById(R.id.username);
        TextView passwordTv = findViewById(R.id.password);
        TextView emailTv = findViewById(R.id.email);
        TextView phoneTv = findViewById(R.id.phone);
        
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        String email = bundle.getString("email");
        String phone = bundle.getString("phone");

        usernameTv.setText(username);
        passwordTv.setText(password);
        emailTv.setText(email);
        phoneTv.setText(phone);
    }
}