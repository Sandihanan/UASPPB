package com.example.laundryku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String nama_db="DB_LAUNDRY";
    public final static String nama_table="Dataku";

    public final static String field_01="id";
    public final static String field_02="nama";
    public final static String field_03="alamat";
    public final static String field_04="nohp";
    public final static String field_05="kota";

    public DatabaseHelper(Context context) {
        super(context, nama_db, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+nama_table+"(id text primary key,nama text,alamat text,nohp text,kota text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+nama_table);
        onCreate(db);
    }

    public void tambah_data(String xid, String xnama, String xalamat, String xnohp,String xkota) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field_01,xid);
        contentValues.put(field_02,xnama);
        contentValues.put(field_03,xalamat);
        contentValues.put(field_04,xnohp);
        contentValues.put(field_05,xkota);

        db.insert(nama_table,null,contentValues);
    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+nama_table, null);
        return res;
    }

    public void update_data(String toString, String toString1,String toString2,String toString3,String toString4) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(field_01, toString);
        contentValues.put(field_02, toString1);
        contentValues.put(field_03, toString2);
        contentValues.put(field_04, toString3);
        contentValues.put(field_05, toString4);

        db.update(nama_table, contentValues, "id=?", new String[] {toString});

    }

}
