package css.cis3334hailey.voldhaileyfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        setContentView(R.layout.activity_add_plant);
        Log.d("CIS3334", "In Oncreate for AddPlantActvi");
        etName = (EditText) findViewById(R.id.editTextName);


        plantDataSource = new PlantDatabase();
        plantDataSource.open();


        btnAddNew = (Button) findViewById(R.id.buttonAddNew);
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    // Add Plant
                    String name = etName.getText().toString();
                    plantDataSource.createPlant(name);

                Intent mainActivityIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(mainActivityIntent);
                }
            });

        }
    }
