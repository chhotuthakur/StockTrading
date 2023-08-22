package com.nilesh.stocktrading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public void setItems(List<Item> items) {
        itemList = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView symbolTextView, identifierTextView, openTextView, dayHighTextView, dayLowTextView,
                lastPriceTextView, previousCloseTextView, changeTextView, pChangeTextView,
                yearHighTextView, yearLowTextView, totalTradedVolumeTextView, totalTradedValueTextView,
                perChange365dTextView, perChange30dTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            symbolTextView = itemView.findViewById(R.id.symbolTextView);
            identifierTextView = itemView.findViewById(R.id.identifierTextView);
            openTextView = itemView.findViewById(R.id.openTextView);
            dayHighTextView = itemView.findViewById(R.id.dayHighTextView);
            dayLowTextView = itemView.findViewById(R.id.dayLowTextView);
            lastPriceTextView = itemView.findViewById(R.id.lastPriceTextView);
            previousCloseTextView = itemView.findViewById(R.id.previousCloseTextView);
            changeTextView = itemView.findViewById(R.id.changeTextView);
            pChangeTextView = itemView.findViewById(R.id.pChangeTextView);
            yearHighTextView = itemView.findViewById(R.id.yearHighTextView);
            yearLowTextView = itemView.findViewById(R.id.yearLowTextView);
            totalTradedVolumeTextView = itemView.findViewById(R.id.totalTradedVolumeTextView);
            totalTradedValueTextView = itemView.findViewById(R.id.totalTradedValueTextView);
            perChange365dTextView = itemView.findViewById(R.id.perChange365dTextView);
            perChange30dTextView = itemView.findViewById(R.id.perChange30dTextView);
        }

        public void bind(Item item) {
            symbolTextView.setText(item.getSymbol());
            identifierTextView.setText(item.getIdentifier());
            openTextView.setText(item.getOpen());
            dayHighTextView.setText(item.getDayHigh());
            dayLowTextView.setText(item.getDayLow());
            // Bind other data fields
            lastPriceTextView.setText(item.getLastPrice());
            previousCloseTextView.setText(item.getPreviousClose());
            changeTextView.setText(item.getChange());
            pChangeTextView.setText(item.getPChange());
            yearHighTextView.setText(item.getYearHigh());
            yearLowTextView.setText(item.getYearLow());
            totalTradedVolumeTextView.setText(item.getTotalTradedVolume());
            totalTradedValueTextView.setText(item.getTotalTradedValue());
            perChange365dTextView.setText(item.getPerChange365d());
            perChange30dTextView.setText(item.getPerChange30d());

        }
    }
}
