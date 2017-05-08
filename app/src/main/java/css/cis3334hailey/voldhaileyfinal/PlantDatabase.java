package css.cis3334hailey.voldhaileyfinal;

/**
 * Created by hvold on 5/7/2017.
 */

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PlantDatabase {


        DatabaseReference plantDbRef;
        FirebaseDatabase database;
        public static final String PlantDataTag = "Plant Data";

        public DatabaseReference open() {
            // Write a message to the database
            database = FirebaseDatabase.getInstance();
            plantDbRef = database.getReference(PlantDataTag);
            return plantDbRef;
        }

        public void close() {

        }

        public Plant createPlant(String name) {
            String key = plantDbRef.child(PlantDataTag).push().getKey();
            Plant newPlant = new Plant(key, name);
            plantDbRef.child(key).setValue("TESTING");
            plantDbRef.child(key).setValue(newPlant);
            return newPlant;
        }


        public void deletePlant(Plant plant) {
            String key = plant.getKey();
            plantDbRef.child(key).removeValue();
        }

        public List<Plant> getAllPlants(DataSnapshot dataSnapshot) {
            List<Plant> plantList = new ArrayList<Plant>();
            for (DataSnapshot data : dataSnapshot.getChildren()) {
                Plant plant = data.getValue(Plant.class);
               plantList.add(plant);
            }
            return plantList;
        }

    }

