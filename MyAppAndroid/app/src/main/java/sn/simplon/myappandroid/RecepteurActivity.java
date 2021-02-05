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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import entities.Emetteur;
import entities.Recepteur;

public class RecepteurActivity extends AppCompatActivity {


    private EditText txt_nom;
    private EditText txt_prenom;
    private EditText txt_tel;
    private EditText txt_cni;
    private EditText txt_mont;


    private TextView txt_recu;
    private Button button_transfert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepteur);


        txt_nom = (EditText) findViewById(R.id.txt_nom);
        txt_prenom = (EditText) findViewById(R.id.txt_prenom);
        txt_tel = (EditText) findViewById(R.id.txt_tel);
        txt_cni = (EditText) findViewById(R.id.txt_cni);
        txt_mont = (EditText) findViewById(R.id.txt_mont);


        this.button_transfert = (Button) findViewById(R.id.button_transfert);
        button_transfert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recepteur recepteur = new Recepteur();

                recepteur.setNom(txt_nom.getText().toString());
                recepteur.setPrenom(txt_prenom.getText().toString());
                recepteur.setTelephone(txt_tel.getText().toString());
                recepteur.setCni(txt_cni.getText().toString());
                recepteur.setMontant_recu(txt_mont.getText().toString());

//                String url = "http://192.168.1.19:8080/Recepteur/liste";
//                txt_recu = (TextView) findViewById(R.id.txt_recu);
//
//                RequestQueue requestQueue = Volley.newRequestQueue(RecepteurActivity.this);
//                JsonArrayRequest objectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        String result = response.toString();
//                        txt_recu.setText(result);
//                    }
//                },
//                        new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                String message = null;
//                                if (error instanceof NetworkError ) {
//                                    message = "Cannot connect to Inte1...Please check your connection!";
//                                    txt_recu.setText(message);
//
//                                } else if (error instanceof ServerError) {
//                                    message = "The server could not be found. Please try again after some time!!";
//                                    txt_recu.setText(message);
//
//                                } else if (error instanceof AuthFailureError) {
//                                    message = "Cannot connect to Int2...Please check your connection!";
//                                    txt_recu.setText(message);
//
//                                } else if (error instanceof ParseError) {
//                                    message = "Parsing error! Please try again after some time!!";
//                                    txt_recu.setText(message);
//
//                                } else if (error instanceof NoConnectionError) {
//                                    message = "Cannot connect to Int3...Please check your connection!";
//                                    txt_recu.setText(message);
//
//                                } else if (error instanceof TimeoutError) {
//                                    message = " Connection TimeOut! Please check your internet connection.";
//                                    txt_recu.setText(message);
//
////                                }
//                            }
//                        }
//                );
//
//              //  requestQueue.add(objectRequest);


                postData(recepteur);

                Intent tansActivity = new Intent(getApplicationContext(),TransfertActivity.class);
                startActivity(tansActivity);
                finish();
            }
        });
    }

    public void postData(Recepteur recepteur){

        txt_recu = (TextView) findViewById(R.id.txt_recu);


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();

        try{
            object.put("recepteur", recepteur);
            System.out.println(recepteur);
        }catch(JSONException e){
            e.printStackTrace();

        }

        String url = "http://192.168.1.19:8080/Recepteur/save";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                txt_recu.setText("String Response : " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                txt_recu.setText("Error Getting Response");

            }

        });
        requestQueue.add(jsonObjectRequest);
    }
}