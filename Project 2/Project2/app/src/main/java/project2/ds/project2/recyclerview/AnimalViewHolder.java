package project2.ds.project2.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import project2.ds.project2.R;

/**
 * Created by ds on 11/5/16.
 */

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView mAnimalImage;
    private TextView mAnimalName;
    private TextView mAnimalCost;

    public ImageView getAnimalImage() {
        return mAnimalImage;
    }

    public TextView getAnimalName() {
        return mAnimalName;
    }

    public TextView getAnimalCost() {
        return mAnimalCost;
    }

    public AnimalViewHolder(View itemView) {
        super(itemView);

        mAnimalImage = (ImageView) itemView.findViewById(R.id.animal_image);
        mAnimalName = (TextView) itemView.findViewById(R.id.name);
        mAnimalCost = (TextView) itemView.findViewById(R.id.cost);

    }
}
