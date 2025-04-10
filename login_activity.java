package com.example.onlinevoting; 
 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.Toast; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class LoginActivity extends AppCompatActivity { 
    private EditText etUsername, etPassword; 
    private Button btnLogin; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_login); 
 
        etUsername = findViewById(R.id.et_username); 
        etPassword = findViewById(R.id.et_password); 
        btnLogin = findViewById(R.id.btn_login); 
 
        btnLogin.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                String username = etUsername.getText().toString().trim(); 
                String password = etPassword.getText().toString().trim(); 
 
                if (username.equals("user") && password.equals("1234")) { 
                    Intent intent = new Intent(LoginActivity.this, VoteActivity.class); 
                    startActivity(intent); 
                } else { 
                    Toast.makeText(LoginActivity.this, "Invalid credentials!", 
Toast.LENGTH_SHORT).show(); 
                } 
            } 
        }); 
    } 
} 