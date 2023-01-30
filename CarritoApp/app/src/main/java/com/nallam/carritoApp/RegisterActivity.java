package com.nallam.carritoApp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nallam.carritoApp.Clases.UsuariosDTO;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegistro = findViewById(R.id.signup_btn);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText usrInputName = findViewById(R.id.signup_name);
                EditText usrInputPassword = findViewById(R.id.signup_password);
                EditText usrInputEmail = findViewById(R.id.signup_email);
                EditText usrInputDNI = findViewById(R.id.signup_id);

                ModeloUsuarios usuarios = new ModeloUsuarios();
                UsuariosDTO usuario = new UsuariosDTO();
                usuario.setId(Integer.parseInt(String.valueOf(usrInputDNI.getText())));
                usuario.setNombre(usrInputName.getText().toString());
                usuario.setEmail(usrInputEmail.getText().toString());
                usuario.setPassword(usrInputPassword.getText().toString());

                int consulta = usuarios.insertaUsuario(RegisterActivity.this, usuario);

                if (consulta == 1) {
                    Toast.makeText(RegisterActivity.this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(RegisterActivity.this, "Hubo un error al crear la cuenta", Toast.LENGTH_SHORT).show();
            }
        });
    }
}