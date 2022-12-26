package com.programmers.githubapiMVC_00.Presenter

import com.programmers.githubapiMVC_00.GithubService.Data.UsersData


interface MainContract {

     interface View {
         fun resultSearch(userList: MutableList<UsersData>)
    }

      interface Presenter {
        fun callSearch(search: String)
    }
}