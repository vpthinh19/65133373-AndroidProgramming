package com.vpt.replacingdynamicfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FooterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FooterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Fragment pageOne, pageTwo, pageThree;
    private FragmentManager manager;
    Button btnFooter1, btnFooter2, btnFooter3;

    public FooterFragment() {
        pageOne = new PageOneFragment();
        pageTwo = new PageTwoFragment();
        pageThree = new PageThreeFragment();
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FooterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FooterFragment newInstance(String param1, String param2) {
        FooterFragment fragment = new FooterFragment();
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
        return inflater.inflate(R.layout.fragment_footer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        manager = getParentFragmentManager();
        btnFooter1 = view.findViewById(R.id.btnFooter1);
        btnFooter2 = view.findViewById(R.id.btnFooter2);
        btnFooter3 = view.findViewById(R.id.btnFooter3);
        btnFooter1.setOnClickListener(v->{
            manager.beginTransaction().replace(R.id.contentContainer, pageOne).commit();
        });
        btnFooter2.setOnClickListener(v->{
            manager.beginTransaction().add(R.id.contentContainer, pageTwo).commit();
        });
        btnFooter3.setOnClickListener(v->{
            manager.beginTransaction().add(R.id.contentContainer, pageThree).commit();
        });
    }
}