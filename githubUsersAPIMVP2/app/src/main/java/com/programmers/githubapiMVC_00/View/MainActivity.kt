package com.programmers.githubapiMVC_00.View

import android.R
import android.os.Bundle
import android.view.View
import android.view.ViewManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmers.githubapiMVC_00.GithubService.Data.UsersData
import com.programmers.githubapiMVC_00.Presenter.MainContract
import com.programmers.githubapiMVC_00.Presenter.MainPresenter
import com.programmers.githubapi_00.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainContract.View {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var listAdapter: UsersAdapter
    private lateinit var presenter: MainContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listAdapter = UsersAdapter()
        presenter = MainPresenter(this)


        binding.ivMainSearch.setOnClickListener {
          presenter.callSearch(binding.etMain.text.toString())
        }

        binding.rvMain.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
    override fun resultSearch(items: MutableList<UsersData>) {
          listAdapter.setList(items)
          listAdapter.notifyDataSetChanged()
    }
}