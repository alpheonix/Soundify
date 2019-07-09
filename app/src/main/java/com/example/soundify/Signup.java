package com.example.soundify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soundify.dto.SessionDTO;
import com.example.soundify.dto.SignupDTO;
import com.example.soundify.service.NetworkProvider;
import com.example.soundify.service.SignupService;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {


    @BindView(R.id.signup_activity_confirm_mail_edt)
    EditText confirmMailEdt;
    @BindView(R.id.signup_activity_confirm_password_edt)
    EditText confirmPasswordEdt;
    @BindView(R.id.signup_activity_email_edt)
    EditText emailEdt;
    @BindView(R.id.signup_activity_firstname_edt)
    EditText firstnameEdt;
    @BindView(R.id.signup_activity_lastname_edt)
    EditText lastnameEdt;
    @BindView(R.id.signup_activity_password_edt)
    EditText passwordEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.signup_activity_btn)
    void signup() {
        if (confirmMailEdt.getText().length() == 0 || confirmPasswordEdt.getText().length() == 0|| emailEdt.getText().length() == 0|| firstnameEdt.getText().length() == 0|| lastnameEdt.getText().length() == 0|| passwordEdt.getText().length() == 0) {
            Toast.makeText(this, "Merci de remplir tous les champs", Toast.LENGTH_SHORT).show();
        } else {
            register(emailEdt.getText().toString(), passwordEdt.getText().toString(), confirmMailEdt.getText().toString(), confirmPasswordEdt.getText().toString(), firstnameEdt.getText().toString(), lastnameEdt.getText().toString());
        }
    }
    private void register(String email, String password,String confirmMail,String confirmPassword, String firstname,String lastname){
        SignupService signupService;
        signupService = NetworkProvider.getClient().create(SignupService.class);
        SignupDTO signupDTO = new SignupDTO(firstname,lastname,email,confirmMail,password,confirmPassword);

        Call<SessionDTO> sessionDTOCall = signupService.signup(signupDTO);
        sessionDTOCall.enqueue(new Callback<SessionDTO>() {
            @Override
            public void onResponse(Call<SessionDTO> call, Response<SessionDTO> response) {
                SessionDTO sessionDTO = response.body();
                if (response.isSuccessful()) {
                    Intent intent = new Intent(Signup.this, Home.class);
                    startActivity(intent);
                } else if (response.body() == null) {
                    try {
                        JSONObject errorJSON = new JSONObject(response.errorBody().string());
                        Toast.makeText(Signup.this, errorJSON.getString("error"), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.d("toz", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<SessionDTO> call, Throwable t) {
                Log.d("toz", t.toString());
            }
        });

    }
}
