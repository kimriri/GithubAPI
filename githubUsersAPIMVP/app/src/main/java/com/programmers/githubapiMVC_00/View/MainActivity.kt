package com.programmers.githubapiMVC_00.View

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmers.githubapiMVC_00.Model.Data.UsersData
import com.programmers.githubapiMVC_00.Presenter.MainContract
import com.programmers.githubapiMVC_00.Presenter.MainPresenter
import com.programmers.githubapi_00.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainContract.View {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var listAdapter: UsersAdapter
    var userList = ArrayList<UsersData>()
    var presenter: MainContract.Presenter? = null

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
         presenter = MainPresenter(this)

        listAdapter = UsersAdapter()

        binding.ivMainSearch.setOnClickListener {
            (presenter as MainPresenter).callSearch(binding.etMain.text.toString())
        }


        binding.rvMain.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

    }

    override fun resultSearch(items: ArrayList<UsersData>) {
          listAdapter.setList(items)
          listAdapter.notifyDataSetChanged()
    }
}