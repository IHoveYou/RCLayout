package com.ztocwst.scm.engines.rclayout

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

/**
 * 作者 楼翔宇
 * CreateTime 2023/1/3011:44
 */
class RcLinearLayout(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {
    var build:RcBuild = RcBuild(context, attrs)
    set(value) {
        field = value
        background = field.getDrawable()
    }
    constructor( context: Context):this(context,null,0,0)
    constructor( context: Context,attrs: AttributeSet?):this(context,attrs,0,0)
    constructor( context: Context,attrs: AttributeSet?,defStyleAttr: Int):this(context,attrs,defStyleAttr,0)
    init {
        background = build.getDrawable()
    }





}