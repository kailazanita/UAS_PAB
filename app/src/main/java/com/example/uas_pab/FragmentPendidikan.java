package com.example.uas_pab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentPendidikan extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewFragmentPendidikan = inflater.inflate(R.layout.fragment_pendidikan, container, false);
        return viewFragmentPendidikan;
    }
}
