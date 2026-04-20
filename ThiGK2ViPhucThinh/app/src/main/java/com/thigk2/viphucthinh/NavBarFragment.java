package com.thigk2.viphucthinh;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NavBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavBarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Fragment homeFragment, tab1Fragment, tab2Fragment, tab3Fragment, tab4Fragment;
    private FragmentManager fragmentManager;
    private BottomNavigationView botNavBar;

    public NavBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NavBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NavBarFragment newInstance(String param1, String param2) {
        NavBarFragment fragment = new NavBarFragment();
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
        return inflater.inflate(R.layout.fragment_nav_bar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentManager = getParentFragmentManager();
        botNavBar = view.findViewById(R.id.navbar);
        botNavBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                int itemId = menuItem.getItemId();
                if (itemId == R.id.mi_tab1){
                    selectedFragment = tab1Fragment;
                } else if (itemId == R.id.mi_tab2) {
                    selectedFragment = tab2Fragment;
                } else if (itemId == R.id.mi_tab3) {
                    selectedFragment = tab3Fragment;
                } else if (itemId == R.id.mi_tab4) {
                    selectedFragment = tab4Fragment;
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.content_container, selectedFragment)
                        .commit();
                return true;
            }
        });
    }
}