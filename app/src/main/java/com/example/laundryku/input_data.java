package com.example.laundryku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class input_data extends AppCompatActivity {
    Button tblsave,tblview;
    EditText xid,xnama,xalamat,xnohp,xkota;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        xid=findViewById(R.id.id);
        xnama=findViewById(R.id.namalaundry);
        xalamat=findViewById(R.id.alamat);
        xnohp=findViewById(R.id.nohp);
        xkota=findViewById(R.id.kota);

        dbh=new DatabaseHelper(this);

        tblsave=findViewById(R.id.tombol_simpan);
        tblview=findViewById(R.id.tombol_view);

        tblsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (xid.getText().length() >= 14)
                {
                    xid.setError("Wajib 5 Karakter");
                    Toast.makeText(getApplicationContext(), "Maaf Kode Harus 5 Karakter", Toast.LENGTH_SHORT).show();
                    xid.requestFocus();
                }else {
                    dbh.tambah_data(xid.getText().toString(), xnama.getText().toString(), xalamat.getText().toString(), xnohp.getText().toString(), xkota.getText().toString());
                }
            }
        });

        tblview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(input_data.this,tampilData.class);
                startActivity(intent);
            }
        });
    }
}