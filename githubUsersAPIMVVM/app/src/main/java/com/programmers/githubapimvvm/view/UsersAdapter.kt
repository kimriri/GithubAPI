package com.programmers.githubapimvvm.view

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.programmers.githubapimvvm.viewmodel.Data.UsersData
import com.programmers.githubapi_00.databinding.UserItemBinding
import com.programmers.githubapimvvm.viewmodel.MainViewModel
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.programmers.githubapi_00.R
import com.programmers.githubapi_00.databinding.ActivityMainBinding


class UsersAdapter: RecyclerView.Adapter<UsersAdapter.MyView>() {
    private var userList = mutableListOf<UsersData>()
    inner class MyView(private var binding: UserItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(currentUser: UsersData) {

                bindingAdapter.apply {
                    binding.user = currentUser

                }


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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
         val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(binding)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setList(userlist: MutableLiveData<MutableList<UsersData>?>) {
        userList = userlist.value!!
        notifyDataSetChanged()
    }
}

