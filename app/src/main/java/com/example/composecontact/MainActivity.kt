package com.example.composecontact

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecontact.data.Contact
import com.example.composecontact.data.DataProvider
import com.example.composecontact.ui.ComposeContactTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeContactTheme {
                MainScreen()
            }
        }
    }
}



@Composable
fun MainScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Contact List", fontWeight = FontWeight.Bold)
                },
                modifier = Modifier.fillMaxWidth()
            )
        },
        bodyContent = {
            MainContent()
        }
    )
}

@Composable
fun MainContent() {

    val contactList = remember { DataProvider.contactList }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)
    ) {

        items(
            items = contactList,
            itemContent = { contact ->
                ContactItem(contact = contact, modifier = Modifier.padding(4.dp))
            }
        )
    }
}

@Composable
fun ContactItem(contact: Contact, modifier: Modifier = Modifier) {

    val context = AmbientContext.current

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { startDetailActivity(context = context,contact = contact) }),
        elevation = 4.dp
    ) {

        Row(modifier = Modifier.padding(8.dp)) {

            Image(
                bitmap = imageResource(id = contact.profile),
                modifier = Modifier.padding(8.dp)
                    .preferredWidth(50.dp)
                    .preferredHeight(50.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Text(text = contact.name,style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.preferredHeight(4.dp))
                Text(text = contact.phNo,style = MaterialTheme.typography.body2)
            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = vectorResource(id = R.drawable.ic_call_24),
                    tint = MaterialTheme.colors.secondary
                )
            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = vectorResource(id = R.drawable.ic_sms_24),
                    tint = MaterialTheme.colors.secondary
                )
            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    Icons.Default.MoreVert,
                    tint = MaterialTheme.colors.onBackground.copy(alpha = 0.5f)
                )
            }


        }
    }
}

fun startDetailActivity(context : Context, contact : Contact) {
    val intent = ContactDetailActivity.newIntent(context = context,contact = contact)
    context.startActivity(intent)
}


@Preview(showBackground = true)
@Composable
fun PreviewContactItem() {
    val contact = Contact("Cameron King", "09228461977", R.drawable.avatar_1_raster)
    ContactItem(contact = contact)
}