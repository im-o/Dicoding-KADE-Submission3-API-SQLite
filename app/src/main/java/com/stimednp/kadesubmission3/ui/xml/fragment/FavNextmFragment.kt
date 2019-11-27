package com.stimednp.kadesubmission3.ui.xml.fragment


import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import com.stimednp.kadesubmission3.R
import kotlinx.android.synthetic.main.fragment_fav_nextm.*

/**
 * A simple [Fragment] subclass.
 */
class FavNextmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_nextm, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val animatorSet: AnimatorSet
        animatorSet = AnimatorInflater.loadAnimator(context, R.animator.loading_animate) as AnimatorSet
        animatorSet.setTarget(img_load)
        animatorSet.start()

        val objAnim: ObjectAnimator = ObjectAnimator.ofInt(progress_fav_nextm,"progress", 0, 500)
        objAnim.setDuration(5000)
        objAnim.interpolator = DecelerateInterpolator()
        objAnim.start()
    }

}
