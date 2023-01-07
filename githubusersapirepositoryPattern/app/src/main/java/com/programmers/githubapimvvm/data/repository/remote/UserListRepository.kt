package com.programmers.githubapimvvm.data.repository.remote

import com.programmers.githubapimvvm.data.UserResponse
import com.programmers.githubapimvvm.data.repository.remote.retrofitapi.UsersServiceManager
import retrofit2.Response

class UserListRepository() {
    suspend fun getUser(userId: String): Response<UserResponse> {
        return UsersServiceManager.getRetrofitService.getUsers(userId)
    }
}