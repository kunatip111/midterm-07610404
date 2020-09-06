package com.example.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText dis;
    EditText tim;
    TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button cle = findViewById(R.id.button_clear);
        cle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dis.setText("");
                tim.setText("");
            }
        });

        res = findViewById(R.id.textView_result);

        Button cal = findViewById(R.id.button_cal);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dis = findViewById(R.id.EText_distance);
                tim = findViewById(R.id.Etext_time);

                String disS = dis.getText().toString();
                String timS = tim.getText().toString();

                Double time = Double.parseDouble(timS);
                Double distance = Double.parseDouble(disS);

                int a;
                Double result;


                if(time ==0){
                    Toast t = Toast.makeText(MainActivity.this , R.string.more_than_zreo , Toast.LENGTH_LONG);
                    t.show();
                }

                else if(disS.length()<1 || timS.length()<1){
                    Toast t = Toast.makeText(MainActivity.this , R.string.d_a_t_aer_required , Toast.LENGTH_LONG);
                    t.show();
                }
                else if(time == 1){
                    a=1;
                    result = (a*distance)*3.6;
                    String str = String.format(
                            Locale.getDefault(),"%.2f" , result
                    );
                    res.setText(str);
                    if(result>80){
                        AlertDialog.Builder di = new AlertDialog.Builder(MainActivity.this);
                        di.setTitle("SPEED CALCULATOR");
                        di.setMessage(R.string.limit);
                        di.setPositiveButton("OK" , null);
                        di.show();
                    }
                }
                else if(time != 1){
                    Double aa=1/time;
                    result = (aa*distance)*3.6;
                    String str = String.format(
                            Locale.getDefault(),"%.2f" , result
                    );
                    res.setText(str);
                    if(result>80){
                        AlertDialog.Builder di = new AlertDialog.Builder(MainActivity.this);
                        di.setTitle("SPEED CALCULATOR");
                        di.setMessage(R.string.limit);
                        di.setPositiveButton("OK" , null);
                        di.show();
                    }
                }


            }
        });
    }
}