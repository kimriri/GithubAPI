package com.programmers.githubapiMVC_00.Presenter

import android.util.Log
import com.programmers.githubapiMVC_00.GithubService.Data.UsersData
import com.programmers.githubapiMVC_00.Model.MainModel
import com.programmers.githubapiMVC_00.Presenter.MainContract.View
import retrofit2.Call
import retrofit2.Callback


class MainPresenter(var view : View) : MainContract.Presenter {

    var userlist = ArrayList<UsersData>()
    var mainModel: MainModel = MainModel(this)

    override fun callSearch(search: String)  {
       mainModel.saveData(search)
    }

    override fun getSearch() {
        view.resultSearch(userlist)
    }
    override fun setSearch(userList: ArrayList<UsersData>) {
        userlist =  userList
        getSearch()

    }
}