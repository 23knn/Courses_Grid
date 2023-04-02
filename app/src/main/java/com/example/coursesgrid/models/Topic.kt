package com.example.coursesgrid.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val TopicName: Int,
    val NumberOfCourses: Int,
    @DrawableRes val TopicIcon: Int
)
