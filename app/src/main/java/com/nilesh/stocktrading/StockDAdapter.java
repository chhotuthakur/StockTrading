//package com.nilesh.stocktrading;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class StockDAdapter extends RecyclerView.Adapter<StockDAdapter.ViewHolder>{
//
//    private List<StockDetailsModel> itemList = new ArrayList<>();
//
//    public void setItems(List<StockDetailsModel> items) {
//        itemList = items;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        StockDetailsModel item = itemList.get(position);
//       bind(item);
//    }
//
//    @Override
//    public int getItemCount() {
//        return itemList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        TextView symbolTextView, identifierTextView, openTextView, dayHighTextView, dayLowTextView,
//                lastPriceTextView, previousCloseTextView, changeTextView, pChangeTextView,
//                yearHighTextView, yearLowTextView, totalTradedVolumeTextView, totalTradedValueTextView,
//                perChange365dTextView, perChange30dTextView;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            symbolTextView = itemView.findViewById(R.id.symbolTextView);
//            identifierTextView = itemView.findViewById(R.id.identifierTextView);
//            openTextView = itemView.findViewById(R.id.openTextView);
//            dayHighTextView = itemView.findViewById(R.id.dayHighTextView);
//            dayLowTextView = itemView.findViewById(R.id.dayLowTextView);
//            lastPriceTextView = itemView.findViewById(R.id.lastPriceTextView);
//            previousCloseTextView = itemView.findViewById(R.id.previousCloseTextView);
//
//            // Initialize other TextViews as needed
//
//            // For strings after "Previous Close"
//            changeTextView = itemView.findViewById(R.id.changeTextView);
//            pChangeTextView = itemView.findViewById(R.id.pChangeTextView);
//            yearHighTextView = itemView.findViewById(R.id.yearHighTextView);
//            yearLowTextView = itemView.findViewById(R.id.yearLowTextView);
//            totalTradedVolumeTextView = itemView.findViewById(R.id.totalTradedVolumeTextView);
//            totalTradedValueTextView = itemView.findViewById(R.id.totalTradedValueTextView);
//            perChange365dTextView = itemView.findViewById(R.id.perChange365dTextView);
//            perChange30dTextView = itemView.findViewById(R.id.perChange30dTextView);
//        }
//
//        public void bind(StockDetailsModel item) {
//           symbolTextView.setText(StockDetailsModel.getSymbol());
//           identifierTextView.setText(StockDetailsModel.getIdentifier());
//           openTextView.setText(StockDetailsModel.getOpen());
//           dayHighTextView.setText(StockDetailsModel.getDayHigh());
//           dayLowTextView.setText(StockDetailsModel.getDayLow());
//           lastPriceTextView.setText(StockDetailsModel.getLastPrice());
//           previousCloseTextView.setText(StockDetailsModel.getPreviousClose());
//
//            // Set other data as needed
//
//            // For strings after "Previous Close"
//           changeTextView.setText(StockDetailsModel.getChange());
//           pChangeTextView.setText(StockDetailsModel.getPChange());
//           yearHighTextView.setText(StockDetailsModel.getYearHigh());
//           yearLowTextView.setText(StockDetailsModel.getYearLow());
//           totalTradedVolumeTextView.setText(StockDetailsModel.getTotalTradedVolume());
//           totalTradedValueTextView.setText(StockDetailsModel.getTotalTradedValue());
//           perChange365dTextView.setText(StockDetailsModel.getPerChange365d());
//           perChange30dTextView.setText(StockDetailsModel.getPerChange30d());
//            notifyDataSetChanged();
//        }
//    }
//}
