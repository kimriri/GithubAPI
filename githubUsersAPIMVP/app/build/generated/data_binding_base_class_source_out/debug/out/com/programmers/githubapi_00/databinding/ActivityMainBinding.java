// Generated by view binder compiler. Do not edit!
package com.programmers.githubapi_00.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.programmers.githubapi_00.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText etMain;

  @NonNull
  public final ImageView ivMainSearch;

  @NonNull
  public final RecyclerView rvMain;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull EditText etMain,
      @NonNull ImageView ivMainSearch, @NonNull RecyclerView rvMain) {
    this.rootView = rootView;
    this.etMain = etMain;
    this.ivMainSearch = ivMainSearch;
    this.rvMain = rvMain;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.et_main;
      EditText etMain = ViewBindings.findChildViewById(rootView, id);
      if (etMain == null) {
        break missingId;
      }

      id = R.id.iv_main_search;
      ImageView ivMainSearch = ViewBindings.findChildViewById(rootView, id);
      if (ivMainSearch == null) {
        break missingId;
      }

      id = R.id.rv_main;
      RecyclerView rvMain = ViewBindings.findChildViewById(rootView, id);
      if (rvMain == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, etMain, ivMainSearch, rvMain);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
