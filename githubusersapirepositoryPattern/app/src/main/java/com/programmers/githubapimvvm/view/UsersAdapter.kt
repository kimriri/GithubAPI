package com.programmers.githubapimvvm.view

import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.programmers.githubapimvvm.data.repository.UsersData
import com.programmers.githubapimvvm.databinding.UserItemBinding



class UsersAdapter(private val context: List<Any>) : RecyclerView.Adapter<UsersAdapter.MyView>() {
     var userList = mutableListOf<UsersData>()

    private lateinit var binding: UserItemBinding

    inner class MyView(binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(currentUser: UsersData) {
            binding.apply {
                binding.users = currentUser
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyView {
        binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(binding)
    }


    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(userList[position])
         binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun update(list: MutableList<UsersData>) {
        userList = list
        notifyDataSetChanged()

    }
}

