package com.example.andre.videoclubclient;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by andre on 4/28/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDatabase.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    public static final String CONTACTS_COLUMN_HOMEPHONE = "homephone";
    public static final String CONTACTS_COLUMN_ADDRESS = "address";
    public static final String CONTACTS_COLUMN_EMAIL = "email";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  crea la base de datos
        db.execSQL(
        "create table contacts " +
                "(id integer primary key, name text, phone text, homephone text, address text, email text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // si la tabla existe la elimina
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }
    public boolean insertContact (String name, String phone, String homephone, String address, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("homephone", homephone);
        contentValues.put("address", address);
        contentValues.put("email", email);
        db.insert("contacts", null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM CONTACTS WHERE id="+CONTACTS_COLUMN_ID+"", null);
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact(Integer id, String name, String phone, String homephone, String address, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("homephone", homephone);
        contentValues.put("address", address);
        contentValues.put("email", email);
        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts", "id = ? ", new String[] {Integer.toString(id)});
    }

    public ArrayList<String> getAllContacts() {
        ArrayList<String> arrayList = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM CONTACTS", null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
            res.moveToNext();
        }
        return arrayList;
    }
}
