package com.louxiangyu.widget.rclayout

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import com.louxiangyu.wdiget.rclayout.R

/**
 * 作者 楼翔宇
 * CreateTime 2023/1/3011:47
 */
class RcBuild {
    var  backgroundColor:Int = 0
    var  cornerRadius:Float = 0f
    var  leftTopRadius:Float = 0f
    var  leftBotRadius:Float = 0f
    var  rightTopRadius:Float = 0f
    var  rightBotRadius:Float = 0f
    var  stroke:Int = 0
    var  strokeColor:Int = 0
    var  startColor:Int = 0
    var  endColor:Int = 0
    var  orientation: GradientDrawable.Orientation = GradientDrawable.Orientation.LEFT_RIGHT
    //渐变色,渐变色不为空时显示渐变色
    var  gradientColors = arrayListOf<Int>()
    constructor(context: Context?,attrs: AttributeSet?){
        if (context==null || attrs == null)
            return
        val attrs = context.obtainStyledAttributes(attrs,R.styleable.RcConstraintLayout)
        backgroundColor = attrs.getColor(R.styleable.RcConstraintLayout_rc_backgroundColor,backgroundColor)
        cornerRadius = attrs.getDimension(R.styleable.RcConstraintLayout_rc_cornerRadius,cornerRadius)
        leftTopRadius = attrs.getDimension(R.styleable.RcConstraintLayout_rc_leftTopRadius,leftTopRadius)
        leftBotRadius = attrs.getDimension(R.styleable.RcConstraintLayout_rc_leftBotRadius,leftBotRadius)
        rightTopRadius = attrs.getDimension(R.styleable.RcConstraintLayout_rc_rightTopRadius,rightTopRadius)
        rightBotRadius = attrs.getDimension(R.styleable.RcConstraintLayout_rc_rightBotRadius,rightBotRadius)
        stroke = attrs.getDimension(R.styleable.RcConstraintLayout_rc_stroke,0f).toInt()
        strokeColor = attrs.getColor(R.styleable.RcConstraintLayout_rc_strokeColor,strokeColor)
        startColor = attrs.getColor(R.styleable.RcConstraintLayout_rc_startColor,startColor)
        endColor = attrs.getColor(R.styleable.RcConstraintLayout_rc_endColor,endColor)
        orientation = when(attrs.getInt(R.styleable.RcConstraintLayout_rc_orientation,6)){
            0->GradientDrawable.Orientation.TOP_BOTTOM
            1->GradientDrawable.Orientation.TR_BL
            2->GradientDrawable.Orientation.RIGHT_LEFT
            3->GradientDrawable.Orientation.BR_TL
            4->GradientDrawable.Orientation.BOTTOM_TOP
            5->GradientDrawable.Orientation.BL_TR
            6->GradientDrawable.Orientation.LEFT_RIGHT
            7->GradientDrawable.Orientation.TL_BR
            else ->  GradientDrawable.Orientation.LEFT_RIGHT
        }

    }

    fun getDrawable(): Drawable{
        val bg = GradientDrawable()
        bg.orientation = orientation
        if (this.gradientColors.isNotEmpty()){
            bg.colors = this.gradientColors.toIntArray()
        }else{
            var colors = arrayListOf<Int>()
            if (startColor != 0)
                colors.add(startColor)
            if (backgroundColor != 0)
                colors.add(backgroundColor)
            if (endColor != 0)
                colors.add(endColor)
            if (colors.size==1) {
               bg.setColor(colors[0])
            }else{
                bg.colors = colors.toIntArray()
            }
        }
        if (cornerRadius != 0f) {
            bg.cornerRadius = cornerRadius
        } else {
            bg.cornerRadii = floatArrayOf(
                leftTopRadius, leftTopRadius,
                rightTopRadius, rightTopRadius,
                rightBotRadius, rightBotRadius,
                leftBotRadius, leftBotRadius
            )
        }
        bg.setStroke(stroke,strokeColor)
        return bg
    }
}