package project2.ds.project2.recyclerview;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import project2.ds.project2.Animal;
import project2.ds.project2.AnimalDetailActivity;
import project2.ds.project2.R;

import static android.R.attr.id;

/**
 * Created by ds on 11/5/16.
 */

public class AnimalsRecyclerViewAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    List<Animal> mAnimalList;


    public AnimalsRecyclerViewAdapter(List<Animal> objectList) {
        mAnimalList = objectList;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_view_holder, parent, false);
        AnimalViewHolder viewHolder = new AnimalViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AnimalViewHolder holder, final int position) {
        holder.getAnimalImage().setImageResource(mAnimalList.get(position).getAnimalImageId());
        holder.getAnimalName().setText("Name: " + mAnimalList.get(position).getAnimalName());
        holder.getAnimalCost().setText("Price: $" + Integer.toString(mAnimalList.get(position).getCost()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), AnimalDetailActivity.class);
                intent.putExtra(AnimalDetailActivity.ANIMAL_ID, mAnimalList.get(position).getId());

                holder.itemView.getContext().startActivity(intent);
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