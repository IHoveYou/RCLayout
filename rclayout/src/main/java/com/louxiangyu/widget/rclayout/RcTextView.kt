package com.louxiangyu.widget.rclayout

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import com.louxiangyu.wdiget.rclayout.R

/**
 * 作者 楼翔宇
 * CreateTime 2023/1/2909:49
 */
class RcTextView : androidx.appcompat.widget.AppCompatTextView {
    var build: Build? = Build(null, null)
        set(value) {
            field = value
            initStyles()
        }

    private fun stateListDrawable(): StateListDrawable {
        val bg = StateListDrawable()
        bg.addState(intArrayOf(-android.R.attr.state_enabled), pressBackground)
        bg.addState(intArrayOf(android.R.attr.state_pressed), pressBackground)
        bg.addState(intArrayOf(-android.R.attr.state_pressed), background)
        bg.addState(intArrayOf(android.R.attr.state_enabled), background)
        return bg
    }

    //背景
    private val background by lazy {
        val bg = GradientDrawable()
        bg
    }

    //按下背景
    private val pressBackground by lazy {
        val bg = GradientDrawable()
        bg
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        isClickable = true
        build = Build(context, attrs)
        initStyles()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        isClickable = true
        build = Build(context, attrs)
        initStyles()
    }

    private fun initStyles() {
        if (build == null) return
        val build: Build = build!!
        if (build.background!=0){
            setBackgroundResource(build.background)
            return
        }
        background.setColors(build.backgroundColors)
        if (build.cornerRadius !=0f){
            background.cornerRadius = build.cornerRadius
        }else{
            background.cornerRadii =
                floatArrayOf(build.leftTopRadius,build.leftTopRadius,
                    build.rightTopRadius,build.rightTopRadius,
                    build.rightBotRadius,build.rightBotRadius,
                    build.leftBotRadius,build.leftBotRadius)
        }
        background.setStroke(build.stroke, build.strokeColor)

        pressBackground.setColor(build.pressBackgroundColor)
        if (build.pressCornerRadius !=0f){
            pressBackground.cornerRadius = build.pressCornerRadius
        }else{
            pressBackground.setCornerRadii(floatArrayOf(build.pressLeftTopRadius,build.pressLeftTopRadius,
                build.pressRightTopRadius,build.pressRightTopRadius,
                build.pressRightBotRadius,build.pressRightBotRadius,
                build.pressLeftBotRadius,build.pressLeftBotRadius))
        }
        pressBackground.setStroke(build.pressStroke, build.pressStrokeColor)
        background.orientation =build.orientation
        pressBackground.orientation = build.orientation
        setBackground(stateListDrawable())
    }


    class Build(context: Context?, attrs: AttributeSet?) {
        var  orientation: GradientDrawable.Orientation = GradientDrawable.Orientation.LEFT_RIGHT
        //高亮背景色/渐变色中间色值
        var backgroundColor: Int = Color.BLUE

        //暗背景色
        var pressBackgroundColor: Int = Color.GRAY

        //高亮边框粗细
        var stroke: Int = 0

        //高亮边框颜色
        var strokeColor: Int = Color.WHITE

        //高亮圆角
        var cornerRadius: Float = 0f

        //暗色框粗细
        var pressStroke: Int = 0

        //暗色框色值
        var pressStrokeColor: Int = Color.WHITE

        //暗色框圆角
        var pressCornerRadius: Float = 0f

        //开始色值
        var startColor: Int = 0

        //结束色值
        var endColor: Int = 0

        //渐变色集合 高亮颜色需要改变修改这个集合 单色传size=1的集合,渐变色可以传多个
        var backgroundColors = intArrayOf()

        //自定义背景资源
        var background: Int = 0

        var leftTopRadius:Float = 0f
        var leftBotRadius:Float = 0f
        var rightTopRadius:Float = 0f
        var rightBotRadius:Float = 0f

        var pressLeftTopRadius:Float = 0f
        var pressLeftBotRadius:Float = 0f
        var pressRightTopRadius:Float = 0f
        var pressRightBotRadius:Float = 0f

        init {
            if (context != null && attrs != null) {
                val arrts = context.obtainStyledAttributes(attrs, R.styleable.RcTextView)
                background =   arrts.getResourceId(R.styleable.RcTextView_background, 0)


                cornerRadius =
                    arrts.getDimension(R.styleable.RcTextView_rc_cornerRadius, 0f)
                pressCornerRadius = arrts.getDimension(
                    R.styleable.RcTextView_rc_pressCornerRadius,
                    cornerRadius
                )


                backgroundColor =
                    arrts.getColor(R.styleable.RcTextView_rc_backgroundColor, 0)
                pressBackgroundColor = arrts.getColor(
                    R.styleable.RcTextView_rc_pressBackgroundColor,
                    backgroundColor
                )

                stroke = arrts.getDimension(R.styleable.RcTextView_rc_stroke, 0f).toInt()
                strokeColor = arrts.getColor(R.styleable.RcTextView_rc_strokeColor, 0)

                pressStroke = arrts.getDimension(
                    R.styleable.RcTextView_rc_pressStroke,
                    stroke.toFloat()
                ).toInt()
                pressStrokeColor = arrts.getColor(
                    R.styleable.RcTextView_rc_pressStrokeColor,
                    strokeColor
                )


                leftTopRadius = arrts.getDimension(
                    R.styleable.RcTextView_rc_leftTopRadius,
                    cornerRadius
                )
                leftBotRadius = arrts.getDimension(
                    R.styleable.RcTextView_rc_leftBotRadius,
                    cornerRadius
                )
                rightTopRadius = arrts.getDimension(
                    R.styleable.RcTextView_rc_rightTopRadius,
                    cornerRadius
                )
                rightBotRadius = arrts.getDimension(
                    R.styleable.RcTextView_rc_rightBotRadius,
                    cornerRadius
                )

                pressLeftTopRadius = arrts.getDimension(
                    R.styleable.RcTextView_rc_pressLeftTopRadius,
                    leftTopRadius
                )
                pressLeftBotRadius = arrts.getDimension(
                    R.styleable.RcTextView_rc_pressLeftBotRadius,
                    leftBotRadius
                )
                pressRightTopRadius = arrts.getDimension(
                    R.styleable.RcTextView_rc_pressRightTopRadius,
                    rightTopRadius
                )
                pressRightBotRadius = arrts.getDimension(
                    R.styleable.RcTextView_rc_pressRightBotRadius,
                    rightBotRadius
                )

                startColor = arrts.getColor(R.styleable.RcTextView_rc_startColor, 0)
                endColor = arrts.getColor(R.styleable.RcTextView_rc_endColor, 0)
                backgroundColors = if (startColor == 0 || endColor == 0) {
                    intArrayOf(backgroundColor, backgroundColor)
                } else {
                    if (backgroundColor != 0)
                        intArrayOf(startColor, backgroundColor, endColor)
                    else
                        intArrayOf(startColor, endColor)
                }
                orientation = when(arrts.getInt(R.styleable.RcConstraintLayout_rc_orientation,6)){
                    0->  GradientDrawable.Orientation.TOP_BOTTOM
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

        }

    }


}