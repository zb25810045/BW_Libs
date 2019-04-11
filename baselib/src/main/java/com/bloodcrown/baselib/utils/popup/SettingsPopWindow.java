package com.bloodcrown.baselib.utils.popup;

import android.widget.PopupWindow;

public class SettingsPopWindow extends PopupWindow {
//    private View contentView;
//    private MainActivity activity;
//    private DisplayMetrics dm = new DisplayMetrics();
//
//    public SettingsPopWindow(final MainActivity context, View ctView) {
//        super(ctView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
//        contentView = ctView;
//        activity = context;
//        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
//        // 设置SelectPicPopupWindow的View
////        this.setContentView(contentView);
////        // // 设置SelectPicPopupWindow弹出窗体的宽
////        this.setWidth(LayoutParams.WRAP_CONTENT);
////        // // 设置SelectPicPopupWindow弹出窗体的高
////        this.setHeight(LayoutParams.WRAP_CONTENT);
////        // 设置SelectPicPopupWindow弹出窗体可点击
////        this.setFocusable(true);
//        this.setOutsideTouchable(true);
//        // 刷新状态
//        this.update();
//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0x000000);
//        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
//        this.setBackgroundDrawable(dw);
//        this.setAnimationStyle(android.R.style.Animation_Dialog);
//        final RadioButton rbHori = (RadioButton) contentView.findViewById(R.id.rb_setting_hori);
//        final RadioButton rbVerti = (RadioButton) contentView.findViewById(R.id.rb_setting_verti);
//        boolean isPortrait = SharedPrefsStore.isDefaultPortrait(context);
//        if (isPortrait) {
//            rbVerti.setChecked(true);
//        } else {
//            rbHori.setChecked(true);
//        }
//
//        final RadioButton rbSimple = (RadioButton) contentView.findViewById(R.id.rb_setting_controlbar_simple);
//        final RadioButton rbAdvance = (RadioButton) contentView.findViewById(R.id.rb_setting_controlbar_advanced);
//        boolean isSimple = SharedPrefsStore.isControllBarSimple(context);
//        if (isSimple) {
//            rbSimple.setChecked(true);
//        } else {
//            rbAdvance.setChecked(true);
//        }
//
//        contentView.findViewById(R.id.tv_pop_close).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                dismiss();
//            }
//        });
//        contentView.findViewById(R.id.btn_confirm).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                SharedPrefsStore.setDefaultOrientation(contentView.getContext(), rbVerti.isChecked());
//                SharedPrefsStore.setControllBar(contentView.getContext(), rbSimple.isChecked());
//                dismiss();
//            }
//        });
//    }
//
//    public static SettingsPopWindow createSettingsPopWindow(final MainActivity context) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View ctView = inflater.inflate(R.layout.pop_window_settings, null);
//        SettingsPopWindow rtPopWindow = new SettingsPopWindow(context, ctView);
//        return rtPopWindow;
//    }
//
//    @Override
//    public void dismiss() {
//        super.dismiss();
//        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
//        lp.alpha = 1f;
//        activity.getWindow().setAttributes(lp);
//    }
//
//    /**
//     * 显示popupWindow
//     *
//     */
//    public void showPopupWindow() {
//        if (!this.isShowing()) {
//            // 以下拉方式显示popupwindow
//            this.showAtLocation(activity.findViewById(R.id.rl_main), Gravity.CENTER, 0, 0);
//            WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
//            lp.alpha = 0.3f;
//            activity.getWindow().setAttributes(lp);
//        } else {
//            this.dismiss();
//        }
//    }
}
