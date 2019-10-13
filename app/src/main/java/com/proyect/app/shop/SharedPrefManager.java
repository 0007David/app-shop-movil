package com.proyect.app.shop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Clase que Administrara las sesiones del usuario (SESION[''])
 * Decripcion:
 * En el lado de Android para mantener una sesión de inicio de sesión de usuario,
 * aquí estamos usando SharedPreferenes. Dentro de SharedPreferences almacenaremos
 * los datos del usuario actualmente conectado. Para que podamos usarlo en nuestra
 * aplicación. Entonces, para manejar todas las tareas de preferencias compartidas
 * en un lugar, tenemos esta clase llamada SharedPrefmanager.java.
 *
 */

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_EMAILVERIFIEDAT = "keyemailverifiedat";
    private static final String KEY_ADMIN = "keyadmin";
    private static final String KEY_CREATED_AT = "keycreateat";
    private static final String KEY_UPDATED_AT = "keyupdatedat";
    private static final String KEY_ID = "keyid";

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void userLogin(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getId());
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_EMAILVERIFIEDAT, user.getEmailVerifiedAt());
        editor.putString(KEY_ADMIN, user.getAdmin());
        editor.putString(KEY_CREATED_AT, user.getCreated_at());
        editor.putString(KEY_UPDATED_AT, user.getUpdated_at());
        editor.apply();
    }

    //Verifica si el usuario inicio Sesion
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null) != null;
    }

    //Metodo para Salir de la sesion
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, MainActivity.class));
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_EMAILVERIFIEDAT, null),
                sharedPreferences.getString(KEY_ADMIN, null),
                sharedPreferences.getString(KEY_CREATED_AT, null),
                sharedPreferences.getString(KEY_UPDATED_AT, null)
        );
    }



}
