package com.example.individual17m4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.individual17m4.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements PasarElemento {

    private FragmentFirstBinding binding;
    private List<String>dataList=new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList.add("Palabra "+ dataList.size());
                binding.recyclerView.getAdapter().notifyItemInserted(dataList.size());
                binding.recyclerView.smoothScrollToPosition(dataList.size());
            }
        });

        return binding.getRoot();

    }

    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WordListAdapter adapter= new WordListAdapter(getContext(),setData(),this);

        //WordListAdapter adapter=new WordListAdapter(getContext(),dataList,this);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setHasFixedSize(true);


        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });


    }

    private List<String>setData() {
        for (int i= 0;i<99;i++){
            dataList.add("Palabra "+i);
        }
        return dataList;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void pasarelemento(String element) {

    }


    //@Override
    //public void pasarelemento(String element) {
        //Toast.makeText(getContext(),element,Toast.LENGTH_SHORT).show();

    //}
}