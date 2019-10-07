package com.example.abeer.quarantine.activity.dashactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.abeer.quarantine.R;

public class Textsss extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        textView=findViewById(R.id.textView7);
        editText=findViewById(R.id.editText);

    //    Intent intent = getIntent();
       // textView.setText(editText.getText().toString()+intent.getStringExtra("tttt"));
    }

    public void onclicktext(View view) {
        Intent intent=new Intent(Textsss.this, Textsss.class);
        intent.putExtra("tttt",editText.getText().toString());
        startActivityForResult(intent,context);
    }

//    private void startActivityForResult(Intent intent, Context context) {
//    }

    private void startActivityForResult(Intent intent, Context context) {
        if(context instanceof Textsss){
        textView.setText(textView.getText()+intent.getExtras().getString("tttt"));
        }
    }
}
