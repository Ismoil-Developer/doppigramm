package uz.mrx.doppigramm.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.mrx.doppigramm.presentation.direction.register.RegisterScreenDirection
import uz.mrx.doppigramm.presentation.direction.register.impl.RegisterScreenDirectionImpl
import uz.mrx.doppigramm.presentation.direction.intro.IntroScreenDirection
import uz.mrx.doppigramm.presentation.direction.intro.impl.IntroScreenDirectionImpl
import uz.mrx.doppigramm.presentation.direction.login.LoginScreenDirection
import uz.mrx.doppigramm.presentation.direction.login.impl.LoginScreenDirectionImpl
import uz.mrx.doppigramm.presentation.direction.profile.ProfileScreenFirstDirection
import uz.mrx.doppigramm.presentation.direction.profile.impl.ProfileScreenFirstDirectionImpl
import uz.mrx.doppigramm.presentation.direction.splash.SplashScreenDirection
import uz.mrx.doppigramm.presentation.direction.splash.impl.SplashScreenDirectionImpl

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {

    @[Binds]
    fun bindSplashScreenDirection(impl: SplashScreenDirectionImpl): SplashScreenDirection

    @[Binds]
    fun bindIntroScreenDirection(impl: IntroScreenDirectionImpl): IntroScreenDirection

    @[Binds]
    fun bindConfirmScreenDirection(impl: RegisterScreenDirectionImpl): RegisterScreenDirection

    @[Binds]
    fun bindLoginScreenDirection(impl: LoginScreenDirectionImpl): LoginScreenDirection


    @[Binds]
    fun bindProfileFirstScreenDirection(impl: ProfileScreenFirstDirectionImpl): ProfileScreenFirstDirection

}