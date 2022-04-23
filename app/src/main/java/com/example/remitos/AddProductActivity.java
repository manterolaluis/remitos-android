package com.example.remitos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;


import androidx.appcompat.app.AppCompatActivity;

public class AddProductActivity extends AppCompatActivity {

    private EditText et_name, et_brand, et_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        et_name = (EditText) findViewById(R.id.editTextName);
        et_brand = (EditText) findViewById(R.id.editTextBrand);
        et_price = (EditText) findViewById(R.id.editTextPrice);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void save(View view){
        AdminSQLiteOpenHelper databaseAdmin = new AdminSQLiteOpenHelper(this, "remitos", null, 1);
        SQLiteDatabase database = databaseAdmin.getWritableDatabase();

        String name = et_name.getText().toString();
        String brand = et_name.getText().toString();
        String price = et_price.getText().toString();

        if(name.isEmpty() || brand.isEmpty() || price.isEmpty()){
            Toast.makeText(this, "Te faltó llenar algo o le pifiaste con el precio", Toast.LENGTH_SHORT).show();
        } else {
            Double priceDouble = Double.valueOf(price);
            if(priceDouble > 0) {
                ContentValues row = new ContentValues();
                row.put("description", name);
                row.put("brand", brand);
                row.put("price", priceDouble);

                database.insert("Productos", null, row);
                database.close();
                et_price.setText("");
                et_name.setText("");
                et_brand.setText("");
            } else {
                Toast.makeText(this, "Raro ese precio...", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
