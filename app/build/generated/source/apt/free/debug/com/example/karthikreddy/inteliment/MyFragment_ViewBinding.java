// Generated code from Butter Knife. Do not modify!
package com.example.karthikreddy.inteliment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyFragment_ViewBinding implements Unbinder {
  private MyFragment target;

  private View view2131165313;

  @UiThread
  public MyFragment_ViewBinding(final MyFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.textView, "method 'onClicked'");
    view2131165313 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131165313.setOnClickListener(null);
    view2131165313 = null;
  }
}
