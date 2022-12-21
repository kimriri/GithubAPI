package com.programmers.githubapiMVC_00.Presenter

import com.programmers.githubapiMVC_00.Model.Data.UsersData

interface MainContract {

     interface View {
        fun resultSearch(userList: ArrayList<UsersData>)
    }

      interface Presenter {
        fun callSearch(search: String)
    }
}