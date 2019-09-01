package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StratActivity extends AppCompatActivity {
    HashMap<String,Employee> map = new HashMap<>();

    @BindView(R.id.employeeId)
    EditText text;

    @BindView(R.id.submit_eid)
    Button submit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strat);
        ButterKnife.bind(this);

        map.put("E2910",new Employee("500","Yes","Yes","Yes","Somewhat easy","E2910","Shalin Gupta","25","Canada","Male","NA"));
        map.put("E1110",new Employee("100","Yes","Yes","Yes","Very easy","E1110","Mark Henry","28","Israel","Female","NA"));
        map.put("E2310",new Employee("300","Yes","Yes","Yes","Very difficulty","E2310","Brutus","35","United States","Male","IL"));
        map.put("E2210",new Employee("20","No","No","Yes","Don't know","E2210","Julius Ceaser","50","Canada","Male","NA"));
        map.put("E2410",new Employee("50","Yes","Yes","No","Somewhat easy","E2410","RamNaresh Parmatma","22","United States","Male","IN"));
        map.put("E2610",new Employee("5000","Yes","Yes","Yes","Somewhat easy","E2610","Rahul Gandhi","45","Germany","Female","NA"));
        map.put("E2340",new Employee("60","No","Yes","Yes","Very easy","E2340","Narendra Modi","32","United States","Male","NA"));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (map.containsKey(text.getText().toString())){
                    Intent intent = new Intent(StratActivity.this,MainActivity.class);
                    intent.putExtra("Edi",text.getText().toString());
                    startActivity(intent);
                }
            }
        });



    }
}
