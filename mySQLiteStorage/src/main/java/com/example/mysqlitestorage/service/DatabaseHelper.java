package com.example.mysqlitestorage.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int VERSION=1;
    private static final String DBNAME="mydatabase.db";   //  创建数据库名叫 mydatabase
    private Context mContext;

    /*构造方法创建数据库
    参数:1.上下文对象，2.数据库名称 3.默认null 4.版本号*/
    public DatabaseHelper(Context context){
        super(context,DBNAME,null,VERSION);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //创建用户表  user_tb
        sqLiteDatabase.execSQL("create table user_tb ("
                        +"id integer primary key autoincrement,"
                        +"username text,"
                        +"password text)");
        Toast.makeText(mContext, "创建User表成功", Toast.LENGTH_SHORT).show();



        //创建表 员工表   employee_tb
        sqLiteDatabase.execSQL("create table employee_tb ("
                +"id integer primary key autoincrement,"
                +"name text,"
                +"gender text,"
                +"dept text,"
                +"ramark)");

        Toast.makeText(mContext, "创建员工表成功", Toast.LENGTH_SHORT).show();
    }

    //数据库版本更新
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists user_tb");
        sqLiteDatabase.execSQL("drop table if exists employee_tb");
        onCreate(sqLiteDatabase);

    }
}
