package com.example.composecontact

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composecontact.data.CallLog
import com.example.composecontact.data.Contact
import com.example.composecontact.data.DataProvider
import com.example.composecontact.ui.ComposeContactTheme

class ContactDetailActivity : AppCompatActivity() {

    companion object {

        private const val CONTACT = "Contact"
        fun newIntent(context: Context, contact: Contact): Intent =
            Intent(context, ContactDetailActivity::class.java).apply {
                putExtra(CONTACT, contact)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeContactTheme {
                ContactDetailScreen(intent.getParcelableExtra(CONTACT)!!) {
                    finish()
                }
            }
        }
    }
}

@Composable
fun ContactDetailScreen(contact: Contact, onBack: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Contact Detail", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onBack()
                    }) {
                        Icon(Icons.Filled.ArrowBack)
                    }
                }
            )
        },
        bodyContent = {
            ContactDetailContent(contact = contact, modifier = Modifier.padding(16.dp))
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = vectorResource(id = R.drawable.ic_baseline_edit_24))
            }
        }
    )
}

@Composable
fun ContactDetailContent(contact: Contact, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            bitmap = imageResource(id = contact.profile),
            modifier = Modifier
                .preferredWidth(150.dp)
                .preferredHeight(150.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.preferredHeight(8.dp))
        Text(
            text = contact.name,
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
        )
        Text(text = contact.phNo)

        Spacer(modifier = Modifier.preferredHeight(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(MaterialTheme.colors.secondary, CircleShape),
            ) {

                Icon(
                    imageVector = vectorResource(id = R.drawable.ic_videocam_24),
                    tint = MaterialTheme.colors.surface
                )

            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.background(MaterialTheme.colors.secondary, CircleShape)
            ) {
                Icon(
                    imageVector = vectorResource(id = R.drawable.ic_call_24),
                    tint = MaterialTheme.colors.surface
                )
            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.background(MaterialTheme.colors.secondary, CircleShape)
            ) {
                Icon(
                    imageVector = vectorResource(id = R.drawable.ic_sms_24),
                    tint = MaterialTheme.colors.surface
                )
            }
        }

        Spacer(modifier = Modifier.preferredHeight(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {

            Text(
                text = "Call History",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "View all",
                style = MaterialTheme.typography.body1
            )

        }

        val callLogs = remember { DataProvider.callLogs }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(
                items = callLogs,
                itemContent = { callLog ->
                    CallLogItem(callLog = callLog)
                }
            )
        }

    }
}

@Composable
fun CallLogItem(callLog: CallLog, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = callLog.callType.typeName,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = callLog.date,
                style = MaterialTheme.typography.body2
            )
        }
        Spacer(modifier = Modifier.preferredHeight(4.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = callLog.phoneNo,
                style = MaterialTheme.typography.body2
            )
        }
    }
}
