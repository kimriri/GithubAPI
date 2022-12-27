package com.programmers.githubapiMVC_00.View

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.programmers.githubapiMVC_00.ViewModel.Data.UsersData
import com.programmers.githubapi_00.databinding.UserItemBinding


class UsersAdapter: RecyclerView.Adapter<UsersAdapter.MyView>() {

    private var userList = mutableListOf<UsersData>()

    inner class MyView(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(currentUser: UsersData){
            binding.user = currentUser
//            binding.apply {
//                Glide.with(itemView)
//                    .load(userData.avatar_url)
//                    .transition(DrawableTransitionOptions.withCrossFade())
//                    .centerCrop()
//                    .into(usersItemImgPhoto)
//                usersItemTvName.text = userData.login
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
object BindingConversions {

    @JvmStatic
    fun loadImage(imageView : ImageView, url : String){
        Glide.with(imageView)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(imageView)
    }

}