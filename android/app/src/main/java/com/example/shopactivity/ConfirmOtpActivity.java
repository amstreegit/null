package com.example.shopactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmOtpActivity extends AppCompatActivity {

    @BindView(R.id.confirm_otp_edittext)
    EditText confirmOtpEdittext;
    @BindView(R.id.confirm_button)
    Button confirmButton;

    String otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_otp);
        ButterKnife.bind(this);


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp = confirmOtpEdittext.getText().toString();
                if (otp.equals("123456")) {
                    Intent goto_main = new Intent(ConfirmOtpActivity.this, MainActivity.class);
                    startActivity(goto_main);
                    finish();
                } else {
                    Intent goto_register = new Intent(ConfirmOtpActivity.this, RegisterActivity.class);
                    startActivity(goto_register);
                    finish();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backto_login = new Intent(ConfirmOtpActivity.this, LoginActivity.class);
        startActivity(backto_login);
        finish();
    }
}
