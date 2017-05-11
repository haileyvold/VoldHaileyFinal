package css.cis3334hailey.voldhaileyfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by haileyvold on 5/8/17.
 */

public class SecondActivity extends AppCompatActivity {

    // --- Instantiations for each plant button
    Button  btnSucculent,
            btnRedAgla,
            btnChesnut,
            btnFern,
            btnLily,
            btnPalm,
            btnHaworthia;
    // --- Instantiation for the database
    PlantDatabase plantDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Connect each instantiation with its respective button
        btnSucculent = (Button) findViewById(R.id.buttonSucculent);
        btnRedAgla = (Button) findViewById(R.id.buttonRedAgla);
        btnChesnut = (Button) findViewById(R.id.buttonChesnut);
        btnFern = (Button) findViewById(R.id.buttonFern);
        btnLily = (Button) findViewById(R.id.buttonLily);
        btnPalm = (Button) findViewById(R.id.buttonPalm);
        btnHaworthia = (Button) findViewById(R.id.buttonHaworthia);

        plantDataSource = new PlantDatabase();
        plantDataSource.open();

    }

    public void onClick(View view){
        if (view.getId() == R.id.buttonSucculent) {
            // Add the plant to the database
            plantDataSource.createPlant("Pearl Succulent");

            Context context = getApplicationContext();
            CharSequence text = "A Pearl Succulent has been added to your greenhouse.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (view.getId() == R.id.buttonRedAgla) {
            // Add the plant to the database
            plantDataSource.createPlant("Red Aglaonema");

            Context context = getApplicationContext();
            CharSequence text = "A Red Aglaonema has been added to your greenhouse.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (view.getId() == R.id.buttonChesnut) {
            // Add the plant to the database
            plantDataSource.createPlant("Guiana Chesnut");

            Context context = getApplicationContext();
            CharSequence text = "A Guiana Chesnut has been added to your greenhouse.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (view.getId() == R.id.buttonFern) {
            // Add the plant to the database
            plantDataSource.createPlant("Maidenhair Fern");

            Context context = getApplicationContext();
            CharSequence text = "A Maidenhair has been added to your greenhouse.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (view.getId() == R.id.buttonLily) {
            // Add the plant to the database
            plantDataSource.createPlant("Peace Lily");

            Context context = getApplicationContext();
            CharSequence text = "A Peace Lily has been added to your greenhouse.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (view.getId() == R.id.buttonPalm) {
            // Add the plant to the database
            plantDataSource.createPlant("Royal Palm");

            Context context = getApplicationContext();
            CharSequence text = "A Royal Palm has been added to your greenhouse.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (view.getId() == R.id.buttonHaworthia) {
                // Add the plant to the database
                plantDataSource.createPlant("Haworthia");

            Context context = getApplicationContext();
            CharSequence text = "A Haworthia has been added to your greenhouse.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
                // --- Send user back to main activity screen
                Intent mainActivityIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(mainActivityIntent);

            }
        }



