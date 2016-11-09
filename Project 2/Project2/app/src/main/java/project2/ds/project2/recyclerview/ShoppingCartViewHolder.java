package project2.ds.project2.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import project2.ds.project2.R;

/**
 * Created by ds on 11/8/16.
 */

public class ShoppingCartViewHolder extends RecyclerView.ViewHolder {

    private ImageView mAnimalImage;
    private TextView mAnimalName;
    private TextView mAnimalCost;
    private Button mButton;

    public Button getButton() {
        return mButton;
    }

    public ImageView getAnimalImage() {
        return mAnimalImage;
    }

    public TextView getAnimalName() {
        return mAnimalName;
    }

    public TextView getAnimalCost() {
        return mAnimalCost;
    }



    public ShoppingCartViewHolder(View itemView) {
        super(itemView);

        mAnimalImage = (ImageView) itemView.findViewById(R.id.animal_image);
        mAnimalName = (TextView) itemView.findViewById(R.id.name);
        mAnimalCost = (TextView) itemView.findViewById(R.id.cost);
        mButton = (Button) itemView.findViewById(R.id.remove_item);
    }
}
