package il.me.liranfunaro.motion;

import java.util.Map;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.pref_general);
        init();
    }
	
	public void init()
	{
		SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
		Map<String,?> prefs = sharedPreferences.getAll();
		for(String key : prefs.keySet())
		{
			updateSummery(sharedPreferences, key);
		}
	}
	
	public void updateSummery(SharedPreferences sharedPreferences, String key)
	{
		Preference connectionPref = findPreference(key);
		String summery = null;
		if(connectionPref instanceof EditTextPreference || connectionPref instanceof ListPreference) {
			summery = sharedPreferences.getString(key, "");
		}
		
		if(summery != null) {
	        // Set summary to be the user-description for the selected value
	        connectionPref.setSummary(summery);
		}
	}
	
	
	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		updateSummery(sharedPreferences, key);
//        if (key.equals(getResources().getString(R.string.pref_default_display_name))) {
//        	
//        }
    }
	
	@Override
	public void onResume() {
	    super.onResume();
	    getPreferenceScreen().getSharedPreferences()
	            .registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onPause() {
	    super.onPause();
	    getPreferenceScreen().getSharedPreferences()
	            .unregisterOnSharedPreferenceChangeListener(this);
	}
}
