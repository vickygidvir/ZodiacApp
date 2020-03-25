package com.example.zodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.b1);
        textView = findViewById(R.id.t1);
        editText = findViewById(R.id.ed1);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        String name = editText.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show the date picker
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, MainActivity.this, year, month, day);
                datePickerDialog.show();


            }
        });
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.share:
                Toast.makeText(this, "You Clicked Share.", Toast.LENGTH_SHORT).show();

                break;
            case R.id.about:

                Intent intent = new Intent(MainActivity.this, Animationdemo.class);
                startActivity(intent);
                break;
            case R.id.exit:
                Toast.makeText(this, " You have Exited.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.search:
                Toast.makeText(this, "You Clicked Search.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.my:
               finish();
                break;
        }
        return true;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String name = editText.getText().toString().trim();
        textView.setText(" " + name + " ur zodiac sign is: " + getZodiacSign(dayOfMonth, month));

        //return the selected date
    }

    private String getZodiacSign(int day, int month) {

        String zodiacSign = "";

        if (month == 0) {
            if (day < 20) {
                zodiacSign = "Capricon";
            } else {
                zodiacSign = "Aquarius";
            }
        } else if (month == 1) {
            if (day < 20) {
                zodiacSign = "Aquarius";
            } else {
                zodiacSign = "Pisces";
            }
        } else if (month == 2) {
            if (day < 20) {
                zodiacSign = "Pisces";
            } else {
                zodiacSign = "Aries";
            }
        } else if (month == 3) {
            if (day < 20) {
                zodiacSign = "Aries";
            } else {
                zodiacSign = "Taurus";
            }
        } else if (month == 4) {
            if (day < 20) {
                zodiacSign = "Taurus";
            } else {
                zodiacSign = "Gemini";
            }
        } else if (month == 5) {
            if (day < 20) {
                zodiacSign = "Gemini";
            } else {
                zodiacSign = "Cancer";
            }
        } else if (month == 6) {
            if (day < 20) {
                zodiacSign = "Cancer";
            } else {
                zodiacSign = "Leo";
            }
        } else if (month == 7) {
            if (day < 20) {
                zodiacSign = "Leo";
            } else {
                zodiacSign = "Virgo";
            }
        } else if (month == 8) {
            if (day < 20) {
                zodiacSign = "Virgo";
            } else {
                zodiacSign = "Libra";
            }
        } else if (month == 9) {
            if (day < 20) {
                zodiacSign = "Libra";
            } else {
                zodiacSign = "Scorpio";
            }
        } else if (month == 10) {
            if (day < 20) {
                zodiacSign = "Scorpio";
            } else {
                zodiacSign = "Sagittarius";
            }
        } else if (month == 11) {
            if (day < 20) {
                zodiacSign = "Sagittarius";
            } else {
                zodiacSign = "Capricon";
            }
        }

        return zodiacSign;
    }
}
