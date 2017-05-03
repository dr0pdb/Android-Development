/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.sunshine.data.SunshinePreferences;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView mWeatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        /*
         * Using findViewById, we get a reference to our TextView from xml. This allows us to
         * do things like set the text of the TextView.
         */
        mWeatherTextView = (TextView) findViewById(R.id.tv_weather_data);

        loadWeatherData();
        // TODO (9) Call loadWeatherData to perform the network request to get the weather
    }

    // TODO (8) Create a method that will get the user's preferred location and execute your new AsyncTask and call it loadWeatherData
    void loadWeatherData(){
        String preferredLocation = SunshinePreferences.getPreferredWeatherLocation(MainActivity.this);
        new WeatherAsyncTask().execute(preferredLocation);
    }

    // TODO (5) Create a class that extends AsyncTask to perform network requests
    // TODO (6) Override the doInBackground method to perform your network requests
    // TODO (7) Override the onPostExecute method to display the results of the network request
    public class WeatherAsyncTask extends AsyncTask<String,Void,String[]>{

        @Override
        protected String[] doInBackground(String... params) {

            if (params.length == 0 ){
                return null;
            }

            String location = params[0];
            URL weatherRequestURL= NetworkUtils.buildUrl(location);

            try{
                String JsonResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestURL);

                String[] jsonArray= OpenWeatherJsonUtils.getSimpleWeatherStringsFromJson(MainActivity.this, JsonResponse);
                return  jsonArray;
            }catch (IOException | JSONException e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String[] strings) {
            if (strings !=null){
                for(String data : strings){
                    mWeatherTextView.append(data + "\n\n\n");
                }

            }
        }
    }

}