package com.santos.valdomiro.navigationdrawer.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santos.valdomiro.navigationdrawer.R;

public class NovaSlideshowFragment extends Fragment {

    private NovaSlideshowViewModel mViewModel;

    public static NovaSlideshowFragment newInstance() {
        return new NovaSlideshowFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nova_slideshow, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NovaSlideshowViewModel.class);
        // TODO: Use the ViewModel
    }

}