package com.example.koichung.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfig {
    public static String SHARED_PREFERENCES_NAME = "koichung";

    static SharedPreferences.Editor getEditor (Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.edit();
    }

    static SharedPreferences getSharedPrefenreces(Context context){
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);

    }

    public static void setUserId(int userId, Context context){
        getEditor(context).putInt("userId",userId).apply();
    }

    public static int getUserId(Context context){
        return getSharedPrefenreces(context).getInt("userId",0);
    }

    public static void setKeepLogin(Boolean isKeepLogin, Context context){
        getEditor(context).putBoolean("is_keep_login",isKeepLogin).apply();
    }

    public static Boolean getKeepLogin(Context context){
       return getSharedPrefenreces(context).getBoolean("is_keep_login",false);
    }
}
