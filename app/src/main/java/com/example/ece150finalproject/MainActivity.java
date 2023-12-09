package com.example.ece150finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ece150finalproject.Model.ApiResponseModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    private TextView dateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView todoImage = this.findViewById(R.id.todoImage);
        Button button = this.findViewById(R.id.button);
        dateTextView = this.findViewById(R.id.dateTextView);

        todoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TodolistActivity.class);
                startActivity(intent);
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });
    }

    private void openDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.MyDatePickerDialogTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateTextView.setText(String.valueOf(year)+"."+String.valueOf(month)+"."+String.valueOf(dayOfMonth));
            }
        }, 2023,1,1);
        datePickerDialog.show();
    }

    public interface TheySaidSoApi {
        @GET(https://quotes.rest/)
        Call<ApiResponseModel> getQuotes(@Query(quote_api_key) String parameter);
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.theysaidso.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    TheySaidSoApi theySaidSoApi = retrofit.create(TheySaidSoApi.class);

    Call<ApiResponseModel> call = theySaidSoApi.getQuotes("your_parameter");
    call.enqueue(new Callback<ApiResponseModel>() {
        @Override
        public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
            // Handle the response
        }

        @Override
        public void onFailure(Call<ApiResponseModel> call, Throwable t) {
            // Handle the failure
        }
    });




}