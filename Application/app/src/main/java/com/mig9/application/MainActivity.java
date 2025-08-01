package com.mig9.application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView started_name;
    private EditText drone_id_field;
    private Button drone_connect_buttone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        started_name = findViewById(R.id.started_name);
        drone_id_field = findViewById(R.id.drone_id_field);
        drone_connect_buttone = findViewById(R.id.drone_connect_buttone);

        drone_connect_buttone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float connection_code =  Float.parseFloat(drone_id_field.getText().toString());
                started_name.setText(String.valueOf(connection_code));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}   