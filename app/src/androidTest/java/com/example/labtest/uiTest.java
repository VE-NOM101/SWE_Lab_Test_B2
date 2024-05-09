package com.example.labtest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class uiTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testInsert() {
        Espresso.onView(withId(R.id.title))
                .perform(ViewActions.typeText("t"));


        Espresso.onView(withId(R.id.author))
                .perform(ViewActions.typeText("a"));
        Espresso.onView(withId(R.id.genre))
                .perform(ViewActions.typeText("mystery"));
        Espresso.onView(withId(R.id.units))
                .perform(ViewActions.typeText("10"));

        // Click submit button
        onView(withId(R.id.add_book))
                .perform(ViewActions.click());


        try {
            Thread.sleep(5000); // Adjust the delay time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Espresso.onView(ViewMatchers.withId(R.id.display))
                .check(ViewAssertions.matches(ViewMatchers.withText("t a mystery 10")));
    }


}
