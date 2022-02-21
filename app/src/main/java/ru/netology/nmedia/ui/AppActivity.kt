package ru.netology.nmedia.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.R

class AppActivity : AppCompatActivity(R.layout.activity_app) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        //        Далее нам потребуется немного математики, чтобы рисовать «дуги»:
//         25% = 3600 * 0.25 = 900 (угол рисуем с права на лево ( пример -часы с 15 на 12 ))
        val view = findViewById<StatsView>(R.id.stats)
        view.postDelayed({
            view.data = listOf(
                0.25F,
                0.25F,
                0.25F,
                0.25F,
            )
              },
                 3000)
            val label: TextView = findViewById(R.id.label)

            val viewAnim = AnimationUtils.loadAnimation(
                this, R.anim.view_animation
            )


        view.startAnimation(viewAnim)



    //// есть listener'ы, позволяющие подписаться на нужные события:
//        val viewAnim = AnimationUtils.loadAnimation(
//            this, R.anim.view_animation
//        ).apply {
//            setAnimationListener(object : Animation.AnimationListener {
//                override fun onAnimationStart(animation: Animation?) {
//                    label.text = "started"
//                }
//
//                override fun onAnimationEnd(animation: Animation?) {
//                    label.text = "ended"
//                }
//
//                override fun onAnimationRepeat(animation: Animation?) {
//                    label.text = "repeat"
//                }
//
//            })
//        }
//
//        view.startAnimation(viewAnim)

////Класс, позволяющий анимировать property объекта:
//        ObjectAnimator.ofFloat(view, "alpha", 0.25F, 1F).apply {
//            startDelay = 500
//            duration = 300
//            interpolator = BounceInterpolator()
//        }.start()
//
////Класс, позволяющий анимировать property объекта:
//        ObjectAnimator.ofFloat(view, View.ALPHA, 0.25F, 1F).apply {
//            startDelay = 500
//            duration = 300
//            interpolator = BounceInterpolator()
//        }.start()
//
//
//
////В случае, если одним ObjectAnimator'ом нужно анимировать сразу несколько свойств,
// //мы можем использовать PropertyValuesHolder'ы:
////Особенно хорошо это работает с масштабированием (т.к. нет отдельного свойства, есть только SCALE_X и SCALE_Y).
//        val rotation = PropertyValuesHolder.ofFloat(View.ROTATION, 0F, 360F)
//        val alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0F, 1F)
//        ObjectAnimator.ofPropertyValuesHolder(view, rotation, alpha)
//            .apply {
//                startDelay = 500
//                duration = 500
//                interpolator = LinearInterpolator()
//            }.start()
//
//
//
////// для анимирования стандартных свойств View достаточно неудобно, поэтому есть вспомогательный класс ViewPropertyAnimator,
//// позволяющий удобнее задавать анимацию нужных свойств (при этом текущие значения свойств берутся в качестве начальных):
//        view.animate()
//            .rotation(360F)
//            .scaleX(1.2F)
//            .scaleY(1.2F)
//            .setInterpolator(LinearInterpolator())
//            .setStartDelay(500)
//            .setDuration(500)
//            .start()


//////Если у нас есть несколько анимаций, которые мы бы хотели выстроить в определенном порядке (без ручного расчета delay)
//// , то AnimatorSet позволяет нам это сделать:
//        val alpha = ObjectAnimator.ofFloat(view, View.ALPHA, 0.25F, 1F).apply {
//            duration = 300
//            interpolator = LinearInterpolator()
//        }
//        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0F, 1F)
//        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0F, 1F)
//        val scale = ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY).apply {
//            duration = 300
//            interpolator = BounceInterpolator()
//        }


//
////ANIMATORSETКроме того, есть builder'ы, которые позволяют выстраивать цепочки вида:
//        AnimatorSet().apply {
//            startDelay = 500
//            playSequentially(scale, alpha)
//        }.start()
}
}
