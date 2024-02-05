package minjaelab.sketchbook.app1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import minjaelab.sketchbook.R;

public class FragmentA extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
        // reading a xml file, and arranging them happens here. so you usually don't connect views to the field instances here.
        // you do that in onViewCreated, when view hierarchy stuff is fully finished.
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
