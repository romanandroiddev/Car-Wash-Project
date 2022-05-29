package uz.project.mycarwashproject.model.local

import android.content.Context
import android.content.SharedPreferences
import uz.project.mycarwashproject.utils.BooleanPreference
import uz.project.mycarwashproject.utils.StringPreference
import kotlin.random.Random

class SharePref(context: Context) {
    private val pref: SharedPreferences =
        context.getSharedPreferences("sharePref", Context.MODE_PRIVATE)

    var getIsSignUp: Boolean by BooleanPreference(pref, true)
    var profileId: String by StringPreference(pref, "Telefonnomer")
}