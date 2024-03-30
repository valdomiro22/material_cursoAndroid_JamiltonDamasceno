package com.santos.valdomiro.utilizandofragments.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.santos.valdomiro.utilizandofragments.R;

public class ContatosFragment extends Fragment {

    private TextView txtContatos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_contatos, container, false);
        View view =  inflater.inflate(R.layout.fragment_contatos, container, false);

        txtContatos = view.findViewById(R.id.txtContatos);
        txtContatos.setText("Contatos alterados");

        return view;

    }
}