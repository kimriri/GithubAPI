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
import com.programmers.githubapiRepository.databinding.ActivityDetailBinding
import com.programmers.githubapiRepository.viewmodel.DetailViewModel
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
        observeDetailData(userDetail, context)

        binding.detailIvLikeBtn.setOnClickListener {
            lifecycleScope.launch {
                viewmodel.getUserIndex(searchDetail!!, context)
            }
        }
    }

    private fun observeDetailData(searchDetail: Int, context: Context) {
        //viewmodel.userList.value[searchDetail]
        viewmodel.getUserIndex(viewmodel.userList.value[searchDetail].login, context)
        lifecycleScope.launch {
            viewmodel.userList.collectLatest {
                if (it.isNotEmpty()) {
                    val id = viewmodel.userList.value[searchDetail]
                    userImg(id.avatar_url)
                    binding.userItemTvName.text = id.login
                    if (id.favorite) binding.detailIvLikeBtn.setImageResource(R.drawable.baseline_favorite)
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
