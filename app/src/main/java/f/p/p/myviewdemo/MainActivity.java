package f.p.p.myviewdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnShowDialog;
    private Button btnRvTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog = (Button) findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);
        btnRvTest = (Button) findViewById(R.id.btn_rv_test);
        btnRvTest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_show_dialog:
                showDialog();
                break;
            case R.id.btn_rv_test:
                openRycyclerTestAct();
                break;

        }
    }

    private void showDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage(R.string.dialog_msg)
                .setTitle("title")
                .setCancelable(false)
                .setIcon(R.drawable.ic_launcher_background)
                .setPositiveButton(R.string.btn_sure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, R.string.btn_sure, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.btn_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, R.string.btn_no, Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();

    }

    private void openRycyclerTestAct(){
        startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
    }
}
