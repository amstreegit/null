package com.example.shopactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.phone_number_edittext)
    EditText phoneNumberEdittext;
    @BindView(R.id.enter_button)
    Button enterButton;

    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = phoneNumberEdittext.getText().toString();

                Intent goto_otp = new Intent(LoginActivity.this, ConfirmOtpActivity.class);
                startActivity(goto_otp);
                finish();
            }
        });
    }

//    @Override
//    public void onClick(View view) {
//        int id = view.getId();
//
//        switch (id) {
//            case R.id.login_button:
//                Intent goto_main = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(goto_main);
//                finish();
//                break;
//            case R.id.register_button:
//                Intent goto_register = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(goto_register);
//                finish();
//                break;
//            case R.id.facebook_login_button:
//                goto_main = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(goto_main);
//                finish();
//                break;
//        }
//    }
}
