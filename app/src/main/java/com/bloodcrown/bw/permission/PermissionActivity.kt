package com.bloodcrown.bw.permission

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bloodcrown.baselib.permission.PermissionManage
import com.bloodcrown.baselib.utils.intent.IntentUtils
import com.bloodcrown.bw.R
import kotlinx.android.synthetic.main.activity_permission.*

class PermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        btn_permission.setOnClickListener {

            PermissionManage
                    .with(this)
                    .permission(Manifest.permission.CALL_PHONE)
                    .permission(Manifest.permission.CAMERA)
                    .permission(Manifest.permission.READ_PHONE_STATE)
                    .onSuccess { Toast.makeText(this@PermissionActivity, "申请成功", Toast.LENGTH_SHORT).show() }
                    .onDenial { Toast.makeText(this@PermissionActivity, "用户拒绝", Toast.LENGTH_SHORT).show() }
                    .onDontShow { IntentUtils.startSettingActivityForResult(this, 200) }
                    .run()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 200) {

            var permissions = listOf(Manifest.permission.CALL_PHONE, Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE)
            if (PermissionManage.isHavePermissions(this, permissions)) {
                Toast.makeText(this, "欢迎您给予的权限", Toast.LENGTH_SHORT).show()
            } else {
                showDialog()
            }
        }
    }

    private fun showDialog() {

        var build: AlertDialog.Builder = AlertDialog.Builder(this)
        build.setMessage("缺乏权限，请求您给予权限")
        build.setPositiveButton("申请权限", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                IntentUtils.startSettingActivityForResult(this@PermissionActivity, 200)
                dialog?.dismiss()
//                dialog?.cancel()
            }
        })
        build.setNegativeButton("不给权限", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(this@PermissionActivity, "对不起，某些权限是必备选择，不给权限不能运行", Toast.LENGTH_SHORT).show()
                dialog?.dismiss()
                this@PermissionActivity.finish()
            }
        })
        build.show()
    }

}
