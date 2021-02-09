package com.example.safealert;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class resetPassword extends AppCompatActivity {

    Button btn_reset,btn_login;
    EditText enter_email;
    String myEmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String my_Email;
    int myPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        btn_reset = (Button) findViewById(R.id.btnPasswordReset);
        enter_email = (EditText)findViewById(R.id.enterEmail);
        btn_login = findViewById(R.id.btnLogin);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_Email = enter_email.getText().toString();
                if(my_Email.isEmpty()) {
                    openDialog();
                }
                else if(!my_Email.matches(myEmailPattern)) {
                    dialog1();
                }
                else {
                    String str = "abcdefghijklmnopqrstuvwxyz";
                    StringBuilder sb = new StringBuilder();
                    Random r = new Random();
                    int a = r.nextInt(999);
                    String l = String.format("%03d",a);
                    //generate password
                    for(int j=0;j<3;j++) {
                        int myPass = r.nextInt(str.length());
                        char rc = str.charAt(myPass);
                        sb.append(rc);
                    }
                    sb.append(l);
                    TextView tx = (TextView)findViewById(R.id.myPassword);
                    tx.setText(sb);
                }
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt = new Intent(resetPassword.this,validation.class);
                startActivity(intnt);
            }
        });
    }

    public void openDialog() {
        dialogbox db = new dialogbox();
        db.show(getSupportFragmentManager(),"Dialog Box");
    }
    public void dialog1() {
        dialogbox1 db1 = new dialogbox1();
        db1.show(getSupportFragmentManager(),"Dialog Box 1");
    }
}