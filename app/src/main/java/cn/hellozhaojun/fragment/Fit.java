package cn.hellozhaojun.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

/**
 * Created by asus on 2017/5/25.
 */

public class Fit extends Activity{
    private Button fit_btn1;
    private EditText fit_TxtC;
    private EditText fit_TxtF;
    private EditText fit_TxtG;
    private EditText fit_TxtH;
    private RadioGroup fit_rg;
    private RadioButton fit_boy;
    private RadioButton fit_girl;
    private String selected;
    private ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fit);
        fit_btn1 = (Button) findViewById(R.id.fit_btn1);//实例化Button
        fit_rg = (RadioGroup) findViewById(R.id.fit_rg);//实例化RG
        iv = (ImageView) findViewById(R.id.fit_image);
        fit_rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                //获取变更后的选中项的ID
                int radioButtonId = group.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) findViewById(radioButtonId);
                selected = rb.getText().toString();


            }
        });

        fit_btn1 = (Button) findViewById(R.id.fit_btn1);
        fit_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = new String("男");
                if (selected.equals(str)){
                    fit_TxtC = (EditText) findViewById(R.id.fit_TxtC);//体重
                    fit_TxtF = (EditText) findViewById(R.id.fit_TxtF);//身高
                    fit_TxtG = (EditText) findViewById(R.id.fit_TxtG);//年龄
                    fit_TxtH = (EditText) findViewById(R.id.fit_TxtH);
                    String a = fit_TxtC.getText().toString();//体重
                    String b = fit_TxtF.getText().toString();//身高
                    String g = fit_TxtG.getText().toString();//年龄
                    double c = Double.parseDouble(a);//体重
                    double d = Double.parseDouble(b);//身高
                    double age = Double.parseDouble(g);//年龄
                    double bmi = c/(d*d);
                    double fit = 1.2 * bmi + 0.23 * age - 5.4 - 10.8;
                    fit_TxtH.setText("死鬼，你输入的体重是："+a+"公斤"+"\n"+"你输入的身高是："+b+"米"+"\n"+
                            "你输入的年龄是："+g+"岁"+"\n"+"经计算，你的体脂率是：\n"+String.valueOf(fit)+" %");
                    iv.setImageResource(R.drawable.fit);
                    fit_TxtC.setText("");
                    fit_TxtF.setText("");
                    fit_TxtG.setText("");
                    //隐藏键盘
                    InputMethodManager imm = (InputMethodManager) getSystemService(Fit.this.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//                    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                }else {
                    fit_TxtC = (EditText) findViewById(R.id.fit_TxtC);//体重
                    fit_TxtF = (EditText) findViewById(R.id.fit_TxtF);//身高
                    fit_TxtG = (EditText) findViewById(R.id.fit_TxtG);//年龄
                    fit_TxtH = (EditText) findViewById(R.id.fit_TxtH);
                    String a = fit_TxtC.getText().toString();//体重
                    String b = fit_TxtF.getText().toString();//身高
                    String g = fit_TxtG.getText().toString();//年龄
                    double c = Double.parseDouble(a);//体重
                    double d = Double.parseDouble(b);//身高
                    double age = Double.parseDouble(g);//年龄
                    double bmi = c/(d*d);
                    double fit = 1.2 * bmi + 0.23 * age - 5.4;
                    fit_TxtH.setText("可爱的你输入的体重是："+a+"公斤"+"\n"+"你输入的身高是："+b+"米"+"\n"+
                            "你输入的年龄是："+g+"岁"+"\n"+"经计算，你的体脂率是：\n"+String.valueOf(fit)+" %");
                    iv.setImageResource(R.drawable.fit);
                    fit_TxtC.setText("");
                    fit_TxtF.setText("");
                    fit_TxtG.setText("");
                    //隐藏键盘
                    InputMethodManager imm = (InputMethodManager) getSystemService(Fit.this.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                }



/*
                        fit_TxtC = (EditText) findViewById(R.id.fit_TxtC);//体重
                        fit_TxtF = (EditText) findViewById(R.id.fit_TxtF);//身高
                        fit_TxtG = (EditText) findViewById(R.id.fit_TxtG);//年龄
                        fit_TxtH = (EditText) findViewById(R.id.fit_TxtH);
                        String a = fit_TxtC.getText().toString();//体重
                        String b = fit_TxtF.getText().toString();//身高
                        String g = fit_TxtG.getText().toString();//年龄
                        double c = Double.parseDouble(a);//体重
                        double d = Double.parseDouble(b);//身高
                        double age = Double.parseDouble(g);//年龄
                        double bmi = c/(d*d);
                        double fit = 1.2 * bmi + 0.23 * age - 5.4 - 10.8;
                        fit_TxtH.setText("你输入的体重是："+a+"公斤"+"\n"+"你输入的身高是："+b+"米"+"\n"+
                                "你输入的年龄是："+g+"岁"+"\n"+"经计算，你的体脂率是：\n"+String.valueOf(fit)+" %");
*/
            }
        });
    }
}
