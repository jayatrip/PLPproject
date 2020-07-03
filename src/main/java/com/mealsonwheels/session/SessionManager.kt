package com.mealsonwheels.session

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.mealsonwheels.ui.auth.MainActivity


class SessionManager(context: Context) {

    lateinit var pref: SharedPreferences


    lateinit var editor: SharedPreferences.Editor


    lateinit var _context: Context


    var PRIVATE_MODE = 0


    private val PREF_NAME = "mealsonwheels"


    private val IS_LOGIN = "IsLoggedIn"


    val KEY_PASSWORD = "password"


    val KEY_EMAIL = "email"
    val KEY_UID = "uid"
    val KEY_DOCUMENT_USER_ID = "document_user_id"

    init {
        this._context = context
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }


    fun createLoginSession(password: String, email: String, uid: String) {

        editor.putBoolean(IS_LOGIN, true)


        editor.putString(KEY_PASSWORD, password)


        editor.putString(KEY_EMAIL, email)


        editor.putString(KEY_UID, uid)


        editor.commit()
    }



    fun checkLogin() {

        if (!this.isLoggedIn()) {

            val i = Intent(_context, MainActivity::class.java)

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)


            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK


            _context.startActivity(i)
        }

    }



    fun getUserDetails(): HashMap<String, String> {
        val user = HashMap<String, String>()

        user[KEY_PASSWORD] = pref.getString(KEY_PASSWORD, null)


        user[KEY_EMAIL] = pref.getString(KEY_EMAIL, null)

        user[KEY_UID] = pref.getString(KEY_UID, null)


        return user
    }


    fun getUID(): String {
        return pref.getString(KEY_UID, null)
    }


    fun logoutUser() {

        editor.clear()
        editor.commit()


        val i = Intent(_context, MainActivity::class.java)

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK


        _context.startActivity(i)
    }




    fun isLoggedIn(): Boolean {
        return pref.getBoolean(IS_LOGIN, false)
    }

    fun setUserDocumentId(documentId: String) {
        editor.putString(KEY_DOCUMENT_USER_ID, documentId);
        editor.commit()
    }

    fun getUserDocumentId(): String {
        return pref.getString(KEY_DOCUMENT_USER_ID, null)
    }

}