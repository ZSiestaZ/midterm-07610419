package su.cp.zsiestaz.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cal = findViewById(R.id.button2);
        final TextView textView = (TextView) findViewById(R.id.textView4);
        final EditText dis = findViewById(R.id.numtext1);
        final EditText tim = findViewById(R.id.numtext2);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dis.length() == 0 || tim.length() == 0){
                    Toast t = Toast.makeText(MainActivity.this,getResources().getString(R.string.Toast1),Toast.LENGTH_LONG);
                    t.show();
                }else{
                    double distance = Double.parseDouble(dis.getText().toString());
                    double time = Double.parseDouble(tim.getText().toString());
                    if(time <= 0){
                        Toast t = Toast.makeText(MainActivity.this,getResources().getString(R.string.Toast2),Toast.LENGTH_LONG);
                        t.show();
                    }else{
                        double result = ((distance/time)*60*60)/1000;
                        String strDouble = String.format("%.2f", result);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        if(result >= 80) {
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage(R.string.AD);
                            dialog.setPositiveButton("OK", null);
                            dialog.show();
                        }
                        textView.setText(strDouble);
                    }
                }

            }
        });

        Button clear = findViewById(R.id.button1);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                dis.setText("");
                tim.setText("");
            }
        });

    }

}