package com.programmers.githubapi_00

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.programmers.githubapi_00.R
import com.programmers.githubapi_00.UsersData
import com.programmers.githubapi_00.databinding.UserItemBinding


class UsersAdapter: RecyclerView.Adapter<UsersAdapter.MyView>() {
    private var userList = listOf<UsersData>()

    inner class MyView(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: UsersData){
            binding.apply {
                Glide.with(itemView)
                    .load(userData.avatar_url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(usersItemImgPhoto)
                usersItemTvName.text = userData.login
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setList(list: List<UsersData>) {
        userList = list
    }
}