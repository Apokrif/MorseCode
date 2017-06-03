package ganga.morsecode.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import ganga.morsecode.R;

public class AlphabetActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private GridView overview;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_description:
                    showDescription();
                    return true;
                case R.id.navigation_dashboard:
                    showOverview();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_details);
                    return true;
            }
            return false;
        }

    };

    private void showDescription() {
        hide(overview);
        display(mTextMessage);
    }

    private void showOverview() {
        hide(mTextMessage);
        display(overview);
    }

    protected void hide(View view) {
        view.setVisibility(View.GONE);
    }

    protected void display(View view) {
        view.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText(R.string.morse_code_description);
        overview = (GridView) findViewById(R.id.gridview);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        hide(overview);
    }

}
