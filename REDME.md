# ZTW-Engines-RCLayout 圆角布局,支持边框,渐变色,渐变色方向等
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

