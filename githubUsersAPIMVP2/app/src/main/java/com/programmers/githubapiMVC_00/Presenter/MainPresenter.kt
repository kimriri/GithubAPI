package com.programmers.githubapiMVC_00.Presenter

import android.util.Log
import com.programmers.githubapiMVC_00.GithubService.Data.UsersData
import com.programmers.githubapiMVC_00.Model.MainModel
import com.programmers.githubapiMVC_00.Presenter.MainContract.View
import retrofit2.Call
import retrofit2.Callback


class MainPresenter(var view : View) : MainContract.Presenter {

    var userlist : MutableList<UsersData> = mutableListOf()
    var mainModel: MainModel = MainModel()

    override fun callSearch(search: String)  {
        userlist =  mainModel.resultSearch(search)
        userlist =  mainModel.userList
        view.resultSearch(userlist)

    }

}