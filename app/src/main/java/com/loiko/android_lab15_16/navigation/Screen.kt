package com.loiko.android_lab15_16.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details/{subjectId}") {
        fun createRoute(subjectId: String) = "details/$subjectId"
    }
    object Profile : Screen("profile")
    object Settings : Screen("settings")
    object Schedule : Screen("schedule")
    object ScheduleDetail : Screen("schedule_detail/{lessonId}") {
        fun createRoute(lessonId: String) = "schedule_detail/$lessonId"
    }
}
