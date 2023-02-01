package com.nallam.carritoApp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import com.nallam.carritoApp.Clases.UsuariosDTO;


public class LoginActivity extends AppCompatActivity {

    EditText EditTextEmail;
    Button loginBtn;
    Button registerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Validacion de direccion de email corecta
        loginBtn = (Button) findViewById(R.id.login_btn);
        EditTextEmail = (EditText) findViewById(R.id.userEmail);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String compruebaemail = EditTextEmail.getEditableText().toString();

                final String regex = "(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*|\"[^\\n\"]+\")@(?:[^<>()\\[\\].,;:\\s@\"]+\\.)+[^<>()\\[\\]\\.,;:\\s@\"]{2,63}";

                /*if (!compruebaemail.matches(regex))
                {
                    Toast.makeText(LoginActivity.this, "El email introducido no es válido", Toast.LENGTH_LONG).show();
                    return;
                }*/

                EditText usrInputPassword = findViewById(R.id.userPassword);
                EditText usrInputEmail = findViewById(R.id.userEmail);

                UsuariosDTO usuario = new UsuariosDTO();
                usuario.setEmail(usrInputEmail.getText().toString());
                usuario.setPassword(usrInputPassword.getText().toString());
                ModeloUsuarios usr = new ModeloUsuarios();
                int res = usr.consultaUsuario(LoginActivity.this, usuario);
                if (res != 1000) {
                    Toast.makeText(LoginActivity.this, "Logueado con éxito", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, Content.class);
                    startActivity(i);
                } else
                    Toast.makeText(LoginActivity.this, "Error en las credenciales", Toast.LENGTH_SHORT).show();



            }
        });

        registerBtn = findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });


    }

}