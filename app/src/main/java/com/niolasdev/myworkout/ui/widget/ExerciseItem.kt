package com.niolasdev.myworkout.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.niolasdev.myworkout.R
import com.niolasdev.myworkout.data.Exercise
import com.niolasdev.myworkout.ui.theme.DefaultTheme
import com.niolasdev.myworkout.ui.theme.Theme

@Composable
fun ExerciseItem(
    exercise: Exercise
) {
    Row {
        AsyncImage(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(12.dp))
                .align(Alignment.CenterVertically),
            model = "file:///android_asset/${exercise.exerciseThumbnail}",
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
        )
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(weight = 1f)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = exercise.exerciseName,
                maxLines = 2,
                color = Theme.colors.textPrimary,
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "${exercise.setsAmount} sets x ${exercise.repRange} reps",
                color = Theme.colors.textSecondary,
            )
        }
        AsyncImage(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically),
            model = "file:///android_asset/${exercise.muscleGroupImage}",
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
        )
    }
}


@Preview
@Composable
fun ExerciseItemPreview() {
    DefaultTheme {
        ExerciseItem(
            Exercise(
                exerciseId = 1,
                exerciseName = "Single Leg Extension",
                exerciseThumbnail = "exc_t_159_ronald.jpg",
                muscleGroup = "Legs",
                muscleGroupImage = "Muscle Groups 1.png",
                setsAmount = 3,
                repRange = "10-12",
                weightAmount = 8.0,
            )
        )
    }
}
