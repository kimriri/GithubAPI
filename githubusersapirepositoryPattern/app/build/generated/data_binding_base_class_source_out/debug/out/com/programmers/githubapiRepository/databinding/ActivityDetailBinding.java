// Generated by data binding compiler. Do not edit!
package com.programmers.githubapiRepository.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.programmers.githubapiRepository.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityDetailBinding extends ViewDataBinding {
  @NonNull
  public final ImageView detailIvLikeBtn;

  @NonNull
  public final ImageView userItemImgPhoto;

  @NonNull
  public final TextView userItemTvName;

  protected ActivityDetailBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView detailIvLikeBtn, ImageView userItemImgPhoto, TextView userItemTvName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.detailIvLikeBtn = detailIvLikeBtn;
    this.userItemImgPhoto = userItemImgPhoto;
    this.userItemTvName = userItemTvName;
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_detail, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityDetailBinding>inflateInternal(inflater, R.layout.activity_detail, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_detail, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityDetailBinding>inflateInternal(inflater, R.layout.activity_detail, null, false, component);
  }

  public static ActivityDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityDetailBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityDetailBinding)bind(component, view, R.layout.activity_detail);
  }
}
