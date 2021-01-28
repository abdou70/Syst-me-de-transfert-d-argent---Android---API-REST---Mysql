package sn.simplon.myappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmetteurActivity extends AppCompatActivity {

    private Button button_recepteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emetteur);

        this.button_recepteur= (Button) findViewById(R.id.button_recepteur);
        button_recepteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recepActivity = new Intent(getApplicationContext(),RecepteurActivity.class);
                startActivity(recepActivity);
                finish();
            }
        });
    }
}