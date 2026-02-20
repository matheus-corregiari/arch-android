package br.com.arch.toolkit.android.foldable.extension

import android.graphics.Rect
import android.view.View
import androidx.window.layout.DisplayFeature
import androidx.window.layout.FoldingFeature

private fun View.getFeatureBoundsInWindow(displayFeature: DisplayFeature): Rect? {
    val viewLocationInWindow = IntArray(2)
    getLocationInWindow(viewLocationInWindow)

    val viewRect = Rect(
        viewLocationInWindow[0],
        viewLocationInWindow[1],
        viewLocationInWindow[0] + width,
        viewLocationInWindow[1] + height
    )

    viewRect.left += paddingLeft
    viewRect.top += paddingTop
    viewRect.right -= paddingRight
    viewRect.bottom -= paddingBottom

    val featureRectInView = Rect(displayFeature.bounds)
    val intersects = featureRectInView.intersect(viewRect)

    if ((featureRectInView.width() == 0 && featureRectInView.height() == 0) || !intersects) {
        return null
    }

    featureRectInView.offset(-viewLocationInWindow[0], -viewLocationInWindow[1])
    return featureRectInView
}

/**
 * Calculates the fold position relative to the view's dimensions.
 *
 * @param foldingFeature Information about the device's fold.
 * @param orientation The orientation of the fold ([FoldingFeature.Orientation]).
 * @return The position of the fold (distance from the end/bottom edge), or 0 if it doesn't intersect the view.
 */
fun View.getFoldPosition(
    foldingFeature: FoldingFeature,
    orientation: FoldingFeature.Orientation
) = getFeatureBoundsInWindow(foldingFeature)?.let {
    if (orientation == FoldingFeature.Orientation.VERTICAL) width - it.right else height - it.top
} ?: 0
