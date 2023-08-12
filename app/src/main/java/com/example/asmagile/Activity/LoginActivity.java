package com.example.asmagile.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asmagile.MainActivity;
import com.example.asmagile.Obj.Users;
import com.example.asmagile.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    EditText edt_phone, edt_pass;
    CheckBox chk_remember;
    Button btn_login;
    TextView tv_Signup;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("User");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_phone=findViewById(R.id.edt_phone);
        edt_pass=findViewById(R.id.edt_Pass);
        chk_remember=findViewById(R.id.chk_remember);
        btn_login=findViewById(R.id.btn_login);
        tv_Signup=findViewById(R.id.tv_SignUp);
        SharedPreferences spf = this.getSharedPreferences("USERS_FILE", Context.MODE_PRIVATE);
        String phone = spf.getString("PHONE", "");
        String pass = spf.getString("PASSWORD", "");
        boolean remember = spf.getBoolean("REMEMBER", false);
        edt_phone.setText(phone);
        edt_pass.setText(pass);
        chk_remember.setChecked(remember);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Vui lòng chờ....");
                progressDialog.show();
                if (validate() > 0) {
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(edt_phone.getText().toString())){
                                Users user =  snapshot.child(edt_phone.getText().toString()).getValue(Users.class);
                                user.setPhone(edt_phone.getText().toString());
                                if (user.getPass().equals(edt_pass.getText().toString())){
                                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                        progressDialog.dismiss();
                                        startActivity(new Intent(LoginActivity.this,MatHangActivity.class));


//                                    Common.currentUser = user;
                                    rememberUser(edt_phone.getText().toString(),edt_pass.getText().toString(),chk_remember.isChecked());
                                    finish();
                                    databaseReference.removeEventListener(this);

                                }else {
                                    Toast.makeText(LoginActivity.this, "Mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }
                            }else {
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "Số điện thoại chưa được đăng ký", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
        });
        tv_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
    }
    private void rememberUser(String username, String pass, boolean status) {
        SharedPreferences spf = this.getSharedPreferences("USERS_FILE", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = spf.edit();
        if (!status) {
            edit.clear();
            edit.putString("PHONE", username);
        } else {
            edit.putString("PHONE", username);
            edit.putString("PASSWORD", pass);
        }
        edit.putBoolean("REMEMBER", status);
        edit.apply();
    }

    private int validate() {
        String regex = "0[0-9]{9}";
        String phone = edt_phone.getText().toString();
        String pass = edt_pass.getText().toString();
        if (phone.trim().isEmpty()) {
            edt_phone.setError("Vui lòng nhập số điện thoại");
            return -1;
        }

        if (!phone.matches(regex)){
            edt_phone.setError("Số điện thoại của bạn không hợp lệ");
        }

        if (pass.trim().isEmpty()) {
            edt_pass.setError("Vui lòng nhập mật khẩu");
            return -1;
        }

        return 1;
    }
}