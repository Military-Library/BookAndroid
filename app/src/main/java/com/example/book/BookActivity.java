package com.example.book;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.book.data.BookData;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //값 전달
                Intent intent = new Intent();
                intent.putExtra("name","book");
                setResult(Activity.RESULT_OK,intent);
                //terminate
                finish();
            }
        });
        //home에서 받아오는 데이터
        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }
    private void processIntent(Intent intent){
        if(intent != null){
            ArrayList<String> names = (ArrayList<String>)intent.getSerializableExtra("names");
            if(names != null){
                Toast.makeText(getApplicationContext(),"전달받은 리스트 갯수: "+ names.size(),Toast.LENGTH_SHORT).show();
            }
           BookData data = (BookData) intent.getParcelableExtra("data");
            if(data != null){
                Toast.makeText(getApplicationContext(),"전달받은 data: "+ data.message,Toast.LENGTH_SHORT).show();
            }
        }
    }

}