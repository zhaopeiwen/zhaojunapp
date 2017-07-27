package cn.hellozhaojun.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by asus on 2017/5/18.
 */

public class Temperature extends Activity implements OnClickListener {
    private Button btn1;
    private EditText txtC;
    private EditText txtF;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature);
        btn1 = (Button) findViewById(R.id.temperature_btn1);

        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        txtC = (EditText) findViewById(R.id.temperature_TxtC);
        txtF = (EditText) findViewById(R.id.temperature_TxtF);
        double c;
        double f;
        double e;
        String a =  txtC.getText().toString();
        String b =  txtF.getText().toString();
        c = Double.parseDouble(a);
        f = (9/5)*c+32;
        e = (f-32)*5/9;
        txtF.setText("你输入的数值是："+c+"\n"+"转换后的结果是：\n"+"华氏度为："+String.valueOf(f)+" ℉\n摄氏度为："+String.valueOf(e)+" ℃");
        txtC.setText("");

/*        if ( a != null ){
            c = Double.parseDouble(a);
            f = (9/5)*c+32;
            txtF.setText(String.valueOf(f));
            txtC.setText("");
        }else if ( b != null ) {
            f = Double.parseDouble(b);
            c = f + 10;
            txtC.setText(String.valueOf(c));
            txtF.setText("");
        }else {
            Toast.makeText(getApplicationContext(),"你点解不输入数据就点击转换按钮，我顶你个肺...",2000).show();
        }*/
    }
}
