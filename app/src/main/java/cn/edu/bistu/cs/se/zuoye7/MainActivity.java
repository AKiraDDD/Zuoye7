package cn.edu.bistu.cs.se.zuoye7;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) this.findViewById(R.id.prompt);
        Button login = (Button) this.findViewById(R.id.login);
        //////////////////*******************
        //************************************************
        login.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View v){
                /*
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.login,
                        (ViewGroup) findViewById(R.id.login1));
                 */
                //LayoutInflater是用来找layout文件夹下的xml布局文件，并且实例化
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                //把login中的控件定义在View中
                final View layout = factory.inflate(R.layout.login, null);
                AlertDialog.Builder loginbuilder = new AlertDialog.Builder(MainActivity.this);
                loginbuilder.setTitle("登录界面");
                loginbuilder.setView(layout);
                loginbuilder.setNegativeButton("确定",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int whichButton) {


                        final EditText etUserName = (EditText)layout.findViewById(R.id.etuserName);
                        final EditText etPassword = (EditText)layout.findViewById(R.id.etPWD);
                        String userName = etUserName.getText().toString().trim();
                        String password = etPassword.getText().toString().trim();


                        if(userName.equals("123") || password.equals("123"))
                            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "用户名和密码不匹配", Toast.LENGTH_LONG).show();

                    }
                });


                loginbuilder.show();
            }
        });
        ///*****************************************************************************************
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("请点击登录按钮")//显示的消息内容
                        .setTitle("提示！");//对话框标题

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();

                    }

                });
                builder.show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
