package br.com.futebolnatv.data.onboarding.datasource
import android.content.SharedPreferences
import javax.inject.Inject

interface OnboardingLocalDataSource {
    fun isFirstTime(): Boolean
    fun insertFirstTime(isFirstTime: Boolean)
}

class OnboardingLocalDataSourceImpl @Inject constructor(
    private val sharedPref: SharedPreferences
): OnboardingLocalDataSource {

    private val FIRST_ACCESS = "first_access"

    override fun isFirstTime() = sharedPref.getBoolean(FIRST_ACCESS, false)

    override fun insertFirstTime(firstAccess: Boolean) {
        val editor = sharedPref.edit()
        editor.putBoolean(FIRST_ACCESS, firstAccess)
        editor.apply()
    }
}