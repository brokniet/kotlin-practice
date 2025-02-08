package com.example.firstkotlinpractice.data.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.firstkotlinpractice.ui.views.activities.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")//meter adentro de la clase?

class UserRepository @Inject constructor(
    private val context: Context
) {

    private val userKey = stringPreferencesKey("USER_KEY")

    public suspend fun updateUser(user: String) {
        context.dataStore.edit { settings ->
            settings[userKey] = user
        }
    }

    public suspend fun getUser(): String {
        val user = context.dataStore.data.map { settings ->
            settings[userKey] ?: ""
        }
        return user.first()
    }

}