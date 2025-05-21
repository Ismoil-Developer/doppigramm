package uz.mrx.doppigramm.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.mrx.doppigramm.presentation.navigation.NavigationDispatcher
import uz.mrx.doppigramm.presentation.navigation.NavigationHandler
import uz.mrx.doppigramm.presentation.navigation.Navigator

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun navigator(dispatcher: NavigationDispatcher): Navigator

    @Binds
    fun navigatorHandler(dispatcher: NavigationDispatcher): NavigationHandler

}