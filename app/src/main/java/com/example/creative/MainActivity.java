package com.example.creative;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    EditText search;
    Button find;
    ListView items;

    List<String> myList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    private String position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (EditText) findViewById(R.id.edt_txt1);
        find = (Button) findViewById(R.id.search_Btn);
        items = (ListView) findViewById(R.id.lst_v1);

        find.setOnClickListener(this);
        items.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_Btn: String text = search.getText().toString();
            myList.add(text);
            search.getText().clear();

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
            ListView.setAdapter(adapter);

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position long l) {
       
        Toast.makeText(this, "Item clicked: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}