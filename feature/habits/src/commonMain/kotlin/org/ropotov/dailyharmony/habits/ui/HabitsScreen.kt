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
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.ropotov.dailyharmony.habits.model.HabitUi
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitsScreen(
    modifier: Modifier = Modifier
) {

    val habits = remember {
        mutableStateListOf(
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
    }

    val onToggleTodayClick: (String) -> Unit = {}

    var showAddSheet by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { showAddSheet = true },
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
        if (showAddSheet) {
            AddHabitBottomSheet(
                sheetState = sheetState,
                onDismiss = {
                    scope.launch {
                        sheetState.hide()
                    }.invokeOnCompletion {
                        showAddSheet = false
                    }
                },
                onAddHabit = { title, description ->
                    habits.add(
                        HabitUi(
                            id = Random.nextLong().toString(),
                            title = title,
                            description = description,
                            progressDays = 0,
                            isDoneToday = false
                        )
                    )

                    scope.launch {
                        sheetState.hide()
                    }.invokeOnCompletion {
                        showAddSheet = false
                    }
                }
            )
        }
    }
}