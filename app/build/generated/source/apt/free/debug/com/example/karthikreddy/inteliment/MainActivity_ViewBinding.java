// Generated code from Butter Knife. Do not modify!
package com.example.karthikreddy.inteliment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165243;

  private View view2131165188;

  private View view2131165222;

  private View view2131165225;

  private View view2131165214;

  private View view2131165256;

  private View view2131165263;

  private View view2131165293;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.textView = Utils.findRequiredViewAsType(source, R.id.actionText, "field 'textView'", TextView.class);
    target.relativeLayout = Utils.findRequiredViewAsType(source, R.id.mainRelativeLayout, "field 'relativeLayout'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.greenButton, "method 'onGreenButtonClicked'");
    view2131165243 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onGreenButtonClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.RedButton, "method 'onRedButtonClicked'");
    view2131165188 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRedButtonClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.blueButton, "method 'onBlueButtonClicked'");
    view2131165222 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBlueButtonClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.camera, "method 'onCameraClicked'");
    view2131165225 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCameraClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.alarm, "method 'onAlarmClicked'");
    view2131165214 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAlarmClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.location, "method 'onLocationClicked'");
    view2131165256 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLocationClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.music, "method 'onMusicClicked'");
    view2131165263 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onMusicClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.settings, "method 'onSettingsClicked'");
    view2131165293 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSettingsClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textView = null;
    target.relativeLayout = null;

    view2131165243.setOnClickListener(null);
    view2131165243 = null;
    view2131165188.setOnClickListener(null);
    view2131165188 = null;
    view2131165222.setOnClickListener(null);
    view2131165222 = null;
    view2131165225.setOnClickListener(null);
    view2131165225 = null;
    view2131165214.setOnClickListener(null);
    view2131165214 = null;
    view2131165256.setOnClickListener(null);
    view2131165256 = null;
    view2131165263.setOnClickListener(null);
    view2131165263 = null;
    view2131165293.setOnClickListener(null);
    view2131165293 = null;
  }
}
