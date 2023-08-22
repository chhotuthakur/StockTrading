package com.nilesh.stocktrading.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nilesh.stocktrading.DataFetcher;
import com.nilesh.stocktrading.HomeAdapter;
import com.nilesh.stocktrading.Item;
import com.nilesh.stocktrading.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private HorizontalScrollView horizontalScrollView;
    private TextView tickerText;
    private String apiData = ""; // Your API data here

    private ArrayList<Item> tickerItemList = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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
        View rootview= inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootview.findViewById(R.id.indicesview);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        homeAdapter = new HomeAdapter(new ArrayList<>()); // Initialize the adapter
        recyclerView.setAdapter(homeAdapter);

        fetchData();

        horizontalScrollView = rootview.findViewById(R.id.horizontalScrollView);
        tickerText = rootview.findViewById(R.id.tickerText);
        tickerText.setText(apiData);

        // Scroll the ticker text horizontally
        horizontalScrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                startScrollAnimation();
            }
        }, 1000); // Delay the start of scrolling for 1 second



        return rootview;
    }

    private void fetchData() {
        DataFetcher dataFetcher = new DataFetcher(requireContext());
        dataFetcher.fetchLimitedItems(
                itemList -> {

                    tickerItemList.clear(); // Clear existing data
                    tickerItemList.addAll(itemList); // Add new data
                    homeAdapter.setItems(itemList); // Update adapter data
                },
                error -> {
                    // Handle error
                });
    }

    private void updateTickerText() {
        StringBuilder tickerTextBuilder = new StringBuilder();
        for (Item item : tickerItemList) {
            tickerTextBuilder.append(item.getSymbol()).append("  •  "); // Separate items with dots
        }
        String finalTickerText = tickerTextBuilder.toString();

        tickerText.setText(finalTickerText);
        tickerText.measure(0, 0); // Measure the TextView to get its width
        startScrollAnimation();
    }

    private void startScrollAnimation() {
        // Calculate the total width of the ticker content
        int contentWidth = tickerText.getMeasuredWidth();

        // Set the initial position off-screen to the right
        tickerText.setTranslationX(horizontalScrollView.getMeasuredWidth());

        // Calculate the duration for scrolling based on content width
        int scrollDuration = contentWidth * 20; // Adjust as needed

        // Animate the scrolling effect
        tickerText.animate()
                .translationX(-contentWidth)
                .setDuration(scrollDuration)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        // Reset position and restart animation
                        tickerText.setTranslationX(horizontalScrollView.getMeasuredWidth());
                        startScrollAnimation();
                    }
                })
                .start();
    }

}