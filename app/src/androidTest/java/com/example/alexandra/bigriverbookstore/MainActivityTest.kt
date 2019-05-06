package com.example.alexandra.bigriverbookstore

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import android.support.test.espresso.assertion.ViewAssertions.matches
import com.example.alexandra.bigriverbookstore.CustomMatchers.Companion.withItemCount

class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    @Test
    fun countBooks() {
        onView(withId(R.id.book_list))
            .check(matches(withItemCount(6)))
    }

    @Test
    fun checkFirstItemInListExists() {
        // write a test that will check that the first item in the recycler
        // view has a title and a author name
    }
}