package com.example.easytranslate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONObject;

import java.util.List;
import java.util.Queue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    Spinner lang1,lang2;
    EditText input;
    Button btn;
    apiInterface request;
    TextView output;
    String url= "http://api.vajehyab.com/v3/";
    String  q = input.toString();
    String token = "68396.RFjz899q8QVoxLRxykPsEzk2yJccOwXjtiwVAUx4";
    String type = "exact";
    String filter="dehkhoda";
    ImageButton paste,copy;
    String back;
    ClipboardManager clipboardManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lang1=findViewById(R.id.spinner);
        lang2=findViewById(R.id.spinner2);
        input=findViewById(R.id.editTextTextMultiLine);
        output=findViewById(R.id.textView);
        btn=findViewById(R.id.btntrans);
        paste=findViewById(R.id.pastebutton);
        copy=findViewById(R.id.copy);
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        if(!clipboardManager.hasPrimaryClip()){
            paste.setEnabled(false);
        }
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text =  input.getText().toString();
                if(!text.equals("")){
                    ClipData clipData = ClipData.newPlainText("text",text);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(HomeActivity.this, "copied!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData clipData = clipboardManager.getPrimaryClip();
                ClipData.Item item = clipData.getItemAt(0);

                input.setText(item.getText().toString());
                Toast.makeText(HomeActivity.this, "pasted!", Toast.LENGTH_SHORT).show();
            }
        });



        lang1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(HomeActivity.this,parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                request = apiclient.getapiclient(url).create(apiInterface.class);
                request.getdata(token,q,type,filter).enqueue(new Callback<List<modelClass>>() {
                    @Override
                    public void onResponse(Call<List<modelClass>> call, Response<List<modelClass>> response) {
                        Toast.makeText(HomeActivity.this, "everthong is ok !"+ response.toString(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<List<modelClass>> call, Throwable t) {
                        Toast.makeText(HomeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("Error",t.getMessage()+"");
                    }
                });

            }
        });

    }
}