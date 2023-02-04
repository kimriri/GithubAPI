package com.programmers.githubapiRepository.view

import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.programmers.githubapiRepository.R
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
     //   val dbnameDetail = intent.getStringExtra("dbname")


        val localUsersDB = Room.databaseBuilder(applicationContext, UserDatabase::class.java, searchDetail).addMigrations(MIGRATION_1_2).build()
            runBlocking {
                userImg(userDetail?.let { localUsersDB.localUsersDataDao().getUser(it).avatar_url })
                binding.userItemTvName.text = userDetail?.let { localUsersDB.localUsersDataDao().getUser(it).login } }

//        binding.detailIvLikeBtn.setOnClickListener {
//            runBlocking {
//              //  localUsersDB.localUsersDataDao().insert()
//
//            }
//        }

    }
     fun userImg(let: String?) {
         Glide.with(this)
             .load(let)
             .apply(RequestOptions.centerCropTransform())
             .into(binding.userItemImgPhoto)

     }
}
