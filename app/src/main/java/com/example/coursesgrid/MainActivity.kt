package com.example.coursesgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coursesgrid.data.DataSource
import com.example.coursesgrid.models.Topic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesApp(courses = DataSource.topics, modifier = Modifier.fillMaxWidth())
            // because data source is a singleton, you cant instantiate. just call it
        }
    }
}

@Composable 
fun CoursesApp(courses: List<Topic>, modifier: Modifier = Modifier){
    Surface {
        LazyColumn {
            items(courses){course ->
                CourseCapsule()


            }
        }
    }
}

@Composable
fun CourseCapsule(){
    Row{
        Text("Image")
        Column{
            Text("Name")
            Text("Count")
        }
    }
}
