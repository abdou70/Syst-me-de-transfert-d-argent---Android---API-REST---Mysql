package sn.simplon.myappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button button_emetteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.button_emetteur= (Button) findViewById(R.id.button_emetteur);
        button_emetteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emetActivity = new Intent(getApplicationContext(),EmetteurActivity.class);
                startActivity(emetActivity);
                finish();
            }
        });
    }
}