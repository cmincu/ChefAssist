package org.camin.views;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import org.camin.chefassist.R;

/**
 * Created by cmincu on 09.02.2015.
 */
public class AppPreferences extends PreferenceActivity
{
    private static int prefs = R.xml.preferences;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB)
        {
            onCreatePreferenceActivity();
        }
        else
        {
            onCreatePreferenceFragment();
        }
    }

    /**
     * Wraps legacy {@link #onCreate(Bundle)} code for Android < 3 (i.e. API lvl
     * < 11).
     */
    @SuppressWarnings("deprecation")
    private void onCreatePreferenceActivity() {
        addPreferencesFromResource(R.xml.preferences);
    }

    /**
     * Wraps {@link #onCreate(Bundle)} code for Android >= 3 (i.e. API lvl >=
     * 11).
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void onCreatePreferenceFragment() {
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new MyPreferenceFragment ())
                .commit();
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(AppPreferences.prefs);
            // private members seem to be visible for inner class, and
            // making it static made things so much easier
        }
    }
}