package com.example.mysharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit1;
    private EditText edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1= findViewById(R.id.edit1);
        edit2= findViewById(R.id.edit2);
        /**
         * 读取数据
         */
        //获取SharedPreference对象，通过getSharedPreferences(String ,int)方法,
        // 第一个参数用于指定存储文件名，第二个参数指定文件操作类型，一般是MODE_PRIVATE私有存储方式，其他应用无法访问
        SharedPreferences sp=getSharedPreferences("defg",MODE_PRIVATE);
        String str=sp.getString("d",null);
        edit1.setText(str);
    }
    public  void doClick(View view){
        EditText edit1= findViewById(R.id.edit1);
        String name= edit1.getText().toString();
        if(name==null||name.trim().length()==0){
            Toast.makeText(MainActivity.this, "请输入正确的用户名", Toast.LENGTH_SHORT).show();
            return;
        }else{
            /**
             * 存储数据，
             */
            SharedPreferences sharedpreferences=getSharedPreferences("defg",MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedpreferences.edit();
            editor.putString("d",name);
            editor.commit();
            Toast.makeText(MainActivity.this, "保存数据成功", Toast.LENGTH_SHORT).show();
        }

    }
}