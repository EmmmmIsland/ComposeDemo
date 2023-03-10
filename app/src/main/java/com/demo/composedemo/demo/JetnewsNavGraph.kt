/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.demo.composedemo.demo

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetnews.ui.JetnewsDestinations
import com.demo.composedemo.demo.interests.InterestsRoute
import com.demo.composedemo.demo.interests.InterestsViewModel

//import com.example.jetnews.ui.home.HomeRoute
//import com.example.jetnews.ui.home.HomeViewModel
//import com.demo.composedemo.interests.InterestsRoute
//import com.demo.composedemo.interests.InterestsViewModel

@Composable
fun JetnewsNavGraph(
    appContainer: AppContainer,
    isExpandedScreen: Boolean,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    openDrawer: () -> Unit = {},
    startDestination: String = JetnewsDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(JetnewsDestinations.HOME_ROUTE) {
//            val homeViewModel: HomeViewModel = viewModel(
//                factory = HomeViewModel.provideFactory(appContainer.postsRepository)
//            )
//            HomeRoute(
//                homeViewModel = homeViewModel,
//                isExpandedScreen = isExpandedScreen,
//                openDrawer = openDrawer
//            )

            Text(text = "nihao HOME_ROUTE", modifier = Modifier.fillMaxWidth())
        }
        composable(JetnewsDestinations.INTERESTS_ROUTE) {
            val interestsViewModel: InterestsViewModel = viewModel(
                factory = InterestsViewModel.provideFactory(appContainer.interestsRepository)
            )
            InterestsRoute(
                interestsViewModel = interestsViewModel,
                isExpandedScreen = isExpandedScreen,
                openDrawer = openDrawer
            )

//            Text(text = "nihao INTERESTS_ROUTE", modifier = Modifier.fillMaxWidth())
        }
    }
}
