package com.example.laundryku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit_data extends AppCompatActivity {
    DatabaseHelper dbh;
    EditText cid, cnama, calamat, cnohp, ckota;
    Button btnupdate,btndelete,btnview;

    String did="idnya";
    String dnama="namanya";
    String dalamat="alamatnya";
    String dnohp="nohpnya";
    String dkota="kotanya";

    String tampungId, tampungNama, tampungAlamat, tampungNohp, tampungKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        cid=findViewById(R.id.id_edit);
        cnama=findViewById(R.id.namalaundry_edit);
        calamat=findViewById(R.id.alamat_edit);
        cnohp=findViewById(R.id.nohp_edit);
        ckota=findViewById(R.id.kota_edit);
        btnupdate=findViewById(R.id.tombol_update);
        btndelete=findViewById(R.id.tombol_delete);
        btnview=findViewById(R.id.tombol_view);

        dbh=new DatabaseHelper(this);

        Bundle bundle=getIntent().getExtras();
        tampungId=bundle.getString(did);
        tampungNama=bundle.getString(dnama);
        tampungAlamat=bundle.getString(dalamat);
        tampungNohp=bundle.getString(dnohp);
        tampungKota=bundle.getString(dkota);

        cnama.setText(tampungNama);
        calamat.setText(tampungAlamat);
        cnohp.setText(tampungNohp);
        ckota.setText(tampungKota);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbh.update_data(cid.getText().toString(), cnama.getText().toString(), calamat.getText().toString(), cnohp.getText().toString(), ckota.getText().toString());
                Toast.makeText(getApplicationContext(), "Update Success !", Toast.LENGTH_SHORT).show();
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(edit_data.this, tampilData.class);
                startActivity(intent);
            }
        });
    }
}