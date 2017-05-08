package css.cis3334hailey.voldhaileyfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hvold on 5/7/2017.
 */

public class EnterPlant {

    public class DetailActivity extends AppCompatActivity {

        Button buttonBack;
        EditText editTextName;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_enter_plant);

            Bundle bundle = getIntent().getExtras();
            Plant plant = (Plant)   bundle.getSerializable("Plant");

            // link each editText variable to the xml layout
            editTextName = (EditText) findViewById(R.id.editTextName);

            editTextName.setText(plant.getName());


            // set up the button listener
            buttonBack = (Button) findViewById(R.id.buttonBack);
            buttonBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                    finish();
                    startActivity(mainActIntent);
                }
            });

        }
    }
}
