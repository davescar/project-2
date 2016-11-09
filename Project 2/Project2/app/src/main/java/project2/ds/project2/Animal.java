package project2.ds.project2;

/**
 * Created by ds on 11/3/16.
 */

public class Animal {
    private int mId;
    private int mCost;
    private int mLifeSpan;
    private String mSpecies;
    private String mCountryOfOrigin;
    private String mDiet;
    private String mAboutAnimal;
    private int mAnimalImageId;
    private String mAnimalName;



    public Animal(int cost, int lifeSpan, String species, String countryOfOrigin, String diet, String aboutAnimal, int animalImageId, String animalName) {
        mCost = cost;
        mLifeSpan = lifeSpan;
        mSpecies = species;
        mCountryOfOrigin = countryOfOrigin;
        mDiet = diet;
        mAboutAnimal = aboutAnimal;
        mAnimalImageId = animalImageId;
        mAnimalName = animalName;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getCost() {
        return mCost;
    }

    public void setCost(int cost) {
        mCost = cost;
    }

    public int getLifeSpan() {
        return mLifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        mLifeSpan = lifeSpan;
    }

    public String getSpecies() {
        return mSpecies;
    }

    public void setSpecies(String species) {
        mSpecies = species;
    }

    public String getCountryOfOrigin() {
        return mCountryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        mCountryOfOrigin = countryOfOrigin;
    }

    public String getDiet() {
        return mDiet;
    }

    public void setDiet(String diet) {
        mDiet = diet;
    }

    public String getAboutAnimal() {
        return mAboutAnimal;
    }

    public void setAboutAnimal(String aboutAnimal) {
        mAboutAnimal = aboutAnimal;
    }

    public int getAnimalImageId() {
        return mAnimalImageId;
    }

    public void setAnimalImageId(int animalImageId) {
        mAnimalImageId = animalImageId;
    }

    public String getAnimalName() {
        return mAnimalName;
    }

    public void setAnimalName(String animalName) {
        mAnimalName = animalName;
    }
}
