package project2.ds.project2;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import project2.ds.project2.database.DbHelper;

public class AnimalDetailActivity extends AppCompatActivity {

    public static final String ANIMAL_ID = "animalId";

    private Animal mAnimal;

    private TextView mCost;
    private TextView mLifeSpan;
    private TextView mSpecies;
    private TextView mCountryOfOrigin;
    private TextView mDiet;
    private TextView mAboutAnimal;
    private ImageView mAnimalImageId;
    private TextView mAnimalName;
    private Button mAddToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        mCost = (TextView) findViewById(R.id.cost);
        mLifeSpan = (TextView) findViewById(R.id.lifespan);
        mSpecies = (TextView) findViewById(R.id.species);
        mCountryOfOrigin = (TextView) findViewById(R.id.countryOfOrigin);
        mDiet = (TextView) findViewById(R.id.diet);
        mAnimalImageId = (ImageView) findViewById(R.id.animal_image);
        mAnimalName = (TextView) findViewById(R.id.animalName);
        mAboutAnimal = (TextView) findViewById(R.id.description);
        mAddToCart = (Button) findViewById(R.id.addAnimalToCart);

        int id = getIntent().getIntExtra(ANIMAL_ID, -1);

        if (id >= 0) {

            mAnimal = DbHelper.getInstance(this).getAnimalByID(id);

            mCost.setText("Price: $" + Integer.toString(mAnimal.getCost()));
            mLifeSpan.setText("Lifespan: " + Integer.toString(mAnimal.getLifeSpan())+ " years");
            mSpecies.setText("Species: " + mAnimal.getSpecies());
            mCountryOfOrigin.setText("Origin: " +mAnimal.getCountryOfOrigin());
            mDiet.setText("Eats: " +mAnimal.getDiet());
            mAnimalImageId.setImageResource(mAnimal.getAnimalImageId());
            mAboutAnimal.setText("About: " +mAnimal.getAboutAnimal());
            mAnimalName.setText(mAnimal.getAnimalName());
        }


        mAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingCart.getInstance().addAnimal(mAnimal);
                Toast.makeText(AnimalDetailActivity.this, "Item Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        ComponentName componentName = new ComponentName(this, MainActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.shopping_cart:
                Intent intent = new Intent(this, ShoppingCartActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
