package com.example.ex2aviramavivi;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int imageID;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;


    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, int image) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        //args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, image);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        ImageView imageView = view.findViewById(R.id.imageViewDetail);
        TextView textView = view.findViewById(R.id.textViewDetail);

        imageView.setImageResource(mParam2);
        textView.setText(mParam1);



        return view;
    }
}