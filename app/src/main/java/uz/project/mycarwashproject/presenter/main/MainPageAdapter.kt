package uz.project.mycarwashproject.presenter.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.project.mycarwashproject.presenter.main.pages.main.MainPage
import uz.project.mycarwashproject.presenter.main.pages.about.AboutPage
import uz.project.mycarwashproject.presenter.main.pages.queue.QueuePage
import uz.project.mycarwashproject.presenter.main.pages.history.HistoryPage
import uz.project.mycarwashproject.presenter.main.pages.profile.ProfilePage

class MainPageAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainPage()
            1 -> HistoryPage()
            2 -> QueuePage()
            3 -> AboutPage()
            else -> ProfilePage()
        }
    }


}