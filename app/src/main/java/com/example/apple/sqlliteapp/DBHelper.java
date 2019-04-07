package com.example.apple.sqlliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper
{
private static final  String DB_NAME="employee_db";
private static int DB_VERSION=1;
private static final  String EMPLOYEE_TABLE="EMPLOYEE";
private static final  String ID="id";
private static  final String NAME="name";
private static final String DESIGNATON="designation";
private static final String SALARY="salary";
    private static final String ADDRESS="address";
    public DBHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String DB_NAME_CREATE= " create table "  + EMPLOYEE_TABLE + " ( " + ID + " integer primary key autoincrement, " + NAME + " text, "+ DESIGNATON +
                " text, " + SALARY + " double, "+ ADDRESS + " text )";
        sqLiteDatabase.execSQL(DB_NAME_CREATE);
    }
    public boolean insertEmployee(Employee employee){
        SQLiteDatabase db=getReadableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,employee.getName());
        cv.put(DESIGNATON,employee.getDesignation());
        cv.put(SALARY,employee.getSalary());
        cv.put(ADDRESS,employee.getAddress());
        long record=db.insert(EMPLOYEE_TABLE,null,cv);
        if(record == 0)
            return false;

        else
            return true;
    }
    public List<Employee> getEmployee(){
        List<Employee> emplist= new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String query ="select * from "+EMPLOYEE_TABLE;
        Cursor cursor=db.rawQuery(query, null);

        while (cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex(NAME));
            String designation=cursor.getString(cursor.getColumnIndex(DESIGNATON));
            String address=cursor.getString(cursor.getColumnIndex(SALARY));
            Long salary =cursor.getLong(cursor.getColumnIndex(ADDRESS));
            int id = cursor.getInt(cursor.getColumnIndex(ID));
            Employee employee=new Employee(name,address,designation,salary);
            employee.setId(id);
            emplist.add(employee);
            }
            cursor.close();
        return emplist;

    }

    public  boolean deleteEmployee(int id){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        long record=sqLiteDatabase.delete(EMPLOYEE_TABLE,ID +" = " + id , null);
        return record > 0;
    }
    public void updateEmployee(Employee employee){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,employee.getName());
        cv.put(ADDRESS,employee.getAddress());
        cv.put(DESIGNATON,employee.getDesignation());
        cv.put(SALARY,employee.getSalary());
        db.update(EMPLOYEE_TABLE, cv, ID + " = " + employee , null);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
