package cn.hellozhaojun.fragment;

/**
 * Created by asus on 2017/5/20.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class NoteMain extends Activity implements OnItemClickListener, OnItemLongClickListener {
    private Context mContext;
    private ListView listview;
    private SimpleAdapter simp_adapter;
    private List<Map<String, Object>> dataList;
    private Button addNote;
    private TextView tv_content;
    private NotesDB DB;
    private SQLiteDatabase dbread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_one);
        tv_content = (TextView) findViewById(R.id.tv_content);
        listview = (ListView) findViewById(R.id.listview);
        dataList = new ArrayList<Map<String, Object>>();

        addNote = (Button) findViewById(R.id.btn_editnote);
        mContext = this;
        addNote.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditNote.ENTER_STATE = 0;
                Intent intent = new Intent(mContext, EditNote.class);
                Bundle bundle = new Bundle();//两个activity之间的通讯可以通过bundle类来实现
                bundle.putString("info", "");
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
        // NotesDB
        DB = new NotesDB(this);
        dbread = DB.getReadableDatabase();
        RefreshNotesList();

        listview.setOnItemClickListener(this);
        listview.setOnItemLongClickListener(this);
    }

    public void RefreshNotesList() {

        int size = dataList.size();
        if (size > 0) {
            dataList.removeAll(dataList);
            simp_adapter.notifyDataSetChanged();
            listview.setAdapter(simp_adapter);
        }
        simp_adapter = new SimpleAdapter(this, getData(), R.layout.listview,
                new String[] { "tv_content", "tv_date" },
                new int[] { R.id.tv_content, R.id.tv_date });
        listview.setAdapter(simp_adapter);
    }

    private List<Map<String, Object>> getData() {

        Cursor cursor = dbread.query("note", null, "content!=\"\"", null, null,
                null, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("content"));
            String date = cursor.getString(cursor.getColumnIndex("date"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("tv_content", name);
            map.put("tv_date", date);
            dataList.add(map);
        }
        cursor.close();
        return dataList;
    }


    // 点击listview中某一项的监听事件
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        EditNote.ENTER_STATE = 1;
        String content = listview.getItemAtPosition(arg2) + "";//listView.getItemAtPosition(position)产生出来的是map对象不是string对象，不能强制转换成string
        //加了 "" 调用了 Map的toString方法。Map的ToString方法其实是Map自己重写的，返回key-value的字符串。
        String content1 = content.substring(content.indexOf("=") + 1, content.indexOf(","));
        Cursor c = dbread.query("note", null, "content=" + "'" + content1 + "'", null, null, null, null);
        while (c.moveToNext()) {
            String No = c.getString(c.getColumnIndex("_id"));
            Intent myIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("info", content1);
            EditNote.id = Integer.parseInt(No);
            myIntent.putExtras(bundle);
            myIntent.setClass(NoteMain.this, EditNote.class);
            startActivityForResult(myIntent, 1);
        }

    }

    @Override
    // 接受上一个页面返回的数据，并刷新页面
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            RefreshNotesList();
        }
    }

    // 点击listview中某一项长时间的点击事件
    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        final int n=arg2;
        Builder builder = new Builder(this);
        builder.setTitle("删除日记：");
        builder.setMessage("确定删除这篇辛苦编写的日记吗？");
        builder.setPositiveButton("我意已决", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String content = listview.getItemAtPosition(n) + "";
                String content1 = content.substring(content.indexOf("=") + 1, content.indexOf(","));
                Cursor c = dbread.query("note", null, "content=" + "'" + content1 + "'", null, null, null, null);
                while (c.moveToNext()) {
                    String id = c.getString(c.getColumnIndex("_id"));
                    String sql_del = "update note set content='' where _id=" + id;
                    dbread.execSQL(sql_del);
                    RefreshNotesList();
                }
            }
        });
        builder.setNegativeButton("于心不忍", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create();
        builder.show();
        return true;
    }

}