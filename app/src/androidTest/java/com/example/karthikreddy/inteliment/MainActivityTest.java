package com.example.karthikreddy.inteliment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private Matcher<View> cameraItem = withId(R.id.camera);
    private Matcher<View> musicItem = withId(R.id.music);
    private Matcher<View> actionText = withId(R.id.actionText);
    private Matcher<View> mainRelativeLayout = withId(R.id.mainRelativeLayout);
    private Matcher<View> greenButton = withId(R.id.greenButton);
    private Matcher<View> blueButton = withId(R.id.blueButton);
    private Matcher<View> redButton = withId(R.id.redButton);
    private Matcher<View> fragment = withId(R.id.textView);

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testSelectingItemFromScrollViewPopulatesTextView() {
        onView(cameraItem).perform(click());
        onView(allOf(actionText,  withText("Take a Photo"))).check(matches(isDisplayed()));
    }

    @Test
    public void testScrollAndSelectItemFromScrollViewPopulatesTextView() {
        onView(musicItem).perform(scrollTo(), click());
        onView(allOf(actionText,  withText("Listen Music"))).check(matches(isDisplayed()));
    }

    @Test
    public void testBackgroundColourChangesToGreen() {
        onView(greenButton).perform(click());
        onView(mainRelativeLayout).check(matches(withBackgroundColor(Color.GREEN)));
    }

    @Test
    public void testDefaultBackgroundColour() {
        onView(mainRelativeLayout).check(matches(withBackgroundColor(Color.WHITE)));
    }

    @Test
    public void testBackgroundColourChangeToBlue() {
        onView(blueButton).perform(click());
        onView(mainRelativeLayout).check(matches(withBackgroundColor(Color.BLUE)));
    }

    @Test
    public void testBackgroundColourChangeToRed() {
        onView(redButton).perform(click());
        onView(mainRelativeLayout).check(matches(withBackgroundColor(Color.RED)));
    }

    @Test
    public void testToastMessageDisplaysNameOfClickedFragement() {
        onView(allOf(fragment, withText("Fragment 1"))).perform(click());
        onView(withText("Item Clicked:Fragment 1"))
                .inRoot(RootMatchers.withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    /**
     * This matcher checks if a View displays its background in
     * a specific color.
     *
     * @param color The color to verify.
     * @return Corresponding matcher.
     */
    @NonNull
    private BoundedMatcher<View, View> withBackgroundColor(@ColorInt final int color) {
        return new BoundedMatcher<View, View>(View.class) {
            @Override
            public boolean matchesSafely(View warning) {
                return color == ((ColorDrawable) warning.getBackground()).getColor();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with text color: ");
            }
        };
    }
}
