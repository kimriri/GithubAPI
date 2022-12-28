package com.programmers.githubapimvvm.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.programmers.githubapi_00.databinding.UserItemBinding
import com.programmers.githubapimvvm.viewmodel.data.usersdata


class usersadapter: RecyclerView.Adapter<usersadapter.myview>() {
    private var userList = mutableListOf<com.programmers.githubapimvvm.viewmodel.data.usersdata>()
    inner class myview(private var binding: UserItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(currentUser: com.programmers.githubapimvvm.viewmodel.data.usersdata?) {
            binding.apply {
                Log.e("ASDFASDF",currentUser.toString());
                binding.usersdata = currentUser?.copy(
                    login = usersdata.login,
                    avatar_url = usersdata.avatar_url
                )
               // binding.profile.setProfileUrl(binding.usersItemImgPhoto,currentUser.avatar_url)

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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myview {
         val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myview(binding)
    }

    override fun onBindViewHolder(holder: myview, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setList(userlist: MutableLiveData<MutableList<usersdata>?>) {
        userList = userlist.value!!
        notifyDataSetChanged()
    }
}

