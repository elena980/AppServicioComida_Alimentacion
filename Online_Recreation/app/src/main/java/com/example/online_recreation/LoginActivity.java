package com.example.online_recreation;


import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    private EditText number, code;
    private Button sendNumber, sendCode;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
    private String AutentificationID;
    private PhoneAuthProvider.ForceResendingToken resedingToken;
    private FirebaseAuth auth;
    private ProgressDialog dialog;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle(getString(R.string.Login));

        number = (EditText) findViewById(R.id.numberTelephone);
        code = (EditText) findViewById(R.id.numberTelephone);
        sendNumber = (Button) findViewById(R.id.sendButton);
        sendCode = (Button) findViewById(R.id.acceptButton);

        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);

        sendNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber = number.getText().toString();
                if(TextUtils.isEmpty(phoneNumber)){
                    Toast.makeText(LoginActivity.this,"Enter your telephone number", Toast.LENGTH_LONG).show();
                } else {
                    dialog.setTitle("Verifying number");
                    dialog.setMessage("Please wait while we validate your number");
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(true);

                    PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                            .setPhoneNumber(phoneNumber)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(LoginActivity.this)
                            .setCallbacks(callbacks)
                            .build();
                    PhoneAuthProvider.verifyPhoneNumber(options); //Send number...
                }
            }
        });

        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.setVisibility(GONE);
                sendNumber.setVisibility(GONE);
                String AutentificationCode = code.getText().toString();
                if (TextUtils.isEmpty(AutentificationID)){
                    Toast.makeText(LoginActivity.this,"Enter the code received", Toast.LENGTH_LONG).show();
                } else {
                    dialog.setTitle("Verifying code");
                    dialog.setMessage("Please wait while we validate your code");
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(true);
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(AutentificationID, AutentificationCode);
                }
            }
        });

        callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                SuccessfullyEntered(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                dialog.dismiss();
                Toast.makeText(LoginActivity.this, "Log failure, causes: \n1. invalid number \n2. No connection \n3. No region code", Toast.LENGTH_LONG).show();
                number.setVisibility(VISIBLE);
                sendNumber.setVisibility(VISIBLE);
                code.setVisibility(GONE);
                sendCode.setVisibility(GONE);
            }
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken token){
                AutentificationID = s;
                resedingToken = token;
                dialog.dismiss();
                Toast.makeText(LoginActivity.this, "Code sent successfully, check your inbox",Toast.LENGTH_LONG).show();
                number.setVisibility(GONE);
                sendNumber.setVisibility(GONE);
                code.setVisibility(VISIBLE);
                sendCode.setVisibility(VISIBLE);
            }
        };
    }

    private void SuccessfullyEntered(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    dialog.dismiss();
                    Toast.makeText(LoginActivity.this,"successfully entered", Toast.LENGTH_LONG).show();
                    sendMain();
                } else {
                    String err = task.getException().toString();
                    Toast.makeText(LoginActivity.this,"Error: " + err, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        if (firebaseUser != null){
            sendMain();
        }
    }
    private void sendMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("phone", phoneNumber);
        intent.putExtra("user", "user");
        startActivity(intent);
    }
    public void guest(View view){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

}