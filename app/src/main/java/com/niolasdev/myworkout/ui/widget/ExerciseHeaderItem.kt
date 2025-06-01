package com.niolasdev.myworkout.ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.niolasdev.myworkout.R
import com.niolasdev.myworkout.data.WorkoutDay
import com.niolasdev.myworkout.ui.theme.Theme

@Composable
fun ExerciseHeaderItem(
    workoutDay: WorkoutDay,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_bolt),
            tint = Theme.colors.tertiary,
            contentDescription = null,
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = "${workoutDay.exerciseCount} Exercises",
            color = Theme.colors.textSecondary,
        )
        Spacer(Modifier.width(8.dp))
        Icon(
            painter = painterResource(R.drawable.ic_clock),
            tint = Theme.colors.tertiary,
            contentDescription = null,
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = "${workoutDay.durationMins} Min",
            color = Theme.colors.textSecondary,
        )
        Spacer(Modifier.width(8.dp))
        Icon(
            painter = painterResource(R.drawable.ic_fire),
            tint = Theme.colors.tertiary,
            contentDescription = null,
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = "${workoutDay.caloriesCount} Cal",
            color = Theme.colors.textSecondary,
        )
    }
}