package com.nilesh.stocktrading.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nilesh.stocktrading.DataFetcher;
import com.nilesh.stocktrading.ItemAdapter;
import com.nilesh.stocktrading.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MarketWatchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarketWatchFragment extends Fragment {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;


    public MarketWatchFragment() {
        // Required empty public constructor
    }


    public static MarketWatchFragment newInstance(String param1, String param2) {
        MarketWatchFragment fragment = new MarketWatchFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_marketwatch, container, false);

        recyclerView = v.findViewById(R.id.list_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        itemAdapter = new ItemAdapter(new ArrayList<>()); // Initialize the adapter
        recyclerView.setAdapter(itemAdapter);

        fetchData();

        return v;
    }
    private void fetchData() {
        DataFetcher dataFetcher = new DataFetcher(requireContext());
        dataFetcher.fetchItems(
                itemList -> {
                    itemAdapter.setItems(itemList); // Update adapter data
                },
                error -> {
                    // Handle error
                });
    }
}