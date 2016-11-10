package project2.ds.project2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

import project2.ds.project2.Animal;
import project2.ds.project2.R;

/**
 * Created by ds on 11/3/16.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "ANIMALS_DB";
    public static final String ANIMAL_LIST_TABLE_NAME = "ANIMAL_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_COST = "COST";
    public static final String COL_LIFESPAN = "LIFESPAN";
    public static final String COL_SPECIES = "SPECIES";
    public static final String COL_COUNTRY_OF_ORIGIN = "COUNTRY";
    public static final String COL_DIET = "DIET";
    public static final String COL_ABOUT = "ABOUT";
    public static final String COL_IMAGE = "IMAGE";
    public static final String COL_NAME = "NAME";


    public static final String[] ANIMALS_COLUMNS = {COL_ID, COL_COST, COL_LIFESPAN, COL_SPECIES, COL_COUNTRY_OF_ORIGIN, COL_DIET, COL_ABOUT, COL_IMAGE, COL_NAME};

    private static final String CREATE_ANIMAL_LIST =
            "CREATE TABLE " + ANIMAL_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_COST + " INTEGER, " +
                    COL_LIFESPAN + " INTEGER, " +
                    COL_SPECIES + " TEXT, " +
                    COL_COUNTRY_OF_ORIGIN + " TEXT, " +
                    COL_DIET + " TEXT, " +
                    COL_IMAGE + " INTEGER, " +
                    COL_NAME + " TEXT, " +
                    COL_ABOUT + " TEXT )";

    private static DbHelper sInstance;

    public static DbHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DbHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ANIMAL_LIST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ANIMAL_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    public long addAnimal(Animal animal) {

        ContentValues values = new ContentValues();
        values.put(COL_COST, animal.getCost());
        values.put(COL_LIFESPAN, animal.getLifeSpan());
        values.put(COL_SPECIES, animal.getSpecies());
        values.put(COL_COUNTRY_OF_ORIGIN, animal.getCountryOfOrigin());
        values.put(COL_DIET, animal.getDiet());
        values.put(COL_ABOUT, animal.getAboutAnimal());
        values.put(COL_IMAGE, animal.getAnimalImageId());
        values.put(COL_NAME, animal.getAnimalName());

        SQLiteDatabase db = this.getWritableDatabase();
        long returnId = db.insert(ANIMAL_LIST_TABLE_NAME, null, values);
        db.close();
        return returnId;
    }

    public List<Animal> getAnimalList() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ANIMAL_LIST_TABLE_NAME, // a. table
                ANIMALS_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        List<Animal> animalList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Animal animal = new Animal(
                        cursor.getInt(cursor.getColumnIndex(COL_COST)),
                        cursor.getInt(cursor.getColumnIndex(COL_LIFESPAN)),
                        cursor.getString(cursor.getColumnIndex(COL_SPECIES)),
                        cursor.getString(cursor.getColumnIndex(COL_COUNTRY_OF_ORIGIN)),
                        cursor.getString(cursor.getColumnIndex(COL_DIET)),
                        cursor.getString(cursor.getColumnIndex(COL_ABOUT)),
                        cursor.getInt(cursor.getColumnIndex(COL_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(COL_NAME)));
                animal.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
                animalList.add(animal);
                cursor.moveToNext();
            }
        }
        return animalList;
    }

    public Animal getAnimalByID(int id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(ANIMAL_LIST_TABLE_NAME, // a. table
                ANIMALS_COLUMNS, // b. column names
                COL_ID + " = ?", // c. selections
                new String[]{String.valueOf(id)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        Animal animal = new Animal(0, 0, null, null, null, null, 0, null);

        if (cursor.moveToFirst()) {
            animal = new Animal(
                    cursor.getInt(cursor.getColumnIndex(COL_COST)),
                    cursor.getInt(cursor.getColumnIndex(COL_LIFESPAN)),
                    cursor.getString(cursor.getColumnIndex(COL_SPECIES)),
                    cursor.getString(cursor.getColumnIndex(COL_COUNTRY_OF_ORIGIN)),
                    cursor.getString(cursor.getColumnIndex(COL_DIET)),
                    cursor.getString(cursor.getColumnIndex(COL_ABOUT)),
                    cursor.getInt(cursor.getColumnIndex(COL_IMAGE)),
                    cursor.getString(cursor.getColumnIndex(COL_NAME)));
            animal.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
            cursor.close();
        }
        return animal;
    }

    //Search Animals
    public List<Animal> searchAnimals(String query) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ANIMAL_LIST_TABLE_NAME,
                ANIMALS_COLUMNS,
                COL_ABOUT + " LIKE ? OR " + COL_SPECIES + " LIKE ? ",
                new String[]{"%" + query + "%", "%" + query + "%"},
                null,
                null,
                null,
                null);

        List<Animal> animalList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Animal animal = new Animal(
                        cursor.getInt(cursor.getColumnIndex(COL_COST)),
                        cursor.getInt(cursor.getColumnIndex(COL_LIFESPAN)),
                        cursor.getString(cursor.getColumnIndex(COL_SPECIES)),
                        cursor.getString(cursor.getColumnIndex(COL_COUNTRY_OF_ORIGIN)),
                        cursor.getString(cursor.getColumnIndex(COL_DIET)),
                        cursor.getString(cursor.getColumnIndex(COL_ABOUT)),
                        cursor.getInt(cursor.getColumnIndex(COL_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(COL_NAME)));
                animal.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
                animalList.add(animal);
                cursor.moveToNext();
            }
        }
        return animalList;


    }

    public void populateDatabase() {

        Animal skunk = new Animal(149, 8, "Skunk", "Americas", "Beans, cabbage, garbage, eggs", "Temperamental, intelligent and smart. The more you hold and talk to her, the more love will come your way. Loves snuggling inside a T-shirt or tucked into a waistband. Hates the Yankees.", R.drawable.skunk, "Axe");
        addAnimal(skunk);
        Animal koala = new Animal(3200, 13, "Koala", "Australia", "Eucalyptus", "Somewhat housebroken. Loves Vin Diesel movies. Can be aggressive when coming down from Eucalyptus high. ", R.drawable.koala_eating, "GumNut");
        addAnimal(koala);
        Animal bunny = new Animal(129000, 65, "Human", "USA", "Froyo, lettuce, Acai Berries", "Beautiful, friendly, and from a small town, Likes to bounce around, and hop on things. Easily distracted by shiny objects.", R.drawable.bunny, "Charlene");
        addAnimal(bunny);
        Animal unicorn = new Animal(3500, 15, "Unicorn", "Yugoslavia", "Elves, fairies, pixies", "A unicorn's horn is said to have the power to render poisoned water potable and to heal sickness.", R.drawable.unicorn, "Headstick");
        addAnimal(unicorn);
        Animal goat = new Animal(399, 16, "Goat", "Spain", "Plant matter, cliff salt, mushrooms.", "Picky eater. Frequent flatulater. Good kisser.", R.drawable.smilinggoat, "Of Course, Billy.");
        addAnimal(goat);
        Animal blobFish = new Animal(12, 130, "Fish", "New Zealand", "Anything fat-free", "Official Mascot of the UAPS (Ugly Animal Preservation Society) Excellent deep-sea diver. Big-boned.", R.drawable.blobfish, "Anjellica");
        addAnimal(blobFish);
        Animal rock = new Animal(3, 15000000, "Sedimentary", "New York", "Vegan", "Social, hard-headed, likes company. This rock will never let you down, and offers great protection against giants.", R.drawable.petrock, "Norm");
        addAnimal(rock);
        Animal AyeAye = new Animal(900, 21, "Aye-Aye", "Madagascar", "Grubs, fruit, sap, chicken wings", "Finger-model. Third-eye (lid). Once thought to be extinct, Aye-Ayes are here to stay.", R.drawable.ayeaye, "Captain");
        addAnimal(AyeAye);
        Animal Tardigrade = new Animal(45, 1, "Tardigrade", "Space", "Bacteria Eater", "Smarter than your average bear. Won't fuss with the thermostat. This little guy survived a visit to space. Loves radiation.", R.drawable.tardigrae, "Indo");
        addAnimal(Tardigrade);
        Animal Naked_Mole_Rat = new Animal(6000, 31, "Naked Mole Rat", "East Africa", "Tubers", " Neither moles nor rats, Naked Mole Rats are not totally hairless. Say what! The Mole Rat species in one of the two mammals that are eusocial", R.drawable.nakedmolerat, "Teef");
        addAnimal(Naked_Mole_Rat);

    }
}