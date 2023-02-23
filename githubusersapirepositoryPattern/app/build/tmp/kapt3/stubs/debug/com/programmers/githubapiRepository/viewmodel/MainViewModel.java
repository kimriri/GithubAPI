package com.programmers.githubapiRepository.viewmodel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J&\u0010\u001c\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/programmers/githubapiRepository/viewmodel/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_apiHelper", "Lcom/programmers/githubapiRepository/data/UserInterfaceFlowImpl;", "_uiFlow", "Landroidx/lifecycle/MutableLiveData;", "Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow;", "_userList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/programmers/githubapiRepository/data/UsersData;", "uiFlow", "Landroidx/lifecycle/LiveData;", "getUiFlow", "()Landroidx/lifecycle/LiveData;", "userList", "Lkotlinx/coroutines/flow/StateFlow;", "getUserList", "()Lkotlinx/coroutines/flow/StateFlow;", "fetchUsers", "", "liveSearch", "", "context", "Landroid/content/Context;", "getLocal", "search", "saveLocal", "usersData", "UiFlow", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.programmers.githubapiRepository.data.UsersData>> _userList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.programmers.githubapiRepository.data.UsersData>> userList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.programmers.githubapiRepository.viewmodel.MainViewModel.UiFlow> _uiFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.programmers.githubapiRepository.viewmodel.MainViewModel.UiFlow> uiFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final com.programmers.githubapiRepository.data.UserInterfaceFlowImpl _apiHelper = null;
    
    public MainViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.programmers.githubapiRepository.data.UsersData>> getUserList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.programmers.githubapiRepository.viewmodel.MainViewModel.UiFlow> getUiFlow() {
        return null;
    }
    
    public final void fetchUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String liveSearch, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void saveLocal(java.util.List<com.programmers.githubapiRepository.data.UsersData> usersData, java.lang.String search, android.content.Context context) {
    }
    
    public final void getLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow;", "", "()V", "EmptyUserList", "ErrorMessage", "Init", "Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow$EmptyUserList;", "Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow$ErrorMessage;", "Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow$Init;", "app_debug"})
    public static abstract class UiFlow {
        
        private UiFlow() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow$EmptyUserList;", "Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow;", "()V", "app_debug"})
        public static final class EmptyUserList extends com.programmers.githubapiRepository.viewmodel.MainViewModel.UiFlow {
            @org.jetbrains.annotations.NotNull()
            public static final com.programmers.githubapiRepository.viewmodel.MainViewModel.UiFlow.EmptyUserList INSTANCE = null;
            
            private EmptyUserList() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow$ErrorMessage;", "Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "app_debug"})
        public static final class ErrorMessage extends com.programmers.githubapiRepository.viewmodel.MainViewModel.UiFlow {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.Throwable throwable = null;
            
            public ErrorMessage(@org.jetbrains.annotations.NotNull()
            java.lang.Throwable throwable) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.Throwable getThrowable() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow$Init;", "Lcom/programmers/githubapiRepository/viewmodel/MainViewModel$UiFlow;", "()V", "app_debug"})
        public static final class Init extends com.programmers.githubapiRepository.viewmodel.MainViewModel.UiFlow {
            @org.jetbrains.annotations.NotNull()
            public static final com.programmers.githubapiRepository.viewmodel.MainViewModel.UiFlow.Init INSTANCE = null;
            
            private Init() {
            }
        }
    }
}