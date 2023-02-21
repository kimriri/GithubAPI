package com.programmers.githubapiRepository.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.programmers.githubapiRepository.R
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.databinding.ActivityDetailBinding
import com.programmers.githubapiRepository.viewmodel.DetailViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewmodel: DetailViewModel by viewModels()
    private val context: Context = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val userDetail = intent.getIntExtra("pos", 0)
        val searchDetail = intent.getStringExtra("search")
        val userId = intent.getStringExtra("user")
        val avatar_url = intent.getStringExtra("avatar_url")
        val favorite = intent.getBooleanExtra("favorite", false)
        viewmodel.getUserList(context)
        observeDetailData(userDetail, userId!!, context)

        binding.detailIvLikeBtn.setOnClickListener {

            lifecycleScope.launch {
                val changefavorite = !viewmodel.userListAll.value[userDetail].favorite
                val userData = UsersData(userDetail, searchDetail!!, userId, avatar_url!!, changefavorite)
                Log.e("ASDF", viewmodel.userListAll.value[userDetail].favorite.toString())
             //  setfavorite(changefavorite)
                // 옵저버로 구독하고 있기 .. .
                viewmodel.updateUser(userData, applicationContext)
                requestInvalidUsersEvent(changefavorite)

            }

        }
    }

    // 클릭한 유저 이름
    private fun observeDetailData(userDetail: Int, userId: String, context: Context) {
        lifecycleScope.launch {

            viewmodel.userListAll.collectLatest {
                if (it.isNotEmpty()) {
                    userImg(intent.getStringExtra("avatar_url"))
                    binding.userItemTvName.text = intent.getStringExtra("user")
                }
            }
        }

    }

    fun setfavorite(favorite: Boolean) {
        if (favorite) binding.detailIvLikeBtn.setImageResource(R.drawable.baseline_favorite)
        else binding.detailIvLikeBtn.setImageResource(R.drawable.baseline_favorite_border)

    }

    fun userImg(url: String?) {
        Glide.with(this)
            .load(url)
            .apply(RequestOptions.centerCropTransform())
            .into(binding.userItemImgPhoto)

    }

    private fun requestInvalidUsersEvent(favorite: Boolean) {
        viewmodel.uiFlow.observe(this, Observer {
            setfavorite(favorite)
        })
    }
}


