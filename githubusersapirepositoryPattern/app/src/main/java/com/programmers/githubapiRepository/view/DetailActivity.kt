package com.programmers.githubapiRepository.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.programmers.githubapiRepository.R
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.repository.local.MIGRATION_1_2
import com.programmers.githubapiRepository.data.repository.local.UserDatabase
import com.programmers.githubapiRepository.databinding.ActivityDetailBinding
import com.programmers.githubapiRepository.viewmodel.MainViewModel
import kotlinx.coroutines.runBlocking

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewmodel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val userDetail = intent.getStringExtra("user")
        val searchDetail = intent.getStringExtra("search")
        val urlDetail = intent.getStringExtra("url")


        val localUsersDB =
            Room.databaseBuilder(applicationContext, UserDatabase::class.java, searchDetail)
                .addMigrations(MIGRATION_1_2).build()
        runBlocking {
            if(localUsersDB.localUsersDataDao().getUser(userDetail!!).favorite){
                binding.detailIvLikeBtn.setImageResource(R.drawable.baseline_favorite)
            }else {
                binding.detailIvLikeBtn.setImageResource(R.drawable.baseline_favorite_border)
            }
            userImg(urlDetail)
            binding.userItemTvName.text = userDetail
        }

        binding.detailIvLikeBtn.setOnClickListener {   
            runBlocking {

                localUsersDB.localUsersDataDao().updateUser(UsersData(
                    localUsersDB.localUsersDataDao().getUser(userDetail!!).id,
                    localUsersDB.localUsersDataDao().getUser(userDetail).login,
                    localUsersDB.localUsersDataDao().getUser(userDetail).avatar_url,
                    !localUsersDB.localUsersDataDao().getUser(userDetail).favorite))
                val asdf = localUsersDB.localUsersDataDao().getUser(userDetail).favorite


                if(asdf){
                    binding.detailIvLikeBtn.setImageResource(R.drawable.baseline_favorite)
                }else {
                    binding.detailIvLikeBtn.setImageResource(R.drawable.baseline_favorite_border)
                }
                Log.d("ASDF","ASDF");

            }
        }
    }


     fun userImg(let: String?) {
         Glide.with(this)
             .load(let)
             .apply(RequestOptions.centerCropTransform())
             .into(binding.userItemImgPhoto)

     }
}
