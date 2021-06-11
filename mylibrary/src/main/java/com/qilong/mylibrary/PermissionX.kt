package com.qilong.mylibrary

import androidx.fragment.app.FragmentActivity

object PermissionX {
    private const val TAG="InvisibleFragment"
    fun request(acivity:FragmentActivity,vararg permissions:String,callback:PermissionCallback){
        val fragmentManager = acivity.supportFragmentManager
        val exisedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(exisedFragment !=null){
            exisedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)
    }
}