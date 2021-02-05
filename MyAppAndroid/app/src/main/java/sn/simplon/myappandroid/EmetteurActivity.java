package sn.simplon.myappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import entities.Emetteur;

public class EmetteurActivity extends AppCompatActivity {

    private EditText txt_nom;
    private EditText txt_prenom;
    private EditText txt_tel;
    private EditText txt_cni;
    private EditText txt_mont;

    private TextView txt_envoie;
    private Button button_recepteur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emetteur);

        txt_nom = (EditText) findViewById(R.id.txt_nom);
        txt_prenom = (EditText) findViewById(R.id.txt_prenom);
        txt_tel = (EditText) findViewById(R.id.txt_tel);
        txt_cni = (EditText) findViewById(R.id.txt_cni);
        txt_mont = (EditText) findViewById(R.id.txt_mont);

        this.button_recepteur = (Button) findViewById(R.id.button_recepteur);
        button_recepteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emetteur emetteur = new Emetteur();

                emetteur.setNom(txt_nom.getText().toString());
                emetteur.setPrenom(txt_prenom.getText().toString());
                emetteur.setTelephone(txt_tel.getText().toString());
                emetteur.setCni(txt_cni.getText().toString());
                emetteur.setMontant_envoyer(txt_mont.getText().toString());




                //                //CALL BACKEND
              String url = "http://192.168.122.1:8080/Emetteur/liste";
                txt_envoie = (TextView) findViewById(R.id.txt_envoie);

                RequestQueue requestQueue = Volley.newRequestQueue(EmetteurActivity.this);
                JsonObjectRequest objectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                String result = response.toString();
                                txt_envoie.setText(result);


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                String result = error.toString();
                                System.out.println(error);
                                txt_envoie.setText(result);

                                String message = null;
                                if (error instanceof ServerError) {
                                    message = "Cannot connect to Inte1...Please check your connection!";
                                    txt_envoie.setText(message);

                                } else if (error instanceof TimeoutError) {
                                    message = "The server could not be found. Please try again after some time!!";
                                    txt_envoie.setText(message);

                                } else if (error instanceof AuthFailureError) {
                                    message = "Cannot connect to Int2...Please check your connection!";
                                    txt_envoie.setText(message);

                                } else if (error instanceof ParseError) {
                                    message = "Parsing error! Please try again after some time!!";
                                    txt_envoie.setText(message);

                                } else if (error instanceof NetworkError ) {
                                    message = "Cannot connect to Int3...Please check your connection!";
                                    txt_envoie.setText(message);

                                } else if (error instanceof NoConnectionError) {
                                    message = "Connection TimeOut! Please check your internet connection.";
                                    txt_envoie.setText(message);

                                }
                            }
                        }


                );

                requestQueue.add(objectRequest);



//              postData(emetteur);
//
//
              Intent recepActivity = new Intent(getApplicationContext(), RecepteurActivity.class);
              startActivity(recepActivity);
                finish();
            }
        });
    }


public void postData(Emetteur emetteur){

        txt_envoie = (TextView) findViewById(R.id.txt_envoie);


    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
    JSONObject object = new JSONObject();

    try{
        object.put("emetteur", emetteur);
    }catch(JSONException e){
        e.printStackTrace();

    }

    String url = "http://192.168.122.1:8080/Emetteur/save";

    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,object, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            txt_envoie.setText("String Response : " + response.toString());
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            txt_envoie.setText("Error Getting Response");

        }

});
    requestQueue.add(jsonObjectRequest);
}


}
