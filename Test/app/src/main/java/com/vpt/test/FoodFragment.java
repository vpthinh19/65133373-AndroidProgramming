package com.vpt.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView foodRvContainer;

    public FoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodFragment newInstance(String param1, String param2) {
        FoodFragment fragment = new FoodFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        foodRvContainer = view.findViewById(R.id.food_rv_container);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        List<FoodData> datas = new ArrayList<>();
        datas.add(new FoodData(R.drawable.cropped_com_ga, "Com ga", "Com ga", "25000"));
        datas.add(new FoodData(R.drawable.cropped_com_muoi_e, "Com muoi e", "Com muoi e", "25000"));
        datas.add(new FoodData(R.drawable.cropped_com_suon_bi_cha, "Com sbc", "Com sbc", "25000"));
        datas.add(new FoodData(R.drawable.cropped_com_vit, "Com vit", "Com vit", "25000"));
        datas.add(new FoodData(R.drawable.cropped_com_suon_trung, "Com st", "Com st", "25000"));
        datas.add(new FoodData(R.drawable.cropped_com_thit_kho, "Com thit kho", "Com thit kho", "25000"));
        FoodAdapter adapter = new FoodAdapter(getContext(), datas);
        foodRvContainer.setLayoutManager(layoutManager);
        foodRvContainer.setAdapter(adapter);
    }
}