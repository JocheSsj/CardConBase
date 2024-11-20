package com.example.menuapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "Base_Educa";
    private static final String TABLE_ESTABLECIMIENTO = "tabla_establecimento";

    public DbHelper(@Nullable Context context) {
        super(context,DATABASE_NOMBRE , null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_ESTABLECIMIENTO + "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                " Nombre TEXT NOT NULL,"+
                " Direccion TEXT NOT NULL,"+
                " Tipo TEXT NOT NULL,"+
                " Descripcion TEXT NOT NULL,"+
                " Telefono TEXT NOT NULL,"+
                " Favorito INTERGER NOT NULL,"+
                " UrlEstablecimiento TEXT NOT NULL,"+
                " Logo TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_ESTABLECIMIENTO);
        onCreate(sqLiteDatabase);

    }
    public long insertarEstablecimiento(String nombre, String direccion, String tipo, String descripcion, String telefono, int favorito, String urlEstablecimiento, String logo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nombre", nombre);
        values.put("Direccion", direccion);
        values.put("Tipo", tipo);
        values.put("Descripcion", descripcion);
        values.put("Telefono", telefono);
        values.put("Favorito", favorito);
        values.put("UrlEstablecimiento", urlEstablecimiento);
        values.put("Logo", logo);

        long id = db.insert("tabla_establecimento", null, values);
        db.close();
        return id;
    }
    public List<Establecimiento> obtenerEstablecimientos() {
        List<Establecimiento> lista = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tabla_establecimento", null);

        if (cursor.moveToFirst()) {
            do {
                lista.add(new Establecimiento(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getInt(6),
                        cursor.getString(7),
                        cursor.getString(8)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }


}
