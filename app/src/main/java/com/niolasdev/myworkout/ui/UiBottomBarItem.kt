package com.niolasdev.myworkout.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.niolasdev.myworkout.R

sealed class UiBottomBarItem(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
) {

    data object Home : UiBottomBarItem(
        route = "home",
        title = R.string.home,
        icon = R.drawable.ic_workout,
    )

    data object Exercises : UiBottomBarItem(
        route = "exercises",
        title = R.string.exercises,
        icon = R.drawable.ic_lift,
    )

    data object Progress : UiBottomBarItem(
        route = "progress",
        title = R.string.progress,
        icon = R.drawable.ic_progress,
    )

    data object Settings : UiBottomBarItem(
        route = "settings",
        title = R.string.settings,
        icon = R.drawable.ic_settings
    )
}