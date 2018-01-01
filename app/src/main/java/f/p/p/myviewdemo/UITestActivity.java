package f.p.p.myviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UITestActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvContent;
    private Button btnTest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uitest);

        tvContent =  findViewById(R.id.tv_content);
        btnTest =  findViewById(R.id.btn_test);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test:
                tvContent.setText(R.string.text_test);
                break;
        }
    }
}
