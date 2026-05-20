package com.loiko.android_lab15_16.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.loiko.android_lab15_16.ui_model.*

@Composable
fun StudentPlannerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onSubjectClick = { subjectId ->
                    navController.navigate(Screen.Details.createRoute(subjectId))
                },
                onProfileClick = {
                    navController.navigate(Screen.Profile.route)
                },
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                },
                onScheduleClick = {
                    navController.navigate(Screen.Schedule.route)
                }
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("subjectId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val subjectId = backStackEntry.arguments?.getString("subjectId") ?: ""
            DetailsScreen(
                subjectId = subjectId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable(route = Screen.Schedule.route) {
            ScheduleScreen(
                onNavigateBack = { navController.popBackStack() },
                onLessonClick = { lessonId ->
                    navController.navigate(Screen.ScheduleDetail.createRoute(lessonId))
                }
            )
        }
        composable(
            route = Screen.ScheduleDetail.route,
            arguments = listOf(
                navArgument("lessonId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId") ?: ""
            ScheduleDetailScreen(
                lessonId = lessonId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
