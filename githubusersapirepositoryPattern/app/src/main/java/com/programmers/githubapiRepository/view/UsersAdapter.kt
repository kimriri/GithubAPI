package com.programmers.githubapiRepository.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.databinding.UserItemBinding


class UsersAdapter(private val context: Context) : RecyclerView.Adapter<UsersAdapter.MyView>() {
    var userList = mutableListOf<UsersData>()
    private lateinit var binding: UserItemBinding
    private lateinit var itemClickListener: OnItemClickListener

    inner class MyView(binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentUser: UsersData) {
            binding.apply {
                binding.users = currentUser

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(binding)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(userList[position])
        binding.executePendingBindings()
        holder.itemView.setOnClickListener { itemClickListener.onClick(it, position) }
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun update(list: MutableList<UsersData>) {
        userList = list
        notifyDataSetChanged()
    }
}

