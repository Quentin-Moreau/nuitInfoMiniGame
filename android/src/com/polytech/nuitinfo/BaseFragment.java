package com.polytech.nuitinfo;

import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Howard Alexandre on 20/03/2017.
 */

public class BaseFragment extends Fragment {
    public BaseFragment(){
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_accueil,container,false);
    }
}
