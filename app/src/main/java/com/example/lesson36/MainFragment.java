package com.example.lesson36;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainFragment extends Fragment implements onClick {
    private MainAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Model> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        recyclerView = view.findViewById(R.id.recycler_View);
        adapter = new MainAdapter(data, this::onClick);
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        data = new ArrayList<>();
        data.add(new Model(R.drawable.america, "Южная Америка"));
        data.add(new Model(R.drawable.caf, "Африка"));
        data.add(new Model(R.drawable.avstralia, "Австралия"));
        data.add(new Model(R.drawable.america1, "Северня Америка"));
        data.add(new Model(R.drawable.azia, "Азия"));


    }

    @Override
    public void onClick(Model model) {
        Bundle bundle = new Bundle();
        bundle.putString(getString(R.string.keyId), model.getKeyId());
        Fragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();

    }
}