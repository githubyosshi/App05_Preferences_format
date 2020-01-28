package com.bird_brown.app05_preferences_format;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {    // 自動生成された起動時に呼び出されるメソッド
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 書込ボタンをリスナ登録
        Button writeButton = (Button)findViewById(R.id.button1);
        writeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {        // ボタンが押された時に呼び出されるメソッド
        int id = view.getId();      // 押されたボタンのリソースIDを取得

        if (id == R.id.button1) {       // 書込みボタンを押した時
            writeFile();        // 書込み処理を行う
        }
    }

    private void writeFile() {                          // 書込み処理メソッドを作成
        EditText edit = (EditText)findViewById(R.id.editText1);
        String moji = edit.getText().toString();    // テキストボックスから文字列を取得

        String result = "書き込めました。";

        // データを登録や変更できるようにSharedPreferences.Editオブジェクトを生成
        SharedPreferences sp = getSharedPreferences("file", MODE_PRIVATE);
        SharedPreferences.Editor se = sp.edit();

        se.putString("MOJI_DATA", moji);    // ファイルにMOJI_DATAという名前で文字列を書込み

        if(se.commit() == false) {              // 登録又は変更の処理を完結する
            result = "書き込めませんでした。";
        }

        // トーストで書込み結果を表示
        Toast t = Toast.makeText(this, result, Toast.LENGTH_SHORT);
        t.show();

        edit.setText("");       // テキストボックスの中を空っぽにする
    }


}
