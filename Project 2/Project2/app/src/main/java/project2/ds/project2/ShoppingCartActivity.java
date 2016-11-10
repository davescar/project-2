package project2.ds.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import project2.ds.project2.database.DbHelper;
import project2.ds.project2.recyclerview.AnimalsRecyclerViewAdapter;
import project2.ds.project2.recyclerview.ShoppingCartRecyclerAdapter;

public class ShoppingCartActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ShoppingCartRecyclerAdapter mShoppingCartRecyclerAdapter;
    Button mCheckoutButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.shopping_cart_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        mShoppingCartRecyclerAdapter = new ShoppingCartRecyclerAdapter(ShoppingCart.getInstance().getAnimals());
        recyclerView.setAdapter(mShoppingCartRecyclerAdapter);

        mCheckoutButton = (Button) findViewById(R.id.checkout);
        mCheckoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingCart.getInstance().getAnimals().clear();
                mShoppingCartRecyclerAdapter.notifyDataSetChanged();
                Toast.makeText(ShoppingCartActivity.this, "Your pet is on its way!", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
