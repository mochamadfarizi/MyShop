package org.online.myshopfirebase.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.*;
import android.widget.Toast;

import org.online.myshopfirebase.R;
import org.online.myshopfirebase.model.user;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private Spinner spinnerRole;
    private EditText nama;
    private EditText password;
    private EditText confirmPassword;
    private DatabaseReference database;
    private Button regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //INISIALISASI VIEW
        setContentView(R.layout.activity_register);
        //INISIALISASI BUTTON
        nama = (EditText) findViewById(R.id.textInputEditTextName);
        password = (EditText) findViewById(R.id.textInputEditTextPassword);
        confirmPassword = (EditText) findViewById(R.id.textInputEditTextConfirmPassword);
        spinnerRole = (Spinner) findViewById(R.id.listRoles);
        database = FirebaseDatabase.getInstance().getReference();
        regis = (Button) findViewById(R.id.appCompatButtonRegister);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmpty(nama.getText().toString()) && !isEmpty(password.getText().toString()) && !isEmpty(confirmPassword.getText().toString()) && !isEmpty(spinnerRole.getSelectedItem().toString())) {
                    submitUser(new user(nama.getText().toString(), password.getText().toString(), confirmPassword.getText().toString(), spinnerRole.getSelectedItem().toString()));

                } else {
                    Snackbar.make(findViewById(R.id.appCompatButtonRegister), "Data tidak boleh kosong", Snackbar.LENGTH_LONG).show();
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(
                            nama.getApplicationWindowToken(), 0);
                }
            }
        });
    }

    private void submitUser(user user) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("user").push().setValue(user).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                nama.setText("");
                password.setText("");
                confirmPassword.setText("");
                spinnerRole.getSelectedItem().toString();
                Snackbar.make(findViewById(R.id.appCompatButtonRegister), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private boolean isEmpty(String s) {
        return TextUtils.isEmpty(s);
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, RegisterActivity.class);
    }
}



