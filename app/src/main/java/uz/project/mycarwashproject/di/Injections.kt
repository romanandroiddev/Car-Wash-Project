package uz.project.mycarwashproject.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.project.mycarwashproject.domain.repository.MainRepository
import uz.project.mycarwashproject.domain.repository.MainRepositoryImpl
import uz.project.mycarwashproject.model.local.SharePref
import uz.project.mycarwashproject.presenter.addvehicle.AddVehicleViewModel
import uz.project.mycarwashproject.presenter.main.pages.about.AboutPageViewModel
import uz.project.mycarwashproject.presenter.main.pages.queue.QueuePageViewModel
import uz.project.mycarwashproject.presenter.addvehiclenum.AddVehicleNumViewModel
import uz.project.mycarwashproject.presenter.main.pages.history.HistoryPageViewModel
import uz.project.mycarwashproject.presenter.main.MainViewModel
import uz.project.mycarwashproject.presenter.main.pages.main.MainPageViewModel
import uz.project.mycarwashproject.presenter.main.pages.profile.ProfilePageViewModel
import uz.project.mycarwashproject.presenter.register.signup.SignUpViewModel
import uz.project.mycarwashproject.presenter.selectprice.SelectPriceViewModel
import uz.project.mycarwashproject.presenter.splash.SplashViewModel

val networkModule = module {
    single {
        GsonBuilder().setLenient().create()
    }

    single { FirebaseFirestore.getInstance() }
}

val helperModule = module {
    single { SharePref(androidApplication().applicationContext) }

}

val repositoryModule = module {
    single<MainRepository> { MainRepositoryImpl(get(), get()) }
}


val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { QueuePageViewModel(get()) }
    viewModel { ProfilePageViewModel(get()) }
    viewModel { HistoryPageViewModel(get()) }
    viewModel { AboutPageViewModel(get()) }
    viewModel { AddVehicleNumViewModel(get()) }
    viewModel { AddVehicleViewModel(get()) }
    viewModel { SelectPriceViewModel(get()) }
    viewModel { MainPageViewModel(get()) }
}
