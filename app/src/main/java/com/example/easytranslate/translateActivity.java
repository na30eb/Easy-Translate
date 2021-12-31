package com.example.easytranslate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class translateActivity extends AppCompatActivity {
    ImageButton paste,copy;
    ClipboardManager clipboardManager;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        paste=findViewById(R.id.pastebutton);
        copy=findViewById(R.id.copy);
        txt=findViewById(R.id.textView4);
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        if(getIntent().hasExtra("translation")  ){
        }

        if(!clipboardManager.hasPrimaryClip()){
            paste.setEnabled(false);
        }
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text =  txt.getText().toString();
                if(!text.equals("")){
                    ClipData clipData = ClipData.newPlainText("text",text);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(translateActivity.this, "copied!", Toast.LENGTH_SHORT).show();

                }

            }
        });

        paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData clipData = clipboardManager.getPrimaryClip();
                ClipData.Item item = clipData.getItemAt(0);

                txt.setText(item.getText().toString());
                Toast.makeText(translateActivity.this, "pasted!", Toast.LENGTH_SHORT).show();
            }
        });


    }


}