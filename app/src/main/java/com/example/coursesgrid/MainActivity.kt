package com.example.coursesgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.coursesgrid.data.DataSource
import com.example.coursesgrid.models.Topic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesApp(topics = DataSource.topics, modifier = Modifier.fillMaxWidth())
            // because data source is a singleton, you cant instantiate. just call it
        }
    }
}

@Composable 
fun CoursesApp(topics: List<Topic>, modifier: Modifier = Modifier){
    var count = 1
    Surface(modifier = modifier){
        LazyColumn(modifier = modifier){
            items(topics){topic ->
                CourseCapsule(topic, modifier = modifier)
                println(count++)
            }
        }
    }
}

@Composable
fun CourseCapsule(topic: Topic, modifier: Modifier = Modifier){
    Row(modifier = modifier){
        Image(
            painter = painterResource(id = topic.TopicIcon),
            contentDescription = "stringResource(id = topic.TopicName)"
        )
        Column(modifier = modifier){
            Text(text = stringResource(id = topic.TopicName))
            Text(text = topic.NumberOfCourses.toString())
        }
    }
}
