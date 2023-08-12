package com.example.asmagile.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asmagile.Obj.Users;
import com.example.asmagile.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpActivity extends AppCompatActivity {
    DatabaseReference table_user = FirebaseDatabase.getInstance().getReference("User");
    EditText ed_phone,ed_pass,ed_name;
    Button btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ed_phone=findViewById(R.id.edt_phone2);
        ed_pass=findViewById(R.id.edt_Pass2);
        ed_name=findViewById(R.id.edt_name);
        btnSignup=findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate() > 0){
                    ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
                    progressDialog.setMessage("Vui lòng chờ...");
                    progressDialog.show();
                    table_user.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // Đã tồn tại tài khoản
                            if (snapshot.hasChild(ed_phone.getText().toString())){
                                Toast.makeText(SignUpActivity.this, "Số điện thoại này đã được đăng ký", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }else { // Chưa tồn tại tài khoản
                                Users user = new Users(ed_name.getText().toString(),ed_pass.getText().toString(),"",1,"");
                                table_user.child(ed_phone.getText().toString()).setValue(user);
                                Toast.makeText(SignUpActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
    private int validate() {
        String regex = "0[0-9]{9}";
        String phone = ed_phone.getText().toString();
        String pass = ed_pass.getText().toString();
        String name = ed_name.getText().toString();

        if (phone.trim().isEmpty()) {
            ed_phone.setError("Vui lòng nhập số điện thoại");
            return -1;
        }

        if (!phone.matches(regex)){
            ed_phone.setError("Số điện thoại của bạn không hợp lệ");
            return -1;
        }

        if (pass.trim().isEmpty()) {
            ed_pass.setError("Vui lòng nhập mật khẩu");
            return -1;
        }

        if (name.trim().isEmpty()) {
            ed_name.setError("Vui lòng nhập tên");
            return -1;
        }

        return 1;
    }
}