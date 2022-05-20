package com.example.malloc_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.malloc_test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'malloc_test' library on application startup.
    static {
        System.loadLibrary("malloc_test");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        EditText editText = binding.editTextNumberDecimal2;
        Button button = binding.button2;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv.setText(stringFromJNI(Integer.parseInt(editText.getText().toString())));
            }

        });
        //tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'malloc_test' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(int count);
}