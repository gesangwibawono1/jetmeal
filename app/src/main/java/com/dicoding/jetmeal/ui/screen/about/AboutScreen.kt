package com.dicoding.jetmeal.ui.screen.about

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.jetmeal.R
import com.dicoding.jetmeal.ui.components.SectionText
import com.dicoding.jetmeal.ui.theme.JetMealTheme

@Composable
fun AboutScreen() {
    AboutContent(
        modifier = Modifier,
    )
}

@Composable
fun AboutContent(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/gesangwibawono1")) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        TopAppBar(backgroundColor = MaterialTheme.colors.surface) {
            Text(
                text = stringResource(R.string.menu_about),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = modifier.padding(horizontal = 8.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(170.dp)
                    .clip(CircleShape)
            )
            SectionText(
                title = stringResource(R.string.label_name),
                modifier = Modifier.padding(top = 12.dp)
            )
            Card {
                Text(
                    text = stringResource(R.string.name),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                )
            }
            SectionText(
                title = stringResource(R.string.label_email),
                modifier = Modifier.padding(top = 12.dp)
            )
            Card {
                Text(
                    text = stringResource(R.string.email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                )
            }
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 12.dp),
                onClick = { context.startActivity(intent) }
            ) {
                Text(text = stringResource(R.string.btn_github))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AboutContentPreview() {
    JetMealTheme {
        AboutContent(
            modifier = Modifier,
        )
    }
}