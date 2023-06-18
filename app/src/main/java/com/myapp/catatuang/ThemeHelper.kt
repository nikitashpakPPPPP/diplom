import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class ThemeHelper(private val context: Context) {

    private val lightMode = "light_mode"
    private val darkMode = "dark_mode"

    fun getCurrentTheme(): Int {
        return when (getSavedTheme()) {
            lightMode -> AppCompatDelegate.MODE_NIGHT_NO
            darkMode -> AppCompatDelegate.MODE_NIGHT_YES
            else -> AppCompatDelegate.MODE_NIGHT_UNSPECIFIED
        }
    }

    fun toggleTheme(activity: Activity) {
        val currentTheme = getSavedTheme()
        val newTheme = when (currentTheme) {
            lightMode -> darkMode
            darkMode -> lightMode
            else -> lightMode
        }
        setTheme(newTheme)
        activity.recreate()
    }

    private fun setTheme(theme: String) {
        val sharedPreferences = context.getSharedPreferences("APP_THEME", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("THEME", theme).apply()
    }

    private fun getSavedTheme(): String {
        val sharedPreferences = context.getSharedPreferences("APP_THEME", Context.MODE_PRIVATE)
        return sharedPreferences.getString("THEME", lightMode) ?: lightMode
    }
}