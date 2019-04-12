package com.example.king.mytemplate

import android.app.Fragment
import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.king.mytemplate.di.Injector
import com.example.king.mytemplate.domain.model.MyItem
import com.example.king.mytemplate.ui.main.MainActivity
import com.example.king.mytemplate.ui.main.MainActivityViewModel
import com.example.king.mytemplate.ui.main.fragment.MainFragment
import com.example.king.mytemplate.ui.main.fragment.MainFragmentViewModel
import com.example.king.mytemplate.util.ViewModelTestUtil.combineSupportInjectorEntry
import com.example.king.mytemplate.util.ViewModelTestUtil.createActivityViewModelFactory
import com.example.king.mytemplate.util.ViewModelTestUtil.createFragmentViewModelFactory
import com.example.king.mytemplate.util.ViewModelTestUtil.createTestFrameworkFragmentInjector
import com.example.king.mytemplate.util.ViewModelTestUtil.createTestSupportFragmentInjector
import com.example.king.mytemplate.util.ViewModelTestUtil.createTestSupportFragmentInjectorEntry
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain


class MainActivityTest {

    val uiRule = InjectedActivityTestRule(MainActivity::class.java, Injector) { activity ->

        activity.viewModelFactory = createActivityViewModelFactory(mockViewModel)

        //If there is fragment need to inject, we can use this
        activity.frameworkFragmentInjector = createTestFrameworkFragmentInjector(
            Fragment::class.java)
        activity.supportFragmentInjector = createTestSupportFragmentInjector(
            MainFragment::class.java) {
            it.fragmentViewModelFactory = createFragmentViewModelFactory(mockFragmentViewModel)
            it.activityViewModelFactory = createActivityViewModelFactory(mockViewModel)
        }

        //If the activity have more than one fragment to inject
//        activity.supportFragmentInjector = combineSupportInjectorEntry(
//            createTestSupportFragmentInjectorEntry(MainFragment::class.java, {})
//        )
    }

    @Rule
    @JvmField
    val outerRule = RuleChain.outerRule(InstantTaskExecutorRule()).around(uiRule)

    val mockViewModel: MainActivityViewModel = mock()
    val mockFragmentViewModel: MainFragmentViewModel = mock()


    @Test
    fun testActivity() {
        val testDataList = MutableLiveData<List<MyItem>>().apply {
            value =
                listOf(MyItem("title1"), MyItem("title2"))
        }
        val dataList: LiveData<List<MyItem>> = testDataList
        whenever(mockViewModel.dataList).thenReturn(dataList)
        uiRule.launchActivity(null)

        Thread.sleep(3000)
    }
}