package css.cis3334hailey.voldhaileyfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by haileyvold on 5/8/17.
 */

public class SecondActivity extends AppCompatActivity {
    Button btnSucculent,
            btnRedAgla,
            btnChesnut,
            btnFern,
            btnLily,
            btnPalm,
            btnHaworthia;
    PlantDatabase plantDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

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
            Plant newPlant = new Plant("1", "Pearl Succulent");

            // --- Send user back to main activity screen
            Intent mainActivityIntent = new Intent(view.getContext(), MainActivity.class);
            finish();
            startActivity(mainActivityIntent);
        }
        else if (view.getId() == R.id.buttonRedAgla) {

            // --- Send user back to main activity screen
            Intent mainActivityIntent = new Intent(view.getContext(), MainActivity.class);
            finish();
            startActivity(mainActivityIntent);
        }
        else if (view.getId() == R.id.buttonChesnut) {

            // --- Send user back to main activity screen
            Intent mainActivityIntent = new Intent(view.getContext(), MainActivity.class);
            finish();
            startActivity(mainActivityIntent);
        }
        else if (view.getId() == R.id.buttonFern) {

            // --- Send user back to main activity screen
            Intent mainActivityIntent = new Intent(view.getContext(), MainActivity.class);
            finish();
            startActivity(mainActivityIntent);
        }
        else if (view.getId() == R.id.buttonLily) {

            // --- Send user back to main activity screen
            Intent mainActivityIntent = new Intent(view.getContext(), MainActivity.class);
            finish();
            startActivity(mainActivityIntent);
        }
        else if (view.getId() == R.id.buttonPalm) {

            // --- Send user back to main activity screen
            Intent mainActivityIntent = new Intent(view.getContext(), MainActivity.class);
            finish();
            startActivity(mainActivityIntent);
        }
        else if (view.getId() == R.id.buttonHaworthia) {

            // --- Send user back to main activity screen
            Intent mainActivityIntent = new Intent(view.getContext(), MainActivity.class);
            finish();
            startActivity(mainActivityIntent);
        }

    }

}
