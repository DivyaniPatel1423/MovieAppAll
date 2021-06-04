package com.moviewapp.trailorapp.data.repository

import com.moviewapp.trailorapp.data.network.BaseApi
import com.moviewapp.trailorapp.data.network.SafeApiCall


abstract class BaseRepository(private val api: BaseApi) : SafeApiCall {
  /*  suspend fun logout() = safeApiCall {
        api.logout()
    }*/
}