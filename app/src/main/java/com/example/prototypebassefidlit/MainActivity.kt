package com.example.prototypebassefidlit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prototypebassefidlit.ui.theme.PrototypeBasseFidélitéTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrototypeBasseFidélitéTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    ImagePreview(

                    )
                }
            }
        }
    }
}

@Composable
fun ImagePreview(modifier: Modifier= Modifier) {
    Column (
        modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription= null,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(bottom = 2.dp),
            contentScale = ContentScale.Crop
        )
         Text(
             text= stringResource(R.string.name),
             fontWeight =FontWeight.Bold,
             fontSize = 20.sp,
             modifier =Modifier
                 .padding(bottom =20.dp)
         )

        Text(
            text = stringResource(R.string.title),
            fontSize =20.sp,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Gray
            ),
            modifier = Modifier.padding(bottom = 150.dp)
        )
        ContactInfo(icon = R.drawable.call_24dp_e8eaed_fill0_wght400_grad0_opsz24, contactText = stringResource(R.string.number))
        ContactInfo(icon = R.drawable.mail_24dp_e8eaed_fill0_wght400_grad0_opsz24, contactText = stringResource(R.string.mail))
        ContactInfo(icon = R.drawable.whatsapp, contactText = stringResource(R.string.whatsap))
    }

}

@Composable
fun ContactInfo(icon :Int , contactText:String){
    Row(
        modifier = Modifier
            .width(200.dp)
            //.align(Alignment.CenterVertically)
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

        ) {
        // Icône pour l'information
        Image(
            painter = painterResource(id =icon),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        // Texte de contact
        Text(text = contactText, style = MaterialTheme.typography.bodyMedium)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrototypeBasseFidélitéTheme {
        ImagePreview()
    }
}