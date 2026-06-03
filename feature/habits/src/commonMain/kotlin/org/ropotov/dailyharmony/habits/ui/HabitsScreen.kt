package org.ropotov.dailyharmony.habits.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.ropotov.dailyharmony.habits.model.HabitUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitsScreen(
    modifier: Modifier = Modifier
) {

    val habits: List<HabitUi> = listOf(
        HabitUi(
            id = "1",
            title = "Утренняя зарядка",
            description = "10 минут легкой разминки сразу после пробуждения",
            progressDays = 12,
            isDoneToday = false
        ),
        HabitUi(
            id = "2",
            title = "Чтение книги",
            description = "Читать минимум 20 страниц перед сном",
            progressDays = 7,
            isDoneToday = true
        ),
        HabitUi(
            id = "3",
            title = "Пить воду",
            description = "Выпивать не меньше 2 литров воды в день",
            progressDays = 21,
            isDoneToday = false
        )
    )

    val onAddHabitClick: () -> Unit = {}
    val onToggleTodayClick: (String) -> Unit = {}

    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onAddHabitClick,
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = null
                    )
                },
                text = {
                    Text(
                        text = "Добавить",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            )
        }
    ) { innerPadding ->
        if (habits.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Пока нет привычек",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 100.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = habits,
                    key = { it.id }
                ) { habit ->
                    HabitCard(
                        habit = habit,
                        onToggleTodayClick = { onToggleTodayClick(habit.id) }
                    )
                }
            }
        }
    }
}