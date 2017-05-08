package css.cis3334hailey.voldhaileyfinal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    Button btnAdd, btnDelete;
    ListView lvPlants;
    ArrayAdapter<Plants> plantAdapter;
    List<Plant> plantList;
    DatabaseReference plantDbRef;
    PlantDatabase plantDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupFirebaseDataChange();
        setupListView();
        setupAddButton();
        setupDeleteButton();

        btnAdd = (Button) findViewById(R.id.buttonAddPlant);
        btnDelete = (Button) findViewById(R.id.buttonDeletePlant);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("cis3334", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("cis3334", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }


    private void setupFirebaseDataChange() {
        plantDataSource = new PlantDatabase();
        plantDbRef = plantDataSource.open();
        plantDbRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()");        // debugging log
                plantList = plantDataSource.getAllPlants(dataSnapshot);
                plantAdapter = new PlantAdapter(MainActivity.this, android.R.layout.simple_list_item_single_choice, plantList);
                // Apply the adapter to the list
                listViewPlants.setAdapter(plantAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });
    }

    private void setupListView() {
        lvPlants = (ListView) findViewById(R.id.listViewPlants);
        lvPlants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View parent,
                                    int position, long id) {
                positionSelected = position;
                Log.d("MAIN", "Plant selected at position " + positionSelected);
            }
        });
    }

    private void setupDetailButton() {
        buttonDetails = (Button) findViewById(R.id.buttonDetails);
        buttonDetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("MAIN", "onClick for Details");
                Intent detailActIntent = new Intent(view.getContext(), EnterPlant.class);
                detailActIntent.putExtra("Plant", plantList.get(positionSelected));
                finish();
                startActivity(detailActIntent);
            }
        });
    }


    private void setupDeleteButton() {
        btnDelete = (Button) findViewById(R.id.buttonDeletePlant);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("MAIN", "onClick for Delete");
                Log.d("MAIN", "Delete at position " + positionSelected);
                plantDataSource.deletePlant(plantList.get(positionSelected));
                plantAdapter.remove(plantList.get(positionSelected));
                plantAdapter.notifyDataSetChanged();
            }
        });

        private void setupAddButton() {
            btnAdd = (Button) findViewById(R.id.buttonAddPlant);
            btnAdd.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent detailActIntent = new Intent(view.getContext(), AddPlantActivity.class);
                    finish();
                    startActivity(detailActIntent);
                }
            });
        }

        @Override
        public void onStart () {
            super.onStart();
            mAuth.addAuthStateListener(mAuthListener);
        }

        @Override
        public void onStop () {
            super.onStop();
            if (mAuthListener != null) {
                mAuth.removeAuthStateListener(mAuthListener);
            }
        }


    }
}