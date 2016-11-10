package project2.ds.project2.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import project2.ds.project2.Animal;
import project2.ds.project2.AnimalDetailActivity;
import project2.ds.project2.R;
import project2.ds.project2.ShoppingCart;
import project2.ds.project2.ShoppingCartActivity;

import static android.R.attr.contextClickable;
import static android.R.attr.id;

/**
 * Created by ds on 11/5/16.
 */

public class ShoppingCartRecyclerAdapter extends RecyclerView.Adapter<ShoppingCartViewHolder> {

    List<Animal> mAnimalList;


    public ShoppingCartRecyclerAdapter(List<Animal> objectList) {
        mAnimalList = objectList;
    }

    @Override
    public ShoppingCartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_cart_view_holder, parent, false);
        ShoppingCartViewHolder viewHolder = new ShoppingCartViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ShoppingCartViewHolder holder, final int position) {
        holder.getAnimalImage().setImageResource(mAnimalList.get(position).getAnimalImageId());
        holder.getAnimalName().setText(mAnimalList.get(position).getAnimalName());
        holder.getAnimalCost().setText("Price: $" + Integer.toString(mAnimalList.get(position).getCost()));


        holder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {mAnimalList.remove(position);

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }

    public void replaceData(List<Animal> animalList) {
        mAnimalList = animalList;
        notifyDataSetChanged();
    }
}