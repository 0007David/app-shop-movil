package com.proyect.app.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EventActivity extends AppCompatActivity {

    TextView tvName, tvDate, tvAddress, tvTotaAmount, tvState, tvTransportCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        User user = SharedPrefManager.getInstance(this).getUser();


        tvName = (TextView) findViewById(R.id.TextViewNombreEvent);
        tvAddress = (TextView) findViewById(R.id.TextViewAddress);
        tvDate = (TextView) findViewById(R.id.TextViewDate);
        tvTotaAmount = (TextView) findViewById(R.id.TextViewTotalAmount);
        tvState = (TextView) findViewById(R.id.TextViewState);
        tvTransportCost = (TextView) findViewById(R.id.TextViewTransportCost);

        //buttonEvent
        findViewById(R.id.btnAtras).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open register screen
                finish();
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });

        //Solicitud HTTP
        String URL = "http://kingtecnologyit.site/api/event?id="+user.getId();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("Resp : "  + response);
                        try {
                            //convertiendo la response a json object
                            JSONObject obj = new JSONObject(response);
                            Log.d("this is my array", "arr: " + response);

                            //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                            //if no error in response
                            if (obj.getBoolean("respuesta") == true) {
                                Toast.makeText(getApplicationContext(), "Exito hay evento",Toast.LENGTH_SHORT).show();

                                JSONObject userJson = obj.getJSONObject("event");
                                System.out.println("Este es un objeto JSON: "+userJson);
                                //creating a new user object
                                Event event = new Event(
                                        userJson.getString("name"),
                                        userJson.getString("address"),
                                        userJson.getString("date"),
                                        userJson.getString("state"),
                                        userJson.getDouble("total_amount"),
                                        userJson.getDouble("transport_cost")
                                );

                                tvName.setText(String.valueOf(event.getName()));
                                tvAddress.setText(String.valueOf(event.getAddress()));
                                tvDate.setText(String.valueOf(event.getDate()));
                                tvState.setText(String.valueOf(event.getState()));
                                tvTotaAmount.setText(String.valueOf(event.getTotal_amount()));
                                tvTransportCost.setText(String.valueOf(event.getTransport_cost()));

                                //storing the user in shared preferences

                                System.out.println("Evento:  "+event.toString());


                            } else {
                                Toast.makeText(getApplicationContext(),"No hay ningun evento",Toast.LENGTH_SHORT).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Catch exception JSON" + e.toString(),
                                    Toast.LENGTH_LONG).show();
                            System.out.println("ERROR: JSON Error catch ");

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"ERROR RESPONDE Volley error", Toast.LENGTH_LONG).show();
                    }

                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);



    }
}
