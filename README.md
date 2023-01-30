# RCLayout 圆角布局,支持边框,渐变色,渐变色方向等
>支持布局
> RcRelativeLayout
> RcLinearLayout
> RcFrameLayout
> RcConstraintLayout
> RcAbsoluteLayout

## 引入
```kotlin
implementation 'com.github.IHoveYou:RCLayout:1.0.0' 
```

## 布局属性
```html
    <!-- 背景色/渐变中间色-->
    <attr name="rc_backgroundColor" format="color" />
    <!-- 统一圆角-->
    <attr name="rc_cornerRadius" format="dimension" />
    <!-- 左上圆角-->
    <attr name="rc_leftTopRadius" format="dimension" />
    <!-- 左下圆角-->
    <attr name="rc_leftBotRadius" format="dimension" />
    <!-- 右上圆角-->
    <attr name="rc_rightTopRadius" format="dimension" />
    <!-- 右下圆角-->
    <attr name="rc_rightBotRadius" format="dimension" />
    <!-- 边框粗细-->
    <attr name="rc_stroke" format="dimension" />
    <!-- 边框颜色-->
    <attr name="rc_strokeColor" format="color" />
    <!--渐变色起始色值 开始和结束需要同时设置 -->
    <attr name="rc_startColor" format="color" />
    <!--渐变色结束色值色值 开始和结束需要同时设置 -->
    <attr name="rc_endColor" format="color" />
    <!--渐变色方向 -->
    <attr name="rc_orientation">
        <enum name="top_bottom" value="0"/>
        <enum name="TR_BL" value="1"/>
        <enum name="RIGHT_LEFT" value="2"/>
        <enum name="BR_TL" value="3"/>
        <enum name="BOTTOM_TOP" value="4"/>
        <enum name="BL_TR" value="5"/>
        <enum name="LEFT_RIGHT" value="6"/>
        <enum name="TL_BR" value="7"/>
    </attr>
```
## 示例
```html
<com.louxiangyu.widget.rclayout.RcConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp"
        android:gravity="center"
        app:rc_startColor="#236B8E"
        app:rc_backgroundColor="@color/white"
        app:rc_cornerRadius="100dp"
        app:rc_stroke="10dp"
        app:rc_strokeColor="@color/black"
        app:rc_orientation="LEFT_RIGHT"
        app:rc_endColor="#FF1CAE"
        tools:context=".MainActivity">

    <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello World!"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

</com.louxiangyu.widget.rclayout.RcConstraintLayout>
```
## 动态修改
> 主要类 RcBuild
```kotlin
    val build=RcConstraintLayout.build //获取控制类
    build.cornerRadius = 20 //修改单条或多条对应属性
    RcConstraintLayout.buile = build //设置属性
```
>RcBuild api
```kotlin
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
```

# RcTextView
## 布局参数  暗色参数不传时 默认与高亮一致
```html
   <declare-styleable name="RcTextView">
    <!--        高亮背景色/渐变色中间色值-->
    <attr name="rc_backgroundColor"  />
    <!--        暗色背景色-->
    <attr name="rc_pressBackgroundColor" format="color" />
    <!--        高亮边框色值 -->
    <attr name="rc_strokeColor"  />
    <!--        暗色框色值-->
    <attr name="rc_pressStrokeColor" format="color" />
    <!--        渐变色起始色值 开始和结束需要同时设置 中间值可设置可不设置-->
    <attr name="rc_startColor"  />
    <!--        渐变色结束色值色值 开始和结束需要同时设置 中间值可设置可不设置-->
    <attr name="rc_endColor"  />
    <!--        高亮边框粗细-->
    <attr name="rc_stroke"  />
    <!--        暗色边框粗细-->
    <attr name="rc_pressStroke" format="dimension" />
    <!--        高亮按钮圆角-->
    <attr name="rc_cornerRadius" />
    <!--        暗色按钮圆角-->
    <attr name="rc_pressCornerRadius" format="dimension" />
    <!--        使用自定义资源文件-->
    <attr name="background" />
    <!--        高亮按钮左上圆角-->
    <attr name="rc_leftTopRadius"  />
    <!--        高亮按钮左下圆角-->
    <attr name="rc_leftBotRadius"  />
    <!--        高亮按钮右上圆角-->
    <attr name="rc_rightTopRadius"  />
    <!--        高亮按钮右下圆角-->
    <attr name="rc_rightBotRadius"  />

    <!--        暗色按钮左上圆角-->
    <attr name="rc_pressLeftTopRadius" format="dimension" />
    <!--        暗色按钮左下圆角-->
    <attr name="rc_pressLeftBotRadius" format="dimension" />
    <!--        暗色按钮右上圆角-->
    <attr name="rc_pressRightTopRadius" format="dimension" />
    <!--        暗色按钮右下圆角-->
    <attr name="rc_pressRightBotRadius" format="dimension" />

</declare-styleable>
```

## 动态修改属性 主要通过Build
```kotlin
 //获取构造类
 val build = RcTextView.build
 //修改需要的参数
 build.backgroundColors = intArrayOf(Color.WHITE,Color.WHITE,Color.BLUE,Color.RED)
 build.stroke = 10  //这边需要将dp转化为px
 //重新设置参数
 RcTextView.build = build
```
```kotlin
 class Build(context: Context?, attrs: AttributeSet?) {
    //高亮背景色/渐变色中间色值  修改不生效 动态设置直接修改 backgroundColors
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

    //开始色值 修改不生效 动态设置直接修改 backgroundColors
    var startColor: Int = 0

    //结束色值 修改不生效 动态设置直接修改 backgroundColors
    var endColor: Int = 0

    //渐变色集合 高亮颜色需要改变修改这个集合 单色传size=1的集合,渐变色可以传多个
    var backgroundColors = intArrayOf()

    //自定义背景资源
    var background: Int = 0
    //高亮圆角
    var leftTopRadius:Float = 0f
    var leftBotRadius:Float = 0f
    var rightTopRadius:Float = 0f
    var rightBotRadius:Float = 0f
    
    //暗色圆角 不设置则和高亮一致
    var pressLeftTopRadius:Float = 0f
    var pressLeftBotRadius:Float = 0f
    var pressRightTopRadius:Float = 0f
    var pressRightBotRadius:Float = 0f
}
```