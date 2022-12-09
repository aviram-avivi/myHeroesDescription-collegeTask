package com.example.ex2aviramavivi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class recycleView extends Fragment implements CustomAdapter.ItemClickListener {

    private ArrayList<DataModel> dataSet = new ArrayList<>();

    public recycleView() {
        // Required empty public constructor
    }

    public static recycleView newInstance() {
        recycleView fragment = new recycleView();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recycle_view, container, false);
        buildDataSet();
        initRecycleView(view);
        return view;
    }

    private void initRecycleView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.my_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        CustomAdapter adapter = new CustomAdapter(dataSet, this);
        recyclerView.setAdapter(adapter);
    }

    private void buildDataSet(){
        for (int i=0; i < MyData.heroName.length; i++)
        {
            dataSet.add(new DataModel(
                    MyData.heroName[i],
                    MyData.description[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }
    }

    @Override
    public void onItemClick(DataModel dataModel) {
        Fragment fragment = DetailFragment.newInstance(dataModel.getDescription(), dataModel.getImage());

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("recycleView"));
        fragmentTransaction.add(R.id.fragmentContainerView, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}