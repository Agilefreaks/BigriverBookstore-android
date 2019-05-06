package com.example.alexandra.bigriverbookstore

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import com.example.alexandra.bigriverbookstore.CustomAssertions.Companion.hasItemCount
import com.example.alexandra.bigriverbookstore.CustomMatchers.Companion.withItemCount
import org.junit.Rule
import org.junit.Test

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
    fun countBooksWithViewAssertion() {
        onView(withId(R.id.book_list))
            .check(hasItemCount(6))
    }

    @Test
    fun checkIfFirstItemInListExists() {
        // write a test that will check that the first item in the recycler
        // view has a title and a author name
        onView(
            RecyclerViewMatcher(R.id.book_list)
                .atPositionOnView(0, R.id.txtName)
        )
            .check(matches(withText("Paul k")))
            .perform(click())

        onView(
            RecyclerViewMatcher(R.id.book_list)
                .atPositionOnView(0, R.id.txtTitle)
        )
            .check(matches(withText("book t1")))
            .perform(click())
    }
}