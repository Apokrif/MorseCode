package ganga.morsecode.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import ganga.morsecode.Application;
import ganga.morsecode.R;
import ganga.morsecode.model.Alphabet;

public class AlphabetActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private GridView overview;

    //region BottomNavigation
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
                    showDetails();
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

    private void showDetails() {
        mTextMessage.setText(R.string.title_details);
    }

    //endregion
    //region View Utility
    protected void hide(View view) {
        view.setVisibility(View.GONE);
    }

    protected void display(View view) {
        view.setVisibility(View.VISIBLE);
    }

    //endregion
    private void initializeContent() {
        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText(R.string.morse_code_description);
        overview = (GridView) findViewById(R.id.gridview);
        overview.setAdapter(new ArrayAdapter<>(this,
                R.layout.alphabet_cell, Alphabet.letters));
        //TODO Include in Context
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Application.showToast(Integer.toString(position));
            }
        };
        overview.setOnItemClickListener(listener);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    //region Life Cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        initializeContent();
        hide(overview);
    }
    //endregion
}
