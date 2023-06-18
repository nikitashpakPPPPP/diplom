package com.myapp.catatuang

import android.content.Context
import java.util.*

class LocaleManager {

    companion object {
        private const val PREFERENCES_NAME = "LocalePrefs"
        private const val PREFERENCES_LANGUAGE_KEY = "language"


        fun setLocale(context: Context, language: String) {
            val locale = Locale(language)
            Locale.setDefault(locale)

            val configuration = context.resources.configuration
            configuration.setLocale(locale)
            context.createConfigurationContext(configuration)

            // Сохраняем выбранный язык в SharedPreferences
            val preferences = context.getSharedPreferences(
                PREFERENCES_NAME,
                Context.MODE_PRIVATE
            )
            preferences.edit().putString(PREFERENCES_LANGUAGE_KEY, language).apply()
        }


        fun getLocale(context: Context): String {
            val preferences = context.getSharedPreferences(
                PREFERENCES_NAME,
                Context.MODE_PRIVATE
            )
            return preferences.getString(PREFERENCES_LANGUAGE_KEY, Locale.getDefault().language)
                ?: Locale.getDefault().language
        }
    }
}