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
 * Created by asus on 2017/5/26.
 */

public class Relative extends Activity implements OnClickListener {
    private EditText relative_et;
    private Button btn_husband;
    private Button btn_wife;
    private Button btn_father;
    private Button btn_mother;
    private Button btn_son;
    private Button btn_daughter;
    private Button btn_elderSister;
    private Button btn_sister;
    private Button btn_brother;
    private Button btn_youngerBrother;
    private Button btn_clear;
    private Button btn_del;
    private Button btn_exchange;
    private Button btn_equal;
    private EditText relative_out;
    boolean clear_flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);
        relative_et = (EditText) findViewById(R.id.relative_et);
        relative_out = (EditText) findViewById(R.id.relative_out);
        btn_husband = (Button) findViewById(R.id.btn_husband);
        btn_wife = (Button) findViewById(R.id.btn_wife);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_father = (Button) findViewById(R.id.btn_father);
        btn_mother = (Button) findViewById(R.id.btn_mother);
        btn_son = (Button) findViewById(R.id.btn_son);
        btn_daughter = (Button) findViewById(R.id.btn_daughter);
        btn_elderSister = (Button) findViewById(R.id.btn_elderSister);
        btn_sister = (Button) findViewById(R.id.btn_sister);
        btn_brother = (Button) findViewById(R.id.btn_brother);
        btn_youngerBrother = (Button) findViewById(R.id.btn_youngerBrother);
        btn_exchange = (Button) findViewById(R.id.btn_exchange);
        btn_equal = (Button) findViewById(R.id.btn_equal);


        //普通按钮
        btn_husband.setOnClickListener(this);
        btn_wife.setOnClickListener(this);
        btn_father.setOnClickListener(this);
        btn_mother.setOnClickListener(this);
        btn_son.setOnClickListener(this);
        btn_daughter.setOnClickListener(this);
        btn_elderSister.setOnClickListener(this);
        btn_sister.setOnClickListener(this);
        btn_brother.setOnClickListener(this);
        btn_youngerBrother.setOnClickListener(this);

        //操作按钮
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_exchange.setOnClickListener(this);
        btn_equal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String str = relative_et.getText().toString() + "的";
        switch (v.getId()) {
            case R.id.btn_husband:
            case R.id.btn_wife:
            case R.id.btn_father:
            case R.id.btn_mother:
            case R.id.btn_son:
            case R.id.btn_daughter:
            case R.id.btn_elderSister:
            case R.id.btn_sister:
            case R.id.btn_brother:
            case R.id.btn_youngerBrother:
                if (clear_flag) {
                    clear_flag = false;
                    str = "我的";
                    relative_et.setText("我的");
                }
                relative_et.setText(str + ((Button) v).getText());
                break;

            //进阶操作
            case R.id.btn_clear:
                clear_flag = false;
                str = "我的";//add
                relative_et.setText("我");
                break;
            case R.id.btn_del:
                if (clear_flag) {
                    clear_flag = false;
                    str = "我";
                    relative_et.setText("我");
                } else if (str != null && !str.equals("")) {
                    relative_et.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.btn_equal:
                getResult();
                break;
        }
    }

    public void getResult() {
        //关系有点远，年长的就叫老祖宗，同龄人就叫靓女靓仔吧~
        String exp = relative_et.getText().toString();
        String husband = new String("夫");
        String wife = new String("妻");
        String father = new String("父");
        String mother = new String("母");
        String son = new String("子");
        String daughter = new String("女");
        String elderSister = new String("姐");
        String sister = new String("妹");
        String brother = new String("兄");
        String youngerBrother = new String("弟");

        int exp_Length = exp.length();

        //长度为3的单层关系：
        if (exp_Length <= 3) {
            String s1 = exp.substring(0, 1);
            String s2 = exp.substring(2, 3);
            if (s2.equals(husband)) {
                Toast.makeText(Relative.this, "夫", Toast.LENGTH_SHORT).show();
                relative_out.setText("老公，或者叫 亲爱的~");
            } else if (s2.equals(wife)) {
                Toast.makeText(Relative.this, "妻", Toast.LENGTH_SHORT).show();
                relative_out.setText("老婆，或者叫 亲爱的~");
            } else if (s2.equals(father)) {
                Toast.makeText(Relative.this, "父", Toast.LENGTH_SHORT).show();
                relative_out.setText("爸爸，或者叫 爸~");
            } else if (s2.equals(mother)) {
                Toast.makeText(Relative.this, "母", Toast.LENGTH_SHORT).show();
                relative_out.setText("妈妈，或者叫 妈~");
            } else if (s2.equals(son)) {
                Toast.makeText(Relative.this, "儿", Toast.LENGTH_SHORT).show();
                relative_out.setText("儿子，或者叫 细佬~");
            } else if (s2.equals(daughter)) {
                Toast.makeText(Relative.this, "女", Toast.LENGTH_SHORT).show();
                relative_out.setText("女儿，或者叫 XX姐~");
            } else if (s2.equals(elderSister)) {
                Toast.makeText(Relative.this, "姐", Toast.LENGTH_SHORT).show();
                relative_out.setText("姐姐，或者叫 家姐~");
            } else if (s2.equals(sister)) {
                Toast.makeText(Relative.this, "妹", Toast.LENGTH_SHORT).show();
                relative_out.setText("妹妹，或者叫 细妹~");
            } else if (s2.equals(brother)) {
                Toast.makeText(Relative.this, "兄", Toast.LENGTH_SHORT).show();
                relative_out.setText("哥哥，或者叫 大哥~");
            } else if (s2.equals(youngerBrother)) {
                Toast.makeText(Relative.this, "弟", Toast.LENGTH_SHORT).show();
                relative_out.setText("弟弟，或者叫 细佬~");
            }
        }

        //长度为5的双层关系：
        else if (exp_Length <= 5) {
            String s1 = exp.substring(0, 1);
            String s2 = exp.substring(2, 3);
            String s3 = exp.substring(4, 5);
            if (s2.equals(husband)) {//我的丈夫
                if (s3.equals(husband)) {
                    Toast.makeText(Relative.this, "夫夫", Toast.LENGTH_SHORT).show();
                    relative_out.setText("咳咳，不可描述的小关系~");
                } else if (s3.equals(wife)) {
                    Toast.makeText(Relative.this, "夫的妻", Toast.LENGTH_SHORT).show();
                    relative_out.setText("你这个臭婆娘，\n她不就是你 自己 吗？！");
                } else if (s3.equals(father)) {
                    Toast.makeText(Relative.this, "夫的爸爸", Toast.LENGTH_SHORT).show();
                    relative_out.setText("公公，或者叫 家公~");
                } else if (s3.equals(mother)) {
                    Toast.makeText(Relative.this, "夫的妈", Toast.LENGTH_SHORT).show();
                    relative_out.setText("婆婆，或者叫 家婆~");
                } else if (s3.equals(son)) {
                    Toast.makeText(Relative.this, "夫的儿", Toast.LENGTH_SHORT).show();
                    relative_out.setText("他还是不是你亲生的？\n当然是叫他 儿子 啦~");
                } else if (s3.equals(daughter)) {
                    Toast.makeText(Relative.this, "夫的女", Toast.LENGTH_SHORT).show();
                    relative_out.setText("她还是不是你亲生的？\n当然是叫她 女儿 啦~");
                } else if (s3.equals(elderSister)) {
                    Toast.makeText(Relative.this, "夫的姐", Toast.LENGTH_SHORT).show();
                    relative_out.setText("大姑子");
                } else if (s3.equals(sister)) {
                    Toast.makeText(Relative.this, "夫的妹", Toast.LENGTH_SHORT).show();
                    relative_out.setText("小姑子");
                } else if (s3.equals(brother)) {
                    Toast.makeText(Relative.this, "夫的兄", Toast.LENGTH_SHORT).show();
                    relative_out.setText("大伯子");
                } else if (s3.equals(youngerBrother)) {
                    Toast.makeText(Relative.this, "夫的弟", Toast.LENGTH_SHORT).show();
                    relative_out.setText("小叔子");
                }
            } else if (s2.equals(wife)) {//我的妻子的
                if (s3.equals(husband)) {
                    relative_out.setText("死鬼，不就是你 自己 吗？！");
                } else if (s3.equals(wife)) {
                    relative_out.setText("咳咳，不可描述的小关系~");
                } else if (s3.equals(father)) {
                    relative_out.setText("岳父，或者直接叫 爸~");
                } else if (s3.equals(mother)) {
                    relative_out.setText("岳母，或者直接叫 妈~");
                } else if (s3.equals(son)) {
                    relative_out.setText("拜托，他还是不是你亲生的？\n当然叫他 儿子 啦~");
                } else if (s3.equals(daughter)) {
                    relative_out.setText("女儿");
                } else if (s3.equals(elderSister)) {
                    relative_out.setText("大姨子");
                } else if (s3.equals(sister)) {
                    relative_out.setText("小姨子");
                } else if (s3.equals(brother)) {
                    relative_out.setText("大舅子");
                } else {
                    relative_out.setText("小舅子");
                }
            } else if (s2.equals(father)) {//我的爸爸的
                if (s3.equals(husband)) {
                    relative_out.setText("你查的都是什么鬼哦....");
                } else if (s3.equals(wife)) {
                    relative_out.setText("妈妈");
                } else if (s3.equals(father)) {
                    relative_out.setText("爷爷");
                } else if (s3.equals(mother)) {
                    relative_out.setText("奶奶");
                } else if (s3.equals(son)) {
                    relative_out.setText("弟弟 / 自己 / 哥哥");
                } else if (s3.equals(daughter)) {
                    relative_out.setText("妹妹 / 自己 / 姐姐");
                } else if (s3.equals(elderSister)) {
                    relative_out.setText("姑母");
                } else if (s3.equals(sister)) {
                    relative_out.setText("姑姐");
                } else if (s3.equals(brother)) {
                    relative_out.setText("伯父");
                } else if (s3.equals(youngerBrother)) {
                    relative_out.setText("叔叔");
                }
            } else if (s2.equals(mother)) {//我的妈妈的
                if (s3.equals(husband)) {
                    relative_out.setText("你查的都是什么鬼哦....");
                } else if (s3.equals(wife)) {
                    relative_out.setText("妈妈");
                } else if (s3.equals(father)) {
                    relative_out.setText("爷爷");
                } else if (s3.equals(mother)) {
                    relative_out.setText("奶奶");
                } else if (s3.equals(son)) {
                    relative_out.setText("弟弟 / 自己 / 哥哥");
                } else if (s3.equals(daughter)) {
                    relative_out.setText("妹妹 / 自己 / 姐姐");
                } else if (s3.equals(elderSister)) {
                    relative_out.setText("姑母");
                } else if (s3.equals(sister)) {
                    relative_out.setText("姑姐");
                } else if (s3.equals(brother)) {
                    relative_out.setText("伯父");
                } else {
                    relative_out.setText("叔叔");
                }
            } else if (s2.equals(son)) {//我的儿子的
                if (s3.equals(husband)) {
                    relative_out.setText("你查的都是什么鬼哦....");
                } else if (s3.equals(wife)) {
                    relative_out.setText("儿媳妇");
                } else if (s3.equals(father)) {
                    relative_out.setText("自己 / 老公");
                } else if (s3.equals(mother)) {
                    relative_out.setText("自己 / 老婆");
                } else if (s3.equals(son)) {
                    relative_out.setText("孙子");
                } else if (s3.equals(daughter)) {
                    relative_out.setText("孙女");
                } else if (s3.equals(elderSister)) {
                    relative_out.setText("女儿");
                } else if (s3.equals(sister)) {
                    relative_out.setText("女儿");
                } else if (s3.equals(brother)) {
                    relative_out.setText("儿子");
                } else {
                    relative_out.setText("儿子");
                }
            } else if (s2.equals(daughter)) {//我的女儿的
                if (s3.equals(husband)) {
                    relative_out.setText("女婿");
                } else if (s3.equals(wife)) {
                    relative_out.setText("你查的都是什么鬼哦....");
                } else if (s3.equals(father)) {
                    relative_out.setText("自己 / 老公");
                } else if (s3.equals(mother)) {
                    relative_out.setText("自己 / 老婆");
                } else if (s3.equals(son)) {
                    relative_out.setText("外孙子");
                } else if (s3.equals(daughter)) {
                    relative_out.setText("外孙女");
                } else if (s3.equals(elderSister)) {
                    relative_out.setText("女儿");
                } else if (s3.equals(sister)) {
                    relative_out.setText("女儿");
                } else if (s3.equals(brother)) {
                    relative_out.setText("儿子");
                } else {
                    relative_out.setText("儿子");
                }
            } else if (s2.equals(elderSister)) {//我的姐姐的
                if (s3.equals(husband)) {
                    relative_out.setText("姐夫");
                } else if (s3.equals(wife)) {
                    relative_out.setText("你查的都是什么鬼哦....");
                } else if (s3.equals(father)) {
                    relative_out.setText("爸爸");
                } else if (s3.equals(mother)) {
                    relative_out.setText("妈妈");
                } else if (s3.equals(son)) {
                    relative_out.setText("外甥");
                } else if (s3.equals(daughter)) {
                    relative_out.setText("外甥女");
                } else if (s3.equals(elderSister)) {
                    relative_out.setText("姐姐");
                } else if (s3.equals(sister)) {
                    relative_out.setText("妹妹 / 自己 / 姐姐");
                } else if (s3.equals(brother)) {
                    relative_out.setText("弟弟 / 自己 / 哥哥");
                } else {
                    relative_out.setText("弟弟 / 自己 / 哥哥");
                }
            } else if (s2.equals(sister)) {//我的妹妹的
                if (s3.equals(husband)) {
                    relative_out.setText("妹夫");
                } else if (s3.equals(wife)) {
                    relative_out.setText("你查的都是什么鬼哦....");
                } else if (s3.equals(father)) {
                    relative_out.setText("爸爸");
                } else if (s3.equals(mother)) {
                    relative_out.setText("妈妈");
                } else if (s3.equals(son)) {
                    relative_out.setText("外甥");
                } else if (s3.equals(daughter)) {
                    relative_out.setText("外甥女");
                } else if (s3.equals(elderSister)) {
                    relative_out.setText("妹妹 / 自己 / 姐姐");
                } else if (s3.equals(sister)) {
                    relative_out.setText("妹妹 / 自己 / 姐姐");
                } else if (s3.equals(brother)) {
                    relative_out.setText("弟弟 / 自己 / 哥哥");
                } else {
                    relative_out.setText("弟弟 / 自己 / 哥哥");
                }
            } else if (s2.equals(sister)) {//我的哥哥的
                if (s3.equals(husband)) {
                    relative_out.setText("你查的都是什么鬼哦....");
                } else if (s3.equals(wife)) {
                    relative_out.setText("嫂子");
                } else if (s3.equals(father)) {
                    relative_out.setText("爸爸");
                } else if (s3.equals(mother)) {
                    relative_out.setText("妈妈");
                } else if (s3.equals(son)) {
                    relative_out.setText("侄子");
                } else if (s3.equals(daughter)) {
                    relative_out.setText("侄女");
                } else if (s3.equals(elderSister)) {
                    relative_out.setText("姐姐");
                } else if (s3.equals(sister)) {
                    relative_out.setText("妹妹 / 自己 / 姐姐");
                } else if (s3.equals(brother)) {
                    relative_out.setText("弟弟 / 自己 / 哥哥");
                } else {
                    relative_out.setText("弟弟 / 自己 / 哥哥");
                }
            } else {//我弟弟的
                if (s3.equals(husband)) {
                    relative_out.setText("你查的都是什么鬼哦....");
                } else if (s3.equals(wife)) {
                    relative_out.setText("弟妹");
                } else if (s3.equals(father)) {
                    relative_out.setText("爸爸");
                } else if (s3.equals(mother)) {
                    relative_out.setText("妈妈");
                } else if (s3.equals(son)) {
                    relative_out.setText("侄子");
                } else if (s3.equals(daughter)) {
                    relative_out.setText("侄女");
                } else if (s3.equals(elderSister)) {
                    relative_out.setText("妹妹 / 自己 / 姐姐");
                } else if (s3.equals(sister)) {
                    relative_out.setText("妹妹");
                } else if (s3.equals(brother)) {
                    relative_out.setText("弟弟 / 自己 / 哥哥");
                } else {
                    relative_out.setText("弟弟");
                }
            }
        }

        //长度为7的三层关系：
        else if (exp_Length <= 7) {
            String s1 = exp.substring(0, 1);
            String s2 = exp.substring(2, 3);
            String s3 = exp.substring(4, 5);
            String s4 = exp.substring(6, 7);
            if (s2.equals(husband)) {//我的老公的
                if (s3.equals(husband)) {//我的老公的老公
                    relative_out.setText("算了，我奔溃了还不行！！！");
                }
                else if (s3.equals(wife)) {//我老公的妻子的 = 我
                    if (s4.equals(husband)) {
                        relative_out.setText("咳咳，不可描述的小关系~");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你这个臭婆娘，\n她不就是你 自己 吗？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("公公，或者叫 家公~");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("婆婆，或者叫 家婆~");
                    } else if (s4.equals(son)) {
                        relative_out.setText("他还是不是你亲生的？\n当然是叫他 儿子 啦~");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("她还是不是你亲生的？\n当然是叫她 女儿 啦~");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("大姑子");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("小姑子");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("大伯子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("小叔子");
                    }
                }
                else if (s3.equals(father)) {//我老公的爸爸的 = 公公的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("婆婆");
                    } else if (s4.equals(father)) {
                        relative_out.setText("祖翁");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("祖婆");
                    } else if (s4.equals(son)) {
                        relative_out.setText("小叔子 / 老公 / 大伯子");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("小姑子 / 大姑子");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("姑婆");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("姑婆");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("伯翁");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("叔公");
                    }
                } else if (s3.equals(mother)) {//我老公的妈妈的 = 婆婆的
                    if (s4.equals(husband)) {
                        relative_out.setText("公公");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("外公");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("外婆");
                    } else if (s4.equals(son)) {
                        relative_out.setText("小叔子 / 老公 / 大伯子");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("小姑子 / 大姑子");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("姨婆");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("姨婆");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("舅公");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("舅公");
                    }
                } else if (s3.equals(son)) {//我老公的儿子的 = 儿子的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("儿媳");
                    } else if (s4.equals(father)) {
                        relative_out.setText("老公");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("自己");
                    } else if (s4.equals(son)) {
                        relative_out.setText("孙子");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("孙女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("女儿");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("女儿");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("儿子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("儿子");
                    }
                } else if (s3.equals(daughter)) {//我老公的女儿的 = 女儿的
                    if (s4.equals(husband)) {
                        relative_out.setText("女婿");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("老公");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("自己");
                    } else if (s4.equals(son)) {
                        relative_out.setText("外孙子");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("外孙女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("女儿");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("女儿");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("儿子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("儿子");
                    }
                } else if (s3.equals(elderSister)) {//我老公的姐姐的
                    if (s4.equals(husband)) {
                        relative_out.setText("大姑父");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("公公");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("婆婆");
                    } else if (s4.equals(son)) {
                        relative_out.setText("婆家甥");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("外甥女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("大姑子");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("小姑子 / 大姑子");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("小叔子 / 老公 / 大伯子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("小叔子 / 老公/ 大伯子");
                    }
                } else if (s3.equals(sister)) {//我老公的妹妹的
                    if (s4.equals(husband)) {
                        relative_out.setText("小姑父");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("公公");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("婆婆");
                    } else if (s4.equals(son)) {
                        relative_out.setText("婆家甥");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("外甥女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("小姑子 / 大姑子");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("小姑子 / 大姑子");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("小叔子 / 老公 / 大伯子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("小叔子 / 老公/ 大伯子");
                    }
                } else if (s3.equals(brother)) {//我老公的哥哥的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("大婶子");
                    } else if (s4.equals(father)) {
                        relative_out.setText("公公");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("婆婆");
                    } else if (s4.equals(son)) {
                        relative_out.setText("婆家侄");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("侄女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("大姑子");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("小姑子 / 大姑子");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("小叔子 / 老公 / 大伯子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("小叔子 / 老公/ 大伯子");
                    }
                } else {//我老公的弟弟的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("小婶子");
                    } else if (s4.equals(father)) {
                        relative_out.setText("公公");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("婆婆");
                    } else if (s4.equals(son)) {
                        relative_out.setText("婆家侄");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("侄女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("小姑子 / 大姑子");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("小姑子 / 大姑子");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("小叔子 / 老公 / 大伯子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("小叔子 / 老公/ 大伯子");
                    }
                }
            }

            else if (s2.equals(wife)) {//我妻子的
                if (s3.equals(husband)) {//我妻子的老公 = 我
                    relative_out.setText("就是你自己~");
                }
                else if (s3.equals(wife)) {//我妻子的妻子的 = 我
                    relative_out.setText("死鬼，你让我怎么算？");
                }
                else if (s3.equals(father)) {//我妻子的爸爸的 = 岳父的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("岳母");
                    } else if (s4.equals(father)) {
                        relative_out.setText("太岳父");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("太岳母");
                    } else if (s4.equals(son)) {
                        relative_out.setText("小舅子 / 大舅子");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("小姨子 / 老婆 / 大姨子");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("姑岳母");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("姑岳母");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("伯岳");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("叔岳");
                    }
                }
                else if (s3.equals(mother)) {//我妻子的妈妈的 = 岳母的
                    if (s4.equals(husband)) {
                        relative_out.setText("岳父");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("外太岳父");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("外太岳母");
                    } else if (s4.equals(son)) {
                        relative_out.setText("小舅子 / 大舅子");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("小姨子/ 老婆 / 大姨子");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("姨岳母");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("姨岳母");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("舅岳父");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("舅岳父");
                    }
                } else if (s3.equals(son)) {//我老婆的儿子的 = 儿子的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("儿媳");
                    } else if (s4.equals(father)) {
                        relative_out.setText("老公");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("自己");
                    } else if (s4.equals(son)) {
                        relative_out.setText("孙子");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("孙女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("女儿");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("女儿");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("儿子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("儿子");
                    }
                } else if (s3.equals(daughter)) {//我老婆的女儿的 = 女儿的
                    if (s4.equals(husband)) {
                        relative_out.setText("女婿");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("老公");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("自己");
                    } else if (s4.equals(son)) {
                        relative_out.setText("外孙子");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("外孙女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("女儿");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("女儿");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("儿子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("儿子");
                    }
                } else if (s3.equals(elderSister)) {//我老婆的姐姐的
                    if (s4.equals(husband)) {
                        relative_out.setText("大姨父");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("岳父");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("岳母");
                    } else if (s4.equals(son)) {
                        relative_out.setText("内甥");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("姨甥女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("大姨子 / 老婆 / 小姨子");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("大姨子 / 老婆 / 小姨子");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("小舅子 / 大舅子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("小舅子 / 大舅子");
                    }
                } else if (s3.equals(sister)) {//我老婆的妹妹的
                    if (s4.equals(husband)) {
                        relative_out.setText("小姨父");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("岳父");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("岳母");
                    } else if (s4.equals(son)) {
                        relative_out.setText("内甥");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("姨甥女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("大姨子 / 老婆 / 小姨子");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("大姨子 / 老婆 / 小姨子");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("小舅子 / 大舅子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("小舅子 / 大舅子");
                    }
                } else if (s3.equals(brother)) {//我老婆的哥哥的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("舅嫂");
                    } else if (s4.equals(father)) {
                        relative_out.setText("岳父");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("岳母");
                    } else if (s4.equals(son)) {
                        relative_out.setText("内侄");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("内侄女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("大姨子 / 老婆 / 小姨子");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("大姨子 / 老婆 / 小姨子");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("小舅子 / 大舅子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("小舅子 / 大舅子");
                    }
                }
                else {//我老婆的弟弟的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("舅弟媳");
                    } else if (s4.equals(father)) {
                        relative_out.setText("岳父");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("岳母");
                    } else if (s4.equals(son)) {
                        relative_out.setText("内侄");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("内侄女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("大姨子 / 老婆 / 小姨子");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("大姨子 / 老婆 / 小姨子");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("小舅子 / 大舅子");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("小舅子 / 大舅子");
                    }
                }
            }

            else if (s2.equals(father)) {//我爸爸的
                if (s3.equals(husband)) {//我爸爸的老公
                    relative_out.setText("搞事情~");
                }
                else if (s3.equals(wife)) {//我爸爸的妻子的 = 我妈
                    relative_out.setText("妈");
                }
                else if (s3.equals(father)) {//我爸爸的爸爸的 = 爷爷的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("奶奶");
                    } else if (s4.equals(father)) {
                        relative_out.setText("曾祖父");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("曾祖母");
                    } else if (s4.equals(son)) {
                        relative_out.setText("爸爸 / 伯父 / 叔叔");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("姑妈");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("祖姑母");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("祖姑母");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("伯祖父");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("叔祖父");
                    }
                }
                else if (s3.equals(mother)) {//我爸爸的妈妈的 = 奶奶的
                    if (s4.equals(husband)) {
                        relative_out.setText("爷爷");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("曾外祖父");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("曾外岳母");
                    } else if (s4.equals(son)) {
                        relative_out.setText("爸爸 / 伯父 / 叔叔");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("姑妈");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("祖姨母");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("祖姨母");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("舅公");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("舅公");
                    }
                } else if (s3.equals(son)) {//我爸爸的儿子的 = 我的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("嫂子 / 弟妹 / 老婆");
                    } else if (s4.equals(father)) {
                        relative_out.setText("爸爸");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("妈妈");
                    } else if (s4.equals(son)) {
                        relative_out.setText("儿子 / 侄子");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("女儿 / 侄女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("妹妹 / 自己/ 姐姐");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("妹妹 / 自己 / 姐姐");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("弟弟 / 自己 / 哥哥");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("弟弟 / 自己 / 哥哥");
                    }
                } else if (s3.equals(daughter)) {//我爸爸的女儿的 =
                    if (s4.equals(husband)) {
                        relative_out.setText("姐夫 / 妹夫 / 老公");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("爸爸");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("妈妈");
                    } else if (s4.equals(son)) {
                        relative_out.setText("儿子 / 外甥");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("女儿 / 外甥女");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("妹妹 / 自己 / 姐姐");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("妹妹 / 自己 / 姐姐");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("弟弟 / 自己 / 哥哥");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("弟弟 / 自己 / 哥哥");
                    }
                } else if (s3.equals(elderSister)) {//我爸爸的姐姐的
                    if (s4.equals(husband)) {
                        relative_out.setText("姑丈");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("爷爷");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("奶奶");
                    } else if (s4.equals(son)) {
                        relative_out.setText("姑表弟 / 姑表哥");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("姑表妹 / 姑表姐");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("姑母");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("姑妈");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("爸爸 / 伯父 / 叔叔");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("爸爸 / 伯父 / 叔叔");
                    }
                } else if (s3.equals(sister)) {//我爸爸的妹妹的
                    if (s4.equals(husband)) {
                        relative_out.setText("姑丈");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(father)) {
                        relative_out.setText("爷爷");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("奶奶");
                    } else if (s4.equals(son)) {
                        relative_out.setText("姑表弟 / 姑表哥");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("姑表妹 / 姑表姐");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("姑妈");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("姑妈");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("爸爸 / 伯父 / 叔叔");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("爸爸 / 伯父 / 叔叔");
                    }
                }
                else if (s3.equals(brother)) {//我爸爸的哥哥的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("伯母");
                    } else if (s4.equals(father)) {
                        relative_out.setText("爷爷");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("奶奶");
                    } else if (s4.equals(son)) {
                        relative_out.setText("堂弟 / 堂哥");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("堂妹 / 堂姐");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("姑母");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("姑妈");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("爸爸 / 伯父 / 叔叔");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("爸爸 / 伯父 / 叔叔");
                    }
                }
                else {//我爸爸的弟弟的
                    if (s4.equals(husband)) {
                        relative_out.setText("你在搞事情？！");
                    } else if (s4.equals(wife)) {
                        relative_out.setText("婶婶");
                    } else if (s4.equals(father)) {
                        relative_out.setText("爷爷");
                    } else if (s4.equals(mother)) {
                        relative_out.setText("奶奶");
                    } else if (s4.equals(son)) {
                        relative_out.setText("堂弟 / 堂哥");
                    } else if (s4.equals(daughter)) {
                        relative_out.setText("堂妹 / 堂姐");
                    } else if (s4.equals(elderSister)) {
                        relative_out.setText("姑妈");
                    } else if (s4.equals(sister)) {
                        relative_out.setText("姑妈");
                    } else if (s4.equals(brother)) {
                        relative_out.setText("爸爸 / 伯父 / 叔叔");
                    } else if (s4.equals(youngerBrother)) {
                        relative_out.setText("爸爸 / 伯父 / 叔叔");
                    }
                }
            }

            else if (exp_Length <= 9){
                relative_out.setText("");
                Toast.makeText(Relative.this,"更多亲戚转换称呼请留意最新版本更新",Toast.LENGTH_LONG).show();
            }
        }

        else if (exp_Length > 7) {
            relative_out.setText("");
            Toast.makeText(Relative.this,"更多亲戚转换称呼请留意最新版本更新",Toast.LENGTH_LONG).show();
        }
        return;
    }
}
