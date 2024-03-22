package com.example.parcial1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    private EditText pt1, pt2;
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn1 = findViewById(R.id.btn1);
        pt1 = findViewById(R.id.pt1);
        pt2 = findViewById(R.id.pt2);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 =pt1.getText().toString();
                String v2 =pt2.getText().toString();

                if (v1.equals("") && v2.equals("")) {
                    Toast.makeText(Login.this, "Tiene que llenar los campos", Toast.LENGTH_LONG).show();
                }else if (v1.equals("uac123") && v2.equals("12345678")) {
                    Intent intent = new Intent(Login.this,Resultado.class);
                    startActivity(intent);
                    Toast.makeText(Login.this, "Ingresando sesion", Toast.LENGTH_LONG).show();
                } if (!v1.equals("uac123") ) {
                    Toast.makeText(Login.this, "Usuario equivocado", Toast.LENGTH_LONG).show();
                }else if (!v2.equals("12345678")) {
                    Toast.makeText(Login.this, "Contraseña equivocada", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}