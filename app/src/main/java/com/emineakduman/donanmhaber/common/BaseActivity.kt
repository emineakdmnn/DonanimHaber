package com.emineakduman.donanmhaber.common

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders


abstract class BaseActivity<DB: ViewDataBinding, VM: ViewModel>: AppCompatActivity(){
    lateinit var dataBinding: DB
    lateinit var viewModel: VM

    @LayoutRes
    abstract fun getLayoutsRes(): Int

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding= DataBindingUtil.setContentView(this,getLayoutsRes())
        viewModel = ViewModelProviders.of(this).get(getViewModel())
    }
}