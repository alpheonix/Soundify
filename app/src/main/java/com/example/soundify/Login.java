package com.example.soundify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soundify.dto.LoginDTO;
import com.example.soundify.dto.SessionDTO;
import com.example.soundify.dto.SessionLoginDTO;
import com.example.soundify.dto.SignupDTO;
import com.example.soundify.service.LoginService;
import com.example.soundify.service.NetworkProvider;
import com.example.soundify.service.SignupService;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {


    @BindView(R.id.login_activity_email_edt)
    EditText emailEdt;
    @BindView(R.id.login_activity_password_edt)
    EditText passwordEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);



    }

    @OnClick(R.id.login_activity_btn)
    void signup() {
        if (emailEdt.getText().length() == 0|| passwordEdt.getText().length() == 0) {
            Toast.makeText(this, "Merci de remplir tous les champs", Toast.LENGTH_SHORT).show();
        } else {
            login(emailEdt.getText().toString(), passwordEdt.getText().toString());
        }
    }
    private void login(String email,String password){
        LoginService loginService;
        loginService = NetworkProvider.getClient().create(LoginService.class);
        LoginDTO loginDTO = new LoginDTO(email,password);

        Call<SessionLoginDTO> sessionDTOCall = loginService.signup(loginDTO);
        sessionDTOCall.enqueue(new Callback<SessionLoginDTO>() {
            @Override
            public void onResponse(Call<SessionLoginDTO> call, Response<SessionLoginDTO> response) {
                SessionLoginDTO sessionDTO = response.body();
                if (response.isSuccessful()) {
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                } else if (response.body() == null) {
                    try {
                        JSONObject errorJSON = new JSONObject(response.errorBody().string());
                        Toast.makeText(Login.this, errorJSON.getString("error"), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.d("toz", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<SessionLoginDTO> call, Throwable t) {
                Log.d("toz", t.toString());
            }
        });
    }
}
