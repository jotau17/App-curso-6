package com.nallam.carritoApp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.nallam.carritoApp.Clases.UsuariosDTO;
import com.nallam.carritoApp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_login_to_register);
            }
        });
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String compruebaemail = binding.userEmail.getText().toString();

                final String regex = "(?:[^<>()\\[\\].,;:\\s@\"]+(?:\\.[^<>()\\[\\].,;:\\s@\"]+)*|\"[^\\n\"]+\")@(?:[^<>()\\[\\].,;:\\s@\"]+\\.)+[^<>()\\[\\]\\.,;:\\s@\"]{2,63}";

                if (!compruebaemail.matches(regex))
                {
                    Toast.makeText(getContext(), "El email introducido no es válido", Toast.LENGTH_LONG).show();
                    return;
                }

                UsuariosDTO usuario = new UsuariosDTO();
                usuario.setEmail(binding.userEmail.getText().toString());
                usuario.setPassword(binding.userPassword.getText().toString());
                ModeloUsuarios usr = new ModeloUsuarios();
                Context ctx = getContext();
                int res = usr.consultaUsuario(ctx, usuario);
                if (res == 1) {
                    Toast.makeText(ctx, "Logueado con éxito", Toast.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_to_content_menu);
                } else
                    Toast.makeText(ctx, "Error en las credenciales", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}