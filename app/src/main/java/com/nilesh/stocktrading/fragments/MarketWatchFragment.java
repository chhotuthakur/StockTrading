package com.nilesh.stocktrading.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nilesh.stocktrading.DataFetcher;
import com.nilesh.stocktrading.Item;
import com.nilesh.stocktrading.ItemAdapter;
import com.nilesh.stocktrading.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MarketWatchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarketWatchFragment extends Fragment {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;

    private List<Item> allItems;
    private SearchView searchView;


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
        searchView = v.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterItems(newText);
                return true;
            }
        });

        allItems = new ArrayList<>();

        fetchData();

        return v;
    }
    private void fetchData() {
        DataFetcher dataFetcher = new DataFetcher(requireContext());
        dataFetcher.fetchItems(
                itemList -> {
                    allItems = itemList;
                    itemAdapter.setItems(itemList); // Update adapter data
                },
                error -> {
                    // Handle error
                });
    }
    private void filterItems(String query) {
        List<Item> filteredItems = new ArrayList<>();
        for (Item item : allItems) {
            if (item.getSymbol().toLowerCase().contains(query.toLowerCase())) {
                filteredItems.add(item);
            }
        }
        itemAdapter.setItems(filteredItems);
    }
}