package com.example.buoi7;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataSQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "note";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME_NOTES = "notes";
    private static final String NOTE_ID_COLUMN = "id";
    private static final String NOTE_CONTENT_COLUMN = "content";

    public DataSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_notes_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT)",
                TABLE_NAME_NOTES, NOTE_ID_COLUMN, NOTE_CONTENT_COLUMN);
        sqLiteDatabase.execSQL(create_notes_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_NOTES);
        onCreate(sqLiteDatabase);
    }

    public void QueryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor getAllData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }


    public int deleteNote(int noteId) {
        SQLiteDatabase db = getWritableDatabase();
        int rowEffect = db.delete(TABLE_NAME_NOTES, NOTE_ID_COLUMN + " = ?", new
                String[]{String.valueOf(noteId)});
        return rowEffect;
    }

}