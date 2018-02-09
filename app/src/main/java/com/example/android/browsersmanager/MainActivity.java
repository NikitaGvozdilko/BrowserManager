package com.example.android.browsersmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button goFirstBrowser, goSecondBrowser, goThirdBrowser;
    private EditText firstUrl, secondUrl, thirdUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        goFirstBrowser = findViewById(R.id.go_to_first_browser);
        firstUrl = findViewById(R.id.firstUrl);
        goFirstBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = firstUrl.getText().toString();
                Intent firstBrowserIntent = getPackageManager().getLaunchIntentForPackage("com.browser1");
                if (firstBrowserIntent != null) {
                    System.out.println("Found app!");
                    firstBrowserIntent.putExtra("Site", first);
                    startActivity(firstBrowserIntent);//null pointer check in case package name was not found
                }
                else
                    Toast.makeText(getApplicationContext(), "App not found", Toast.LENGTH_SHORT).show();
            }
        });

        goSecondBrowser = findViewById(R.id.go_to_second_browser);
        secondUrl = findViewById(R.id.secondUrl);
        goSecondBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String second = secondUrl.getText().toString();
                Intent secondBrowserIntent = getPackageManager().getLaunchIntentForPackage("com.browser2");
                if (secondBrowserIntent != null) {
                    System.out.println("Found app!");
                    secondBrowserIntent.putExtra("Site", second);
                    startActivity(secondBrowserIntent);//null pointer check in case package name was not found
                }
                else
                    Toast.makeText(getApplicationContext(), "App not found", Toast.LENGTH_SHORT).show();
            }
        });

        goThirdBrowser = findViewById(R.id.go_to_third_browser);
        thirdUrl = findViewById(R.id.thirdUrl);
        goThirdBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String third = thirdUrl.getText().toString();
                Intent thirdBrowserIntent = getPackageManager().getLaunchIntentForPackage("com.browser3");
                if (thirdBrowserIntent != null) {
                    System.out.println("Found app!");
                    thirdBrowserIntent.putExtra("Site", third);
                    startActivity(thirdBrowserIntent);//null pointer check in case package name was not found
                }
                else
                    Toast.makeText(getApplicationContext(), "App not found", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
