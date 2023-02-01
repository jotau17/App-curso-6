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
import com.nallam.carritoApp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.iHaveAccoutnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_to_login);
            }
        });

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context ctx = getContext();
                ModeloUsuarios usuarios = new ModeloUsuarios();
                UsuariosDTO usuario = new UsuariosDTO();
                usuario.setId(Integer.parseInt(String.valueOf(binding.signupId.getText().toString())));
                usuario.setNombre(binding.signupName.getText().toString());
                usuario.setEmail(binding.signupEmail.getText().toString());
                usuario.setPassword(binding.signupPassword.getText().toString());

                int consulta = usuarios.insertaUsuario(ctx, usuario);

                if (consulta == 1) {
                    Toast.makeText(ctx, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();

                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_to_login);
                } else
                    Toast.makeText(ctx, "Hubo un error al crear la cuenta", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}