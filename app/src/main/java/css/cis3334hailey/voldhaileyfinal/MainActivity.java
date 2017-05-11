package css.cis3334hailey.voldhaileyfinal;

/**
 * Created by hvold on 5/7/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    // --- Firebase Authentication
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    // --- Buttons and ListViews for the Main Activity XML
    Button btnEnterNew, btnDelete, btnAdd;
    ListView lvPlants;
    // --- Array Instantiations
    ArrayAdapter<Plant> plantAdapter;
    List<Plant> plantList;
    // --- Database Instantiations
    DatabaseReference plantDbRef;
    PlantDatabase plantDataSource;
    // --- Variables
    int positionSelected;
    // --- Toast Variables



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Methods for Layout Widgets and Firebase
        setupFirebaseDataChange();
        setupListView();
        setupEnterNewButton();
        setupDeleteButton();
        setupAddButton();

        btnEnterNew = (Button) findViewById(R.id.buttonEnterPlant);
        btnDelete = (Button) findViewById(R.id.buttonDeletePlant);
        btnAdd = (Button) findViewById(R.id.buttonAddPlant);

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

        // Write a message to the database
        plantDataSource = new PlantDatabase();
        plantDbRef = plantDataSource.open();
        plantDbRef.addValueEventListener(new ValueEventListener() {

            // Read from the database
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()");        // debugging log
                plantList = plantDataSource.getAllPlants(dataSnapshot);
                plantAdapter = new PlantAdapter(MainActivity.this, android.R.layout.simple_list_item_single_choice, plantList);
                // Apply the adapter to the list
                lvPlants.setAdapter(plantAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("cis3334", "onCancelled: ");
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


    private void setupAddButton() {
        btnAdd = (Button) findViewById(R.id.buttonAddPlant);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent addPlantIntent = new Intent(view.getContext(), SecondActivity.class);
                finish();
                startActivity(addPlantIntent);
            }
        });
    }

    private void setupDeleteButton()  {
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
    }


    private void setupEnterNewButton() {
        btnEnterNew = (Button) findViewById(R.id.buttonEnterPlant);
        btnEnterNew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("CIS3334", "In Onclick for setupEnterNewButton");
                Intent enterPlantIntent = new Intent(view.getContext(), AddPlantActivity.class);
                finish();
                startActivity(enterPlantIntent);
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
