package cn.xiaosuli.firstapp;

import android.os.Bundle;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Example02Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuickContactBadge imageView = findViewById(R.id.imageView);
        MaterialButton loginBtn = findViewById(R.id.loginBtn);
        MaterialButton registerBtn = findViewById(R.id.registerBtn);
        imageView.assignContactFromPhone("08618690017635", true);
        registerBtn.setOnClickListener(v -> {
            Toast.makeText(this, "正在跳转页面，请稍后！", Toast.LENGTH_SHORT).show();
        });
        loginBtn.setOnClickListener(v -> {
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this)
                    .setTitle("警告：")
                    .setMessage("用户名或密码不能为空！")
                    .setPositiveButton("确认", (dialog, which) -> {
                        dialog.dismiss();
                        Example02Activity.this.finish();
                    })
                    .setNegativeButton("取消", (dialog, which) -> dialog.dismiss());
            builder.show();
        });
    }
}