package org.online.myshopfirebase.activity.seller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.online.myshopfirebase.R;
import org.online.myshopfirebase.activity.AddProductActivity;
import org.online.myshopfirebase.activity.LoginActivity;
import org.online.myshopfirebase.model.Product;

import java.util.List;

public class SellerHomeActivity extends AppCompatActivity implements View.OnClickListener{
    private final AppCompatActivity activity = SellerHomeActivity.this;

    private RecyclerView recyclerViewProducts;
    private TextView TextViewButton;
    private List<Product> listProducts;

    private DatabaseReference mDatabase;
    private Button ButtonAddProduct, ButtonRefreshProduct, ButtonBuyerCart, ButtonLogout;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);
        mDatabase= FirebaseDatabase.getInstance().getReference();
        initView();
        initListeners();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ButtonAddProduct:
                startActivity(new Intent(SellerHomeActivity.this, AddProductActivity.class));
                break;
            case R.id.ButtonRefreshProduct:
                getDataFromFirebase();
                break;
            case R.id.ButtonBuyerCart:
                startActivity(new Intent(SellerHomeActivity.this, CartActivitySeller.class));
                break;
            case R.id.ButtonLogout:
                finish();
                break;

        }
    }
    private void initView(){
    recyclerViewProducts = (RecyclerView) findViewById(R.id.recyclerViewProducts);
    ButtonAddProduct = (Button)findViewById(R.id.ButtonAddProduct);
    ButtonRefreshProduct = (Button)findViewById(R.id.ButtonRefreshProduct);
    ButtonBuyerCart = (Button)findViewById(R.id.ButtonBuyerCart);
    ButtonLogout = (Button)findViewById(R.id.ButtonLogout);
    }
    private void initListeners() {
        ButtonAddProduct.setOnClickListener(this);
        ButtonRefreshProduct.setOnClickListener(this);
        ButtonBuyerCart.setOnClickListener(this);
        ButtonLogout.setOnClickListener(this);
    }

    private void getDataFromFirebase() {
    }
}

