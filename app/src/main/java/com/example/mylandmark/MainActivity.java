package com.example.mylandmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userid,passwd;
    Button btn_login,btn_info,btn_guide,btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userid = findViewById(R.id.userid);
        passwd = findViewById(R.id.passwd);
        btn_login = findViewById(R.id.btn_login);
        btn_info = findViewById(R.id.btn_info);
        btn_guide = findViewById(R.id.btn_guide);
        btn_call = findViewById(R.id.btn_call);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_id = userid.getText().toString();
                String str_pw = passwd.getText().toString();

                Log.d("TEST",str_id);
                Log.d("TEST",str_pw);

                if (str_id.length()<5 || str_pw.length()<8 ){
                    Toast.makeText(MainActivity.this, "아이디와 비밀번호의 길이를 확인하세요", Toast.LENGTH_SHORT).show();
                }
                else{

                    if(str_id.equals("30402")&& str_pw.equals("12345678")) {
                        Toast.makeText(MainActivity.this, "환영합니다.", Toast.LENGTH_SHORT).show();
                    }
                            else{
                                Toast.makeText(MainActivity.this,"아이디와 비밀번호를 확인하세요.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }


        });

        btn_info.setOnClickListener(this);
        btn_guide.setOnClickListener(this);
        btn_call.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()){
            case R.id.btn_info:
                intent = new Intent(MainActivity.this, infoActivity.class);
                break;
            case R.id.btn_guide:
                intent = new Intent(MainActivity.this, GuideActivity2.class);
                break;
            case R.id.btn_call:
                intent = new Intent(MainActivity.this, CallActivity2.class);
                break;
        }
        startActivity(intent);
    }
}