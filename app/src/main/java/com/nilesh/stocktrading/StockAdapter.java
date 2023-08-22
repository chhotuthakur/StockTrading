//package com.nilesh.stocktrading;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class StockAdapter extends RecyclerView.Adapter<StockAdapter.ViewHolder> {
//    public StockAdapter(Context context, List<StockDetailsModel> stocks) {
//        super();
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//
//        TextView symbolTextView, identifierTextView, openTextView, dayHighTextView, dayLowTextView,
//                lastPriceTextView, previousCloseTextView, changeTextView, pChangeTextView,
//                yearHighTextView, yearLowTextView, totalTradedVolumeTextView, totalTradedValueTextView,
//                perChange365dTextView, perChange30dTextView;
//
//        if (convertView == null) {
//            convertView = View.inflate(convertView.getContext(), R.layout.custom_grid1, null);
//        }
//
//        StockDetailsModel stock = new StockDetailsModel(position);
//
//        symbolTextView = convertView.findViewById(R.id.symbolTextView);
//        identifierTextView = convertview.findViewById(R.id.identifierTextView);
//        openTextView = convertview.findViewById(R.id.openTextView);
//        dayHighTextView = convertview.findViewById(R.id.dayHighTextView);
//        dayLowTextView = convertview.findViewById(R.id.dayLowTextView);
//        lastPriceTextView = convertview.findViewById(R.id.lastPriceTextView);
//        previousCloseTextView = convertview.findViewById(R.id.previousCloseTextView);
//
//        // Initialize other TextViews as needed
//
//        // For strings after "Previous Close"
//        changeTextView = convertview.findViewById(R.id.changeTextView);
//        pChangeTextView = convertview.findViewById(R.id.pChangeTextView);
//        yearHighTextView = convertview.findViewById(R.id.yearHighTextView);
//        yearLowTextView = convertview.findViewById(R.id.yearLowTextView);
//        totalTradedVolumeTextView = convertview.findViewById(R.id.totalTradedVolumeTextView);
//        totalTradedValueTextView = convertview.findViewById(R.id.totalTradedValueTextView);
//        perChange365dTextView = convertview.findViewById(R.id.perChange365dTextView);
//        perChange30dTextView = convertview.findViewById(R.id.perChange30dTextView);
//
//        StockDetailsModel stockDetails = stockDetailsList.get(position);
//
//        holder.symbolTextView.setText(stockDetails.getSymbol());
//        holder.identifierTextView.setText(stockDetails.getIdentifier());
//        holder.openTextView.setText(stockDetails.getOpen());
//        holder.dayHighTextView.setText(stockDetails.getDayHigh());
//        holder.dayLowTextView.setText(stockDetails.getDayLow());
//        holder.lastPriceTextView.setText(stockDetails.getLastPrice());
//        holder.previousCloseTextView.setText(stockDetails.getPreviousClose());
//
//        // Set other data as needed
//
//        // For strings after "Previous Close"
//        holder.changeTextView.setText(stockDetails.getChange());
//        holder.pChangeTextView.setText(stockDetails.getPChange());
//        holder.yearHighTextView.setText(stockDetails.getYearHigh());
//        holder.yearLowTextView.setText(stockDetails.getYearLow());
//        holder.totalTradedVolumeTextView.setText(stockDetails.getTotalTradedVolume());
//        holder.totalTradedValueTextView.setText(stockDetails.getTotalTradedValue());
//        holder.perChange365dTextView.setText(stockDetails.getPerChange365d());
//        holder.perChange30dTextView.setText(stockDetails.getPerChange30d());
//        notifyDataSetChanged();
//
//        return convertView;
//    }
//}