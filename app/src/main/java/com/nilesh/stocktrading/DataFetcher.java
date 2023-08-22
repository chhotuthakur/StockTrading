package com.nilesh.stocktrading;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataFetcher {

    private Context context;

    public DataFetcher(Context context) {
        this.context = context;
    }

    public void fetchItems(Response.Listener<List<Item>> successListener, Response.ErrorListener errorListener) {


        String url =Api.FULL_DATA ; // Replace with your API URL

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {

                    List<Item> itemList = new ArrayList<>();
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            String symbol = jsonObject.getString("symbol");
                            String identifier = jsonObject.getString("identifier");
                            String open = jsonObject.getString("open");
                            String dayHigh = jsonObject.getString("dayHigh");
                            String dayLow = jsonObject.getString("dayLow");
                            String lastPrice = jsonObject.getString("lastPrice");
                            String previousClose = jsonObject.getString("previousClose");
                            String change = jsonObject.getString("change");
                            String pChange = jsonObject.getString("pChange");
                            String yearHigh = jsonObject.getString("yearHigh");
                            String yearLow = jsonObject.getString("yearLow");
                            String totalTradedVolume = jsonObject.getString("totalTradedVolume");
                            String totalTradedValue = jsonObject.getString("totalTradedValue");
                            String perChange365d = jsonObject.getString("perChange365d");
                            String perChange30d = jsonObject.getString("perChange30d");
                            //String dayHigh = jsonObject.getString("dayHigh");
                            itemList.add(new Item(symbol, identifier, open, dayHigh, dayLow, lastPrice, previousClose, change, pChange, yearHigh, yearLow, totalTradedVolume, totalTradedValue, perChange365d, perChange30d));


                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    successListener.onResponse(itemList);

                },
                error -> errorListener.onErrorResponse(error)
        );

        VolleySingleton.getInstance(context).addToRequestQueue(request);
    }


//    for show limited data

    public void fetchLimitedItems(Response.Listener<List<Item>> successListener, Response.ErrorListener errorListener) {


        String url =Api.FULL_DATA ; // Replace with your API URL
        int maxEntries = 4;

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {

                    List<Item> itemList = new ArrayList<>();
                    try {
                        for (int i = 0; i < Math.min(response.length(), maxEntries); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            String symbol = jsonObject.getString("symbol");
                            String identifier = jsonObject.getString("identifier");
                            String open = jsonObject.getString("open");
                            String dayHigh = jsonObject.getString("dayHigh");
                            String dayLow = jsonObject.getString("dayLow");
                            String lastPrice = jsonObject.getString("lastPrice");
                            String previousClose = jsonObject.getString("previousClose");
                            String change = jsonObject.getString("change");
                            String pChange = jsonObject.getString("pChange");
                            String yearHigh = jsonObject.getString("yearHigh");
                            String yearLow = jsonObject.getString("yearLow");
                            String totalTradedVolume = jsonObject.getString("totalTradedVolume");
                            String totalTradedValue = jsonObject.getString("totalTradedValue");
                            String perChange365d = jsonObject.getString("perChange365d");
                            String perChange30d = jsonObject.getString("perChange30d");
                            //String dayHigh = jsonObject.getString("dayHigh");
                            itemList.add(new Item(symbol, identifier, open, dayHigh, dayLow, lastPrice, previousClose, change, pChange, yearHigh, yearLow, totalTradedVolume, totalTradedValue, perChange365d, perChange30d));


                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    successListener.onResponse(itemList);

                },
                error -> errorListener.onErrorResponse(error)
        );

        VolleySingleton.getInstance(context).addToRequestQueue(request);
    }



}

