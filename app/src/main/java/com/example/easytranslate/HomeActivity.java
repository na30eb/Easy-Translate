package com.example.easytranslate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONObject;

import java.util.Queue;

public class HomeActivity extends AppCompatActivity {
    Spinner flang,slang ;
    Button btntranslate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        flang=findViewById(R.id.spinner);
        slang=findViewById(R.id.spinner2);
        btntranslate=findViewById(R.id.btntrans);


        flang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(HomeActivity.this,parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btntranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(HomeActivity.this);
                String url ="http://api.vajehyab.com/v3/word?token=68396.RFjz899q8QVoxLRxykPsEzk2yJccOwXjtiwVAUx4&title=سلام&db=en2fa&num=1";
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(HomeActivity.this,response.toString() , Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error
                                Toast.makeText(HomeActivity.this,"something wrong" , Toast.LENGTH_SHORT).show();

                            }
                        });



                // Toast.makeText(HomeActivity.this,"Translating "+flang.getSelectedItem().toString()+" to "+slang.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}