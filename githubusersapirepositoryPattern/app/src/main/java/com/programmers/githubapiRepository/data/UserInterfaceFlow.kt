package com.programmers.githubapiRepository.data

import com.programmers.githubapiRepository.data.UserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface UserInterfaceFlow {
    fun getUsers(string: String): Flow<Response<UserResponse>>
}