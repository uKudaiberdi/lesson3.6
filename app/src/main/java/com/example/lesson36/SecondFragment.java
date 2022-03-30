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

public class SecondFragment extends Fragment implements onClick{

    private ArrayList<Model> data;
    private MainAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        recyclerView = view.findViewById(R.id.recycler);
        adapter = new MainAdapter(data, this::onClick);
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        data = new ArrayList<>();
        Bundle bundle = getArguments();
        Integer integer = bundle.getInt(getString(R.string.keyId));
        switch (integer) {
            case 1 :
                data.add(new Model(R.drawable.brazilia, "бразилия"));
                data.add(new Model(R.drawable.pery, "перу"));
                data.add(new Model(R.drawable.argentina, "аргентина"));
                data.add(new Model(R.drawable.columbia, "колумбия"));
                data.add(new Model(R.drawable.uyrugvai, "уругвай"));
                break;
            case 2:
                data.add(new Model(R.drawable.nigeria, "нигерия"));
                data.add(new Model(R.drawable.mali, "мали"));
                data.add(new Model(R.drawable.maroko, "мароко"));
                data.add(new Model(R.drawable.madagaskar, "мадагаскар"));
                data.add(new Model(R.drawable.somali, "сомали"));
                break;
            case 3:
                data.add(new Model(R.drawable.auvstralia, "австралия"));
                break;
            case 4:
                data.add(new Model(R.drawable.canada, "канада"));
                data.add(new Model(R.drawable.lcia, "люсия"));
                data.add(new Model(R.drawable.constra, "бисау"));
                data.add(new Model(R.drawable.trinad, "КотДивиуар"));
                data.add(new Model(R.drawable.nikaragya, "никарагуа"));
                break;
            case 5:
                data.add(new Model(R.drawable.kyrgizstan, "кыргызстан"));
                data.add(new Model(R.drawable.korea, "корея"));
                data.add(new Model(R.drawable.babgladesh, "бангладеш"));
                data.add(new Model(R.drawable.japan, "япония"));
                data.add(new Model(R.drawable.china, "китай"));


        }
    }

    @Override
    public void onClick(Model model) {

    }
}