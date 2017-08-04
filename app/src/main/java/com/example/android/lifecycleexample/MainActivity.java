package com.example.android.lifecycleexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Bundle

     * 액티비티가 파괴되고 새로 생길때마다, 메모리상에 저장되어 있는 내부 값들이 삭제된다.(백그라운드로 전환한 뒤 OS에 의해 파괴, 화면 회전 등)
     * pause나 stop상태일때는 언제든지 앱이 강제 종료될 수 있는 위험한 상황이므로, 수명주기에 대응할 수 있는 장치를 두는것이 필요하다.
     * Bundle 객체와 onSavedStatement()메소드(onPause, onStop 사이에 호출됨)
     * Preference나 SQLite등을 통해 데이터를 영구적으로 저장하는것 까지는 아니지만 수명주기에 잘 대응할 수 있도록 반 영구적인 데이터 보존이 필요할 때 사용.
     */

    TextView textView;

    public static final String RAND_NUM_BUNDLE_KEY = "number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_random_number_display);

        if (savedInstanceState != null) {

            if(savedInstanceState.containsKey(RAND_NUM_BUNDLE_KEY)) {

                textView.setText(savedInstanceState.getString(RAND_NUM_BUNDLE_KEY));

            }

        }

        else {

            int randNum = (int) (Math.random() * 10);

            textView.setText(String.valueOf(randNum));

        }

    }

    // public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) 메소드와 혼동하지 말것
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putString(RAND_NUM_BUNDLE_KEY, String.valueOf(textView.getText()));

    }

}
