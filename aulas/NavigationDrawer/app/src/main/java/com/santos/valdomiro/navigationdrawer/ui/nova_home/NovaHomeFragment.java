package com.santos.valdomiro.navigationdrawer.ui.nova_home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santos.valdomiro.navigationdrawer.R;

public class NovaHomeFragment extends Fragment {

    private NovaHomeViewModel mViewModel;

    public static NovaHomeFragment newInstance() {
        return new NovaHomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nova_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NovaHomeViewModel.class);
        // TODO: Use the ViewModel
    }

}