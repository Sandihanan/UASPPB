package com.example.laundryku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class tampilData extends AppCompatActivity {
    com.example.laundryku.DatabaseHelper dbh;
    ListView listView;

    ArrayList<String> listitem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);

        listView=findViewById(R.id.list_data);
        dbh=new com.example.laundryku.DatabaseHelper(this);
        listitem=new ArrayList<>();

        //tampilkan data stok
        Cursor cursor=dbh.baca_data();

        listitem.clear();
        while (cursor.moveToNext())
        {
            listitem.add(cursor.getString( 0 )+ " "+cursor.getString(1));
        }
        adapter=new ArrayAdapter(tampilData.this,R.layout.support_simple_spinner_dropdown_item,listitem);
        listView.setAdapter(adapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(tampilData.this, edit_data.class);
                String mid=(listitem.get(position).substring(0,14));
                int panjang=listitem.get(position).length();
                String mnama=(listitem.get(position).substring(14,panjang));
                String malamat=(listitem.get(position).substring(0,14));
                String mnohp=(listitem.get(position).substring(0,14));
                String mkota=(listitem.get(position).substring(0,14));

                Toast.makeText(getApplicationContext(), ""+mnama, Toast.LENGTH_LONG).show();

                intent.putExtra("idnya",mid);
                intent.putExtra("namanya",mnama);
                intent.putExtra("alamatnya",malamat);
                intent.putExtra("nohpnya",mnohp);
                intent.putExtra("kotanya",mkota);

                startActivity(intent);
                return false;
            }
        });
    }
}