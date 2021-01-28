package sn.simplon.myappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecepteurActivity extends AppCompatActivity {


    private Button button_transfert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepteur);


        this.button_transfert = (Button) findViewById(R.id.button_transfert);
        button_transfert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tansActivity = new Intent(getApplicationContext(),TransfertActivity.class);
                startActivity(tansActivity);
                finish();
            }
        });
    }
}