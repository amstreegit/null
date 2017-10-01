package com.example.shopactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.firstname_edittext)
    EditText firstnameEdittext;
    @BindView(R.id.lastname_edittext)
    EditText lastnameEdittext;
    @BindView(R.id.birthday_edittext)
    EditText birthdayEdittext;
    @BindView(R.id.email_edittext)
    EditText emailEdittext;
    @BindView(R.id.next_button)
    Button nextButton;
    @BindView(R.id.spinner)
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FName = firstnameEdittext.getText().toString();
                String LName = lastnameEdittext.getText().toString();
                String birthday = birthdayEdittext.getText().toString();
                String email = emailEdittext.getText().toString();

                Intent goto_login = new Intent(RegisterActivity.this, LoginActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("fname", FName);
                bundle.putString("lname", LName);
                bundle.putString("bd", birthday);
                bundle.putString("email", email);
                goto_login.putExtra("personalInfo", bundle);
                startActivity(goto_login);
                finish();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backto_login = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(backto_login);
        finish();
    }
}
