package com.programmers.githubapimvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.programmers.githubapimvvm.data.UsersData
import com.programmers.githubapimvvm.databinding.UserItemBinding


class UsersAdapter: RecyclerView.Adapter<UsersAdapter.MyView>() {
    private var userList = mutableListOf<UsersData>()
    private lateinit var login : String
    private lateinit var avatar_url : String
    inner class MyView(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(currentUser: UsersData) {
            this.binding.users = currentUser
//            binding.apply {
//                Glide.with(itemView)
//                    .load(user.avatar_url)
//                    .transition(DrawableTransitionOptions.withCrossFade())
//                    .centerCrop()
//                    .into(usersItemImgPhoto)
//                usersItemTvName.text = user.login
//            }
        }



    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyView {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         //val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(binding)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setList(list: MutableLiveData<MutableList<UsersData>?>) {
        userList = list.value!!
        notifyDataSetChanged()
    }
}

