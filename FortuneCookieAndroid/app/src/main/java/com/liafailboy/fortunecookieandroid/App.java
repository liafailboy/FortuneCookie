package com.liafailboy.fortunecookieandroid;

/**
 * Created by shotaro on 3/1/15.
 */
import android.app.Application;
import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "HpyXTKXZCJ2R5KjCtjI9ei5LOJ7yQvBKU468nfd8", "Ol0OE11z41bbeuAewGGQaKF9rrSWYB1JYXWlPsxW");
    }
}