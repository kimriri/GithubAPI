package com.programmers.githubapiRepository.viewmodel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/programmers/githubapiRepository/viewmodel/UiFlow;", "", "()V", "EmptyUserList", "Favorite", "Init", "Lcom/programmers/githubapiRepository/viewmodel/UiFlow$EmptyUserList;", "Lcom/programmers/githubapiRepository/viewmodel/UiFlow$Favorite;", "Lcom/programmers/githubapiRepository/viewmodel/UiFlow$Init;", "app_debug"})
public abstract class UiFlow {
    
    private UiFlow() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/programmers/githubapiRepository/viewmodel/UiFlow$EmptyUserList;", "Lcom/programmers/githubapiRepository/viewmodel/UiFlow;", "()V", "app_debug"})
    public static final class EmptyUserList extends com.programmers.githubapiRepository.viewmodel.UiFlow {
        @org.jetbrains.annotations.NotNull()
        public static final com.programmers.githubapiRepository.viewmodel.UiFlow.EmptyUserList INSTANCE = null;
        
        private EmptyUserList() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/programmers/githubapiRepository/viewmodel/UiFlow$Favorite;", "Lcom/programmers/githubapiRepository/viewmodel/UiFlow;", "favorite", "", "(Z)V", "getFavorite", "()Z", "app_debug"})
    public static final class Favorite extends com.programmers.githubapiRepository.viewmodel.UiFlow {
        private final boolean favorite = false;
        
        public Favorite(boolean favorite) {
        }
        
        public final boolean getFavorite() {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/programmers/githubapiRepository/viewmodel/UiFlow$Init;", "Lcom/programmers/githubapiRepository/viewmodel/UiFlow;", "()V", "app_debug"})
    public static final class Init extends com.programmers.githubapiRepository.viewmodel.UiFlow {
        @org.jetbrains.annotations.NotNull()
        public static final com.programmers.githubapiRepository.viewmodel.UiFlow.Init INSTANCE = null;
        
        private Init() {
        }
    }
}