package css.cis3334hailey.voldhaileyfinal;

/**
 * Created by hvold on 5/7/2017.
 */

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PlantDatabase {

        // --- Database Instantiations
        DatabaseReference plantDbRef;
        FirebaseDatabase database;
        public static final String PlantDataTag = "Plant Data";

        // Open the Database
        public DatabaseReference open() {
            database = FirebaseDatabase.getInstance();
            plantDbRef = database.getReference(PlantDataTag);
            return plantDbRef;
        }

        public void close() {

        }

        public Plant createPlant(String name) {
            String key = plantDbRef.child(PlantDataTag).push().getKey();
            Plant newPlant = new Plant(key, name);
            plantDbRef.child(key).setValue(newPlant);
            return newPlant;
        }

        // Delete plant from the Database
        public void deletePlant(Plant plant) {
            String key = plant.getKey();
            plantDbRef.child(key).removeValue();
        }


        // Get all the plants from the database
        public List<Plant> getAllPlants(DataSnapshot dataSnapshot) {
            List<Plant> plantList = new ArrayList<Plant>();
            for (DataSnapshot data : dataSnapshot.getChildren()) {

               Plant plant = data.getValue(Plant.class);
               plantList.add(plant);
            }
            return plantList;
        }

    }

