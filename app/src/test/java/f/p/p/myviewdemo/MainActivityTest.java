package f.p.p.myviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/12/31.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    @Test
    public void testTestActivity(){
        AppCompatActivity testActivity =Robolectric
                .buildActivity(UITestActivity.class)
                .create().get();
        Button testBtn =  testActivity.findViewById(R.id.btn_test);
        TextView testTv = testActivity.findViewById(R.id.tv_content);
        testBtn.performClick();
        assertThat(testTv.getText().toString(), equalTo(testActivity.getString(R.string.text_test)));
    }

}
