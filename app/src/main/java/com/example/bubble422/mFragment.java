package com.example.bubble422;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class mFragment extends Fragment {
    int i = 0;
    mFragment(int i){

        this.i = i;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        switch (i){
            case 0: {
                view = inflater.inflate(R.layout.fragment_guide1, container, false);
                break;
            }
            case 1: {
                view =  inflater.inflate(R.layout.fragment_guide2, container, false);
                break;
            }
            case 2: {
                view = inflater.inflate(R.layout.fragment_guide3, container, false);
                break;
            }
        }
        return view;
    }
}

