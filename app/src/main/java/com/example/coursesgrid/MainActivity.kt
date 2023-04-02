package com.example.coursesgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
    Surface(modifier = modifier){
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier){
            items(topics){topic ->
                CourseCapsule(topic, modifier = modifier)
            }
        }
    }
}

@Composable
fun CourseCapsule(topic: Topic, modifier: Modifier = Modifier){
    Card(elevation = 5.dp, modifier = modifier.padding(10.dp)) {
        Row(modifier = modifier) {
            Box{
                Image(
                    painter = painterResource(id = topic.TopicIcon),
                    contentDescription = stringResource(id = topic.TopicName),
                    modifier = Modifier.size(width = 68.dp, height = 68.dp).aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = modifier) {
                Text(
                    text = stringResource(id = topic.TopicName),
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 12.dp,
                        bottom = 8.dp
                    )
                    )
                Row {
                   Image(
                       painter = painterResource(id = R.drawable.ic_grain),
                       contentDescription = "grain"
                   )
                    Text(text = topic.NumberOfCourses.toString())
                }

            }
        }
    }
}
