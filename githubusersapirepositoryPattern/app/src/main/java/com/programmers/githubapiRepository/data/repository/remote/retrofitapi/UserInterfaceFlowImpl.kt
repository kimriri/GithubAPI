package com.programmers.githubapiRepository.data.repository.remote.retrofitapi

import com.programmers.githubapiRepository.data.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class UserInterfaceFlowImpl(private val usersInterface: UsersInterface) : UserInterfaceFlow {
    override fun getUsers(string: String): Flow<Response<UserResponse>> = flow {
        emit(usersInterface.getUsers(string))
    }
}