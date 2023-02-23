package com.programmers.githubapiRepository.databinding;
import com.programmers.githubapiRepository.R;
import com.programmers.githubapiRepository.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class UserItemBindingImpl extends UserItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_like_btn, 3);
        sViewsWithIds.put(R.id.users_item_tv_line, 4);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public UserItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private UserItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.usersItemImgPhoto.setTag(null);
        this.usersItemTvName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.users == variableId) {
            setUsers((com.programmers.githubapiRepository.data.UsersData) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUsers(@Nullable com.programmers.githubapiRepository.data.UsersData Users) {
        this.mUsers = Users;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.users);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String usersAvatarUrl = null;
        com.programmers.githubapiRepository.data.UsersData users = mUsers;
        java.lang.String usersLogin = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (users != null) {
                    // read users.avatar_url
                    usersAvatarUrl = users.getAvatar_url();
                    // read users.login
                    usersLogin = users.getLogin();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.programmers.githubapiRepository.data.viewmodel.ImageViewBindingAdapterKt.profileImage(this.usersItemImgPhoto, usersAvatarUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.usersItemTvName, usersLogin);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): users
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}