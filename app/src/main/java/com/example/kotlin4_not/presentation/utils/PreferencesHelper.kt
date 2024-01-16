package com.example.noteapp.utils

import android.content.Context
import com.example.kotlin4_not.R


private const val IS_SHOWN_ON_BOARD_KEY = "isShownOnBoard"

class PreferencesHelper(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        context.getString(R.string.shared_preferences_name),
        Context.MODE_PRIVATE
    )

    var isShownOnBoard: Boolean
        get() = sharedPreferences.getBoolean(IS_SHOWN_ON_BOARD_KEY, false)
        set(value) {
            sharedPreferences.edit().putBoolean(IS_SHOWN_ON_BOARD_KEY, value).apply()
        }
}