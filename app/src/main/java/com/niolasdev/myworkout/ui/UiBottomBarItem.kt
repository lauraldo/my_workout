package com.niolasdev.myworkout.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.niolasdev.myworkout.R
import kotlinx.serialization.Serializable

@Serializable
sealed class UiBottomBarItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
) {

    @Serializable
    data object Home : UiBottomBarItem(
        title = R.string.home,
        icon = R.drawable.ic_workout,
    )

    @Serializable
    data object Exercises : UiBottomBarItem(
        title = R.string.exercises,
        icon = R.drawable.ic_lift,
    )

    @Serializable
    data object Progress : UiBottomBarItem(
        title = R.string.progress,
        icon = R.drawable.ic_progress,
    )

    @Serializable
    data object Settings : UiBottomBarItem(
        title = R.string.settings,
        icon = R.drawable.ic_settings
    )
}