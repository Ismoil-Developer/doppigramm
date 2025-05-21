package uz.mrx.doppigramm.presentation.navigation

import androidx.navigation.NavDirections

typealias Direction = NavDirections

interface Navigator {

    suspend fun navigateTo(direction: Direction)

    suspend fun back()

}