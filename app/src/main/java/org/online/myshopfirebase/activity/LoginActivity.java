package org.online.myshopfirebase.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.online.myshopfirebase.activity.RegisterActivity;
import org.online.myshopfirebase.R;

public class LoginActivity extends AppCompatActivity {
private TextView textViewLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textViewLink=(TextView)findViewById(R.id.textViewLinkRegister);
        textViewLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }

        });
    }
}