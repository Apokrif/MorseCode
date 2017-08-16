package ganga.morsecode;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Apocrypha on 6/12/2017.
 */

public class Application extends android.app.Application {
    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static void showToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
