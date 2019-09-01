package com.example.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    HashMap<String,Employee> map = new HashMap<>();

    @BindView(R.id.empID)
    EditText empId;
    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.remote_work)
    EditText remote_work;
    @BindView(R.id.work_interfere)
    EditText work_interfere;
    @BindView(R.id.family_history)
    EditText family_history;
    @BindView(R.id.wellness_program)
    EditText wellness_program;
    @BindView(R.id.seek_help)
    EditText seek_help;
    @BindView(R.id.mental_health_consequence)
    EditText mental_health_consequence;
    @BindView(R.id.phys_health_consequence)
    EditText phys_health_consequence;
    @BindView(R.id.supervisor)
    EditText supervisor;
    @BindView(R.id.mental_health_interview)
    EditText mental_health_interview;
    @BindView(R.id.phys_health_interview)
    EditText phys_health_interview;
    @BindView(R.id.obs_consequence)
    EditText obs_consequence;
    @BindView(R.id.comments)
    EditText comments;

    private viewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /**
         * Map Entries
         */
        map.put("E2910",new Employee("500","Yes","Yes","Yes","Somewhat easy","E2910","Shalin Gupta","25","Canada","Male","NA"));
        map.put("E1110",new Employee("100","Yes","Yes","Yes","Very easy","E1110","Mark Henry","28","Israel","Female","NA"));
        map.put("E2310",new Employee("300","Yes","Yes","Yes","Very difficulty","E2310","Brutus","35","United States","Male","IL"));
        map.put("E2210",new Employee("20","No","No","Yes","Don't know","E2210","Julius Ceaser","50","Canada","Male","NA"));
        map.put("E2410",new Employee("50","Yes","Yes","No","Somewhat easy","E2410","RamNaresh Parmatma","22","United States","Male","IN"));
        map.put("E2610",new Employee("5000","Yes","Yes","Yes","Somewhat easy","E2610","Rahul Gandhi","45","Germany","Female","NA"));
        map.put("E2340",new Employee("60","No","Yes","Yes","Very easy","E2340","Narendra Modi","32","United States","Male","NA"));

        String newString = null;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= "E2610";
            } else {
                newString= extras.getString("Edi");
            }
        }




        viewModel = ViewModelProviders.of(this).get(viewModel.class);

        final HashMap<String,String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");


        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                /*viewModel.sendEmployeeRequest(headers,new EmployeeInfo(map.get(empId.getText().toString()).getNoOfEmp(),
                        map.get(empId.getText().toString()).getTechCompany(),
                        map.get(empId.getText().toString()).getBenefits(),
                        map.get(empId.getText().toString()).getCare_options(),
                        map.get(empId.getText().toString()).getLeave_Options(),
                        map.get(empId.getText().toString()).getEmpId(),
                        map.get(empId.getText().toString()).getEmpName(),
                        map.get(empId.getText().toString()).getEmpAge(),
                        map.get(empId.getText().toString()).getEmpCountry(),
                        map.get(empId.getText().toString()).getEmpGender(),
                        map.get(empId.getText().toString()).getEmpState(),
                        remote_work.getText().toString(),
                        work_interfere.getText().toString(),
                        family_history.getText().toString(),
                        wellness_program.getText().toString(),
                        seek_help.getText().toString(),
                        mental_health_consequence.getText().toString(),
                        phys_health_consequence.getText().toString(),
                        supervisor.getText().toString(),
                        mental_health_interview.getText().toString(),
                        phys_health_interview.getText().toString(),
                        obs_consequence.getText().toString(),
                        comments.getText().toString()
                        )).observe(MainActivity.this, new Observer<Boolean>() {
                    @Override
                    public void onChanged(@Nullable Boolean aBoolean) {
                        if (aBoolean!=null && aBoolean==true){
                            Toast.makeText(MainActivity.this, "Your Application has been submitted!!!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Please try Later.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/


                try {
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    String URL = "https://mindfox.azurewebsites.net/api/getEmpData";
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("id",  map.get(empId.getText().toString()).getEmpId());
                    jsonBody.put("tech_company",  map.get(empId.getText().toString()).getTechCompany());
                    jsonBody.put("benefits",map.get(empId.getText().toString()).getBenefits());
                    jsonBody.put("care_options", map.get(empId.getText().toString()).getCare_options());
                    jsonBody.put("leave",map.get(empId.getText().toString()).getLeave_Options());
                    jsonBody.put("no_employees", map.get(empId.getText().toString()).getNoOfEmp());
                    jsonBody.put("name",map.get(empId.getText().toString()).getEmpName());
                    jsonBody.put("Age",map.get(empId.getText().toString()).getEmpAge());
                    jsonBody.put("Country",map.get(empId.getText().toString()).getEmpCountry());
                    jsonBody.put("Gender",map.get(empId.getText().toString()).getEmpGender());
                    jsonBody.put("state",map.get(empId.getText().toString()).getEmpState());
                    jsonBody.put("remote_work",remote_work.getText().toString());
                    jsonBody.put("work_interfere",work_interfere.getText().toString());
                    jsonBody.put("family_history",family_history.getText().toString());
                    jsonBody.put("wellness_program",wellness_program.getText().toString());
                    jsonBody.put("seek_help",seek_help.getText().toString());
                    jsonBody.put("phys_health_consequence",phys_health_consequence.getText().toString());
                    jsonBody.put("mental_health_consequence",mental_health_consequence.getText().toString());
                    jsonBody.put("phys_health_interview",phys_health_interview.getText().toString());
                    jsonBody.put("obs_consequence",obs_consequence.getText().toString());
                    jsonBody.put("comment",comments.getText().toString());
                    jsonBody.put("supervisor",supervisor.getText().toString());
                    jsonBody.put("mental_health_consequence",mental_health_interview.getText().toString());



                    final String requestBody = jsonBody.toString();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("VOLLEY", response);
                            Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("VOLLEY", error.toString());
                            Toast.makeText(MainActivity.this, "Not Done", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset=utf-8";
                        }

                        @Override
                        public byte[] getBody() throws AuthFailureError {
                            try {
                                return requestBody == null ? null : requestBody.getBytes("utf-8");
                            } catch (UnsupportedEncodingException uee) {
                                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                                return null;
                            }
                        }

                        @Override
                        protected Response<String> parseNetworkResponse(NetworkResponse response) {
                            String responseString = "";
                            if (response != null) {
                                responseString = String.valueOf(response.statusCode);
                                // can get more details such as response.headers
                            }
                            return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                        }
                    };

                    requestQueue.add(stringRequest);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }




}
