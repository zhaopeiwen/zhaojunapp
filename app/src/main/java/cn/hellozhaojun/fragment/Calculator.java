package cn.hellozhaojun.fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import cn.hellozhaojun.fragment.R;

@SuppressWarnings("ALL")
public class Calculator extends Activity implements OnClickListener {

    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_add;
    Button btn_jian;
    Button btn_cheng;
    Button btn_chu;
    Button btn_clear;
    Button btn_del;
    Button btn_point;
    Button btn_equal;
    EditText et_input;
    boolean clear_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_jian = (Button) findViewById(R.id.btn_jian);
        btn_cheng = (Button) findViewById(R.id.btn_cheng);
        btn_chu = (Button) findViewById(R.id.btn_chu);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_del = (Button) findViewById(R.id.btn_del);
        et_input = (EditText) findViewById(R.id.et_input);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_jian.setOnClickListener(this);
        btn_cheng.setOnClickListener(this);
        btn_chu.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_del.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if (clear_flag) {
                    clear_flag = false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str + ((Button) v).getText());
                break;
            case R.id.btn_add:
            case R.id.btn_jian:
            case R.id.btn_cheng:
            case R.id.btn_chu:
                if (clear_flag) {
                    clear_flag = false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.btn_del:
                if (clear_flag) {
                    clear_flag = false;
                    str="";
                    et_input.setText("");
                } else if (str != null && !str.equals("")) {
                    et_input.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.btn_clear:
                clear_flag = false;
                str="";//add
                et_input.setText("");
                break;
            case R.id.btn_equal:
                getResult();
                break;
        }
    }
    private void getResult(){
        String exp = et_input.getText().toString();
        if(exp==null||exp.equals("")){
            return;
        }
        if (!exp.contains(" ")){
            return;
        }
        if (clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;
        String s1 = exp.substring(0,exp.indexOf(" "));
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2 = exp.substring(exp.indexOf(" ")+3);
        if (!s1.equals("")&&!s2.equals("")){
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")){
                result = d1+d2;
            }else if (op.equals("-")){
                result = d1-d2;
            }else if (op.equals("×")){
                result = d1*d2;
            }else if (op.equals("÷")){
                if (d2==0){
                    result = 0;
                }else{
                    result = d1/d2;
                }
            }
            if (!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){
                int r = (int) result;
                et_input.setText(r+"");
            }else {
                et_input.setText(result+"");
            }
        }else {
            if (!s1.equals("") && s2.equals("")) {
                et_input.setText(exp);
            } else {
                if (s1.equals("") && !s2.equals("")) {
                    double d2 = Double.parseDouble(s2);
                    if (op.equals("+")) {
                        result = d2;
                    } else if (op.equals("-")) {
                        result = 0 - d2;
                    } else if (op.equals("×")) {
                        result = 0;
                    } else if (op.equals("÷")) {
                        result = 0;
                    }
                    if (!s2.contains(".")) {
                        int r = (int) result;
                        et_input.setText(r + "");
                    } else {
                        et_input.setText(result + "");
                    }
                } else {
                    et_input.setText("");
                }
            }
        }
    }
}
/*
package cn.hellozhaojun.calculator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{
    Button btn_0;//0按钮
    Button btn_1;//1按钮
    Button btn_2;//2按钮
    Button btn_3;//3按钮
    Button btn_4;//4按钮
    Button btn_5;//5按钮
    Button btn_6;//6按钮
    Button btn_7;//7按钮
    Button btn_8;//8按钮
    Button btn_9;//9按钮
    Button btn_point;//小数点按钮
    Button btn_clear;//清除按钮
    Button btn_del;//删除按钮
    Button btn_plus;//加按钮
    Button btn_minus;//减按钮
    Button btn_multiply;//乘按钮
    Button btn_divide;//除按钮
    Button btn_equal;//等号按钮
    EditText et_input;//显示输入内容的显示屏
    boolean clear_flag;//清空标识

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_plus = (Button) findViewById(R.id.btn_add);
        btn_minus = (Button) findViewById(R.id.btn_jian);
        btn_multiply = (Button) findViewById(R.id.btn_cheng);
        btn_divide = (Button) findViewById(R.id.btn_chu);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        //以上是实例化按钮
        et_input=(EditText)findViewById(R.id.et_input);//实例化显示屏

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        //以上设置按钮的点击事件




    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        String str =et_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());
                break;


            case R.id.btn_add:
            case R.id.btn_jian:
            case R.id.btn_cheng:
            case R.id.btn_chu:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.btn_clear:
                clear_flag=false;
                str="";
                et_input.setText("");
                break;
            case R.id.btn_del:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }else if(str!=null&&!str.equals("")){
                    et_input.setText(str.substring(0, str.length()-1));
                }
                break;
            case R.id.btn_equal:
                getResult();
                break;

        }
    }
    */
/**
 * 运算结果
 *//*

    private void getResult(){
        String exp=et_input.getText().toString();
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }

        if(clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        double result=0;
        String s1=exp.substring(0, exp.indexOf(" "));//运算符前面的字符串
        String op=exp.substring(exp.indexOf(" ")+1, exp.indexOf(" ")+2);//运算符
        String s2=exp.substring(exp.indexOf(" ")+3);//运算符后面的字符串

        if(!s1.equals("")&&!s2.equals("")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                result=d1+d2;
            }else if(op.equals("-")){
                result=d1-d2;
            }else if(op.equals("×")){
                result=d1*d2;
            }else if(op.equals("÷")){
                if(d2==0){
                    result=0;
                }else{
                    result=d1/d2;
                }
            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){
                int r=(int)result;
                et_input.setText(r+"");
            }else{
                et_input.setText(result+"");
            }
        }else if(!s1.equals("")&&s2.equals("")){
            et_input.setText(exp);
        }else if(s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                result=0+d2;
            }else if(op.equals("-")){
                result=0-d2;
            }else if(op.equals("×")){
                result=0;
            }else if(op.equals("÷")){
                result=0;
            }
            if(!s2.contains(".")){
                int r=(int)result;
                et_input.setText(r+"");
            }else{
                et_input.setText(result+"");
            }
        }else{
            et_input.setText("");
        }

    }
}
*/
