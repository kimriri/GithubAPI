package com.programmers.githubapiRepository.viewmodel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/programmers/githubapiRepository/viewmodel/DetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_uiFlow", "Landroidx/lifecycle/MutableLiveData;", "Lcom/programmers/githubapiRepository/viewmodel/UiFlow;", "_userList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/programmers/githubapiRepository/data/UsersData;", "_userListAll", "uiFlow", "Landroidx/lifecycle/LiveData;", "getUiFlow", "()Landroidx/lifecycle/LiveData;", "userList", "Lkotlinx/coroutines/flow/StateFlow;", "getUserList", "()Lkotlinx/coroutines/flow/StateFlow;", "userListAll", "getUserListAll", "", "context", "Landroid/content/Context;", "updateUser", "user", "app_debug"})
public final class DetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.programmers.githubapiRepository.data.UsersData>> _userListAll = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.programmers.githubapiRepository.data.UsersData>> userListAll = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.programmers.githubapiRepository.data.UsersData>> _userList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.programmers.githubapiRepository.data.UsersData>> userList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.programmers.githubapiRepository.viewmodel.UiFlow> _uiFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.programmers.githubapiRepository.viewmodel.UiFlow> uiFlow = null;
    
    public DetailViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.programmers.githubapiRepository.data.UsersData>> getUserListAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.programmers.githubapiRepository.data.UsersData>> getUserList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.programmers.githubapiRepository.viewmodel.UiFlow> getUiFlow() {
        return null;
    }
    
    public final void getUserList(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void updateUser(@org.jetbrains.annotations.NotNull()
    com.programmers.githubapiRepository.data.UsersData user, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}