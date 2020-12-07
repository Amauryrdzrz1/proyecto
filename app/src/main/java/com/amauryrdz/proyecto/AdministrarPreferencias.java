package com.amauryrdz.proyecto;

import android.content.Context;
import android.content.SharedPreferences;

public class AdministrarPreferencias {
    Context context;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    private static final String PREF_NAME = "com.amauryrdz.proyecto";
    public static final String KEY_ID = "id";
    public static final String KEY_ACCESS_TOKEN = "access_token";

    public AdministrarPreferencias(Context context) {

        this.context = context;

        sharedPreferences = context.getSharedPreferences(PREF_NAME,   Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();

        editor.apply();

    }

    public void putString(String key, String value) {

        editor.putString(key, value);

        editor.apply();

    }

    public String getString(String key) {

        return sharedPreferences.getString(key, null);

    }

    public void clearLoginData() {

        editor.remove(KEY_ID);
        editor.remove(KEY_ACCESS_TOKEN);
        editor.apply();

    }

}
