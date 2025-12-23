package com.example.uas_pab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentKeahlian extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewFragmentKeahlian = inflater.inflate(R.layout.fragment_keahlian, container, false);
        return viewFragmentKeahlian;
    }
}
