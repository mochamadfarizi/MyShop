package org.online.myshopfirebase.activity.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.online.myshopfirebase.model.Product;

import java.util.List;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ProductsViewHolder>{
    private List<Product> listProducts;
    private Context mContext;
    private AdapterView.OnItemClickListener mListener;

    public ProductsRecyclerAdapter(Context context, List<Product> listProducts) {
        this.listProducts = listProducts;
        mContext = context;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {
        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
