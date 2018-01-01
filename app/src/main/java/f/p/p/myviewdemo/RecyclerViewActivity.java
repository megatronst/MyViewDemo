package f.p.p.myviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rvTest;
    private Button btnSwitchLayout;


    private List<String> data;
    private RecyclerAdapter mAdatper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rvTest = (RecyclerView) findViewById(R.id.rv_test);
        getData();
        mAdatper = new RecyclerAdapter(data, this);
        rvTest.setLayoutManager(new GridLayoutManager(this,
                3,
                LinearLayoutManager.HORIZONTAL,
                false));
        rvTest.setAdapter(mAdatper);

        btnSwitchLayout = (Button) findViewById(R.id.btn_switch_layout);
        btnSwitchLayout.setOnClickListener(this);


    }

    private void getData(){
        if (data == null){
            data = new ArrayList<>();
        }
        for (int i=0; i<50; i++){
            data.add("this is " + i);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_switch_layout:
                switchLayout();
                break;
        }
    }

    boolean isSwitched = false;
    private void switchLayout(){
        if (isSwitched){
            rvTest.setLayoutManager(new LinearLayoutManager(this));
        }else {
            rvTest.setLayoutManager(new GridLayoutManager(this, 3));
        }
        isSwitched = !isSwitched;

    }
}
