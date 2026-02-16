package com.example.cs501hw3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    var notifications by remember { mutableStateOf(true) }
    var darkMode by remember { mutableStateOf(false) }
    var wifiOnly by remember { mutableStateOf(true) }
    var volume by remember { mutableFloatStateOf(0.8f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Settings",
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = { },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(Icons.Filled.Info, contentDescription = "Info")
            }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column {
                SettingSwitchRow(
                    title = "Notifications",
                    subtitle = "Push notifs to your screen",
                    checked = notifications,
                    onCheckedChange = { notifications = it }
                )
                HorizontalDivider()

                SettingSwitchRow(
                    title = "Dark mode",
                    subtitle = "CS Student Aesthetic",
                    checked = darkMode,
                    onCheckedChange = { darkMode = it }
                )
                HorizontalDivider()

                SettingCheckboxRow(
                    title = "Wi-Fi only",
                    subtitle = "Download only on Wi-Fi",
                    checked = wifiOnly,
                    onCheckedChange = { wifiOnly = it }
                )
                HorizontalDivider()

                SettingSliderRow(
                    title = "Volume",
                    subtitle = "You know this one",
                    value = volume,
                    onValueChange = { volume = it }
                )
                HorizontalDivider()

                SettingButtonRow(
                    title = "Account",
                    subtitle = "Usernames, Passwords etc",
                    buttonText = "Open",
                    onClick = { }
                )
            }
        }
    }
}

@Composable
private fun SettingSwitchRow(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 12.dp)
        ) {
            Text(text = title)
            Text(text = subtitle)
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
private fun SettingCheckboxRow(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!checked) }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 12.dp)
        ) {
            Text(text = title)
            Text(text = subtitle)
        }
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange(it) },
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
private fun SettingSliderRow(
    title: String,
    subtitle: String,
    value: Float,
    onValueChange: (Float) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title)
                Text(text = subtitle)
            }
            Text(
                text = ((value * 100).toInt()).toString(),
                modifier = Modifier
                    .padding(start = 12.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }

        Slider(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun SettingButtonRow(
    title: String,
    subtitle: String,
    buttonText: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 12.dp)
        ) {
            Text(text = title)
            Text(text = subtitle)
        }
        Button(onClick = onClick) {
            Text(buttonText)
        }
    }
}
