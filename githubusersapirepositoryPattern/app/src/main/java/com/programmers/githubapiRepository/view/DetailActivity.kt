package com.programmers.githubapiRepository.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.programmers.githubapiRepository.R
import com.programmers.githubapiRepository.data.UsersRoomData
import com.programmers.githubapiRepository.databinding.ActivityDetailBinding
import com.programmers.githubapiRepository.viewmodel.DetailViewModel
import com.programmers.githubapiRepository.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewmodel: DetailViewModel by viewModels()
    private val context: Context = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val userDetail = intent.getIntExtra("pos",0)
        val searchDetail = intent.getStringExtra("search")
        val userId  = intent.getStringExtra("user")
        observeDetailData(userId!!, context)

        binding.detailIvLikeBtn.setOnClickListener {
            lifecycleScope.launch {
               // viewmodel.getUserIndex(searchDetail!!, context)
            }
        }
    }

    // 클릭한 유저 이름
    private fun observeDetailData(userId: String, context: Context) {
        viewmodel.getUserIndex( userId, context)
        lifecycleScope.launch {
            viewmodel.userList.collectLatest {
                if (it.isNotEmpty()) {
                    val id = userId
                    userImg(intent.getStringExtra("avatar_url"))
                    binding.userItemTvName.text = intent.getStringExtra("user")
                    if (intent.getBooleanExtra("favorite",false)) binding.detailIvLikeBtn.setImageResource(R.drawable.baseline_favorite)
                    else binding.detailIvLikeBtn.setImageResource(R.drawable.baseline_favorite_border)
                }
            }
        }

    }

    fun userImg(url: String?) {
        Glide.with(this)
            .load(url)
            .apply(RequestOptions.centerCropTransform())
            .into(binding.userItemImgPhoto)

    }
}
