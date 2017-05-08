package css.cis3334hailey.voldhaileyfinal;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by hvold on 5/7/2017.
 */

public class AddPlantActivity  extends AppCompatActivity {

        Button btnAddNew;
        EditText etName;
        PlantDatabase plantDataSource;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_enter_plant);

            etName = (EditText) findViewById(R.id.editTextName);


            plantDataSource = new PlantDatabase();
            plantDataSource.open();


            btnAddNew = (Button) findViewById(R.id.buttonAddNew);
            btnAddNew.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // Add Plant
                    String name = etName.getText().toString();

                    PlantDatabase.newPlant(name.toString());
                    Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                    finish();
                    startActivity(mainActIntent);
                }
            });

        }
    }
}