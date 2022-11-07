package com.example.buoi2demo;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    EditText txtUserName, txtEmail, txtPassword, txtConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        TextView btnBackToLogin = findViewById(R.id.backToLogin);
        btnBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnRegister = findViewById(R.id.registerButton);
        txtUserName = findViewById(R.id.editUserName);
        txtEmail = findViewById(R.id.editEmail);
        txtPassword = findViewById(R.id.editPaswordRegister);
        txtConfirmPassword =findViewById(R.id.editRepass);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (txtUserName.getText().toString().isEmpty() ||
                    txtEmail.getText().toString().isEmpty()||
                    txtPassword.getText().toString().isEmpty() ||
                    txtConfirmPassword.getText().toString().isEmpty())
                        throw new Exception("Phải nhập hết mọi trường dữ liệu");

                    if (!txtPassword.getText().toString()
                            .equals(txtConfirmPassword.getText().toString())) {
                        throw new Exception("Mật khẩu và nhập lại mật khẩu phải trùng nhau");

                    }
                    User newUser = new User(
                            txtUserName.getText().toString(),
                            txtEmail.getText().toString(),
                            txtPassword.getText().toString()
                            );
                    for (User user: User.userList) {

                        if (user.UserName.equals(newUser.UserName) || user.Email.equals(newUser.Email)){
                            throw new Exception("Email đăng kí đã tồn tại");

                        }
                        
                    }
                    User.userList.add(newUser);


                    Toast.makeText(Activity2.this,"Đăng kí thành công", Toast.LENGTH_LONG)
                            .show();
                } catch (Exception e) {
                    new AlertDialog.Builder(Activity2.this)
                            .setMessage(e.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                }
            }
        });
    }
}