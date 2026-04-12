package com.vpt.bottomnavbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.w3c.dom.CDATASection;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab3Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rvContainer;

    public Tab3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab3Fragment newInstance(String param1, String param2) {
        Tab3Fragment fragment = new Tab3Fragment();
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
        return inflater.inflate(R.layout.fragment_tab3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvContainer = view.findViewById(R.id.rv_container);
        List<ColorData> colors = new ArrayList<>();
        colors.add(new ColorData(R.drawable.black, "Màu đen"));
        colors.add(new ColorData(R.drawable.blue, "Màu xanh dương"));
        colors.add(new ColorData(R.drawable.cyan, "Màu xanh cyan"));
        colors.add(new ColorData(R.drawable.brown, "Màu nâu"));
        colors.add(new ColorData(R.drawable.green, "Màu xanh lá"));
        colors.add(new ColorData(R.drawable.pink, "Màu hồng"));
        colors.add(new ColorData(R.drawable.purple, "Màu tím"));
        colors.add(new ColorData(R.drawable.red, "Màu đỏ"));
        colors.add(new ColorData(R.drawable.white, "Màu trắng"));
        colors.add(new ColorData(R.drawable.yellow, "Màu vàng"));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        ColorAdapter adapter = new ColorAdapter(getContext(), colors);
        rvContainer.setLayoutManager(layoutManager);
        rvContainer.setAdapter(adapter);
    }
}