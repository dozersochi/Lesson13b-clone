package com.example.ayudatsenko.lesson13b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "userstore.db"; // название БД
    private static final int SCHEMA = 1; // версия БД
    public static final String TABLE = "users"; // название таблицы
    public static final String COLUMN_ID = "_id"; // название столбца
    public static final String COLUMN_NAME = "name"; // название столбца
    public static final String COLUMN_YEAR = "year"; // название столбца

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create db
        db.execSQL("CREATE TABLE users (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " TEXT, " + COLUMN_YEAR + " INTEGER);");
        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_YEAR  + ") VALUES ('Anton Di', 1985);");
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_YEAR  + ") VALUES ('Eva Si', 1986);");
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_YEAR  + ") VALUES ('Smith Fi', 1987);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVewsion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
