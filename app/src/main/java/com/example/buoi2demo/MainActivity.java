package com.example.buoi2demo;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView btnRegister = findViewById(R.id.Register);
        btnRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(
                                new Intent(MainActivity.this, Activity2.class)
                        );
                    }
                }
        );
        TextView btnLogin = findViewById(R.id.loginButton);
        txtEmail = findViewById(R.id.editPersonName);
        txtPassword = findViewById(R.id.editPasword);
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (txtEmail.getText().toString().isEmpty() ||
                            txtPassword.getText().toString().isEmpty())
                                throw new Exception("Tài khoản hoặc mật khẩu không đc để trống");
                            User newUser = new User(
                                    txtEmail.getText().toString(),
                                    txtPassword.getText().toString()
                            );
                            if (User.userList.isEmpty())
                                throw new Exception("Email hoặc mật khẩu sai");

                            for (User user:
                                    User.userList) {
                                if (!user.Email.equals(newUser.Email)
                                        || !user.Password.equals(newUser.Password)
                                )
                                    throw new Exception("Email hoặc mật khẩu sai");
                            }
                            Toast.makeText(MainActivity.this,"Đăng nhập thành công", Toast.LENGTH_LONG);
                            Thread.sleep(1000);
                            startActivity(
                                    new Intent(MainActivity.this,ActivityBaoNgu.class)
                            );

                        } catch (Exception e) {
                            new AlertDialog.Builder(MainActivity.this)
                                    .setMessage(e.getMessage())
                                    .setPositiveButton("OK", null)
                                    .show();
                        }
                    }
                }
        );

    }
}