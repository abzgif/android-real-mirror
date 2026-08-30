package com.bytegif.realmirror.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.PhotoLibrary
import androidx.compose.material.icons.rounded.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bytegif.realmirror.R
import com.bytegif.realmirror.ui.theme.AccentCyan
import com.bytegif.realmirror.ui.theme.DarkAccentBg
import com.bytegif.realmirror.ui.theme.DarkAccentCyan
import com.bytegif.realmirror.ui.theme.DarkCardBorder
import com.bytegif.realmirror.ui.theme.DarkCardSurface
import com.bytegif.realmirror.ui.theme.DarkTextMuted
import com.bytegif.realmirror.ui.theme.DarkTextPrimary
import com.bytegif.realmirror.ui.theme.DarkTextSecondary
import com.bytegif.realmirror.ui.theme.DeepBlack
import com.bytegif.realmirror.ui.theme.GlassBorder

/**
 * Permission request screen with flat dark background (no gradient), safe notch margin, and real app icon.
 */
@Composable
fun PermissionScreen(
    onRequestPermissions: () -> Unit,
    onAboutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DeepBlack) // Flat solid dark background color (no gradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(28.dp))

            // App Icon Container
            Box(
                modifier = Modifier
                    .size(104.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(DarkCardSurface)
                    .border(1.dp, DarkCardBorder, RoundedCornerShape(24.dp))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_app_icon),
                    contentDescription = "Real Mirror Icon",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Real Mirror",
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                color = DarkTextPrimary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Permissions Required",
                fontSize = 15.sp,
                color = DarkAccentCyan,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(28.dp))

            // Permission Request Details Card
            Card(
                colors = CardDefaults.cardColors(containerColor = DarkCardSurface),
                border = androidx.compose.foundation.BorderStroke(1.dp, DarkCardBorder),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "To show your true un-reversed reflection and record photos/videos, Real Mirror needs access to:",
                        fontSize = 14.sp,
                        color = DarkTextSecondary,
                        lineHeight = 21.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    DarkPermissionItem(
                        icon = Icons.Rounded.CameraAlt,
                        title = "Camera",
                        subtitle = "Required for live front camera feed"
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    DarkPermissionItem(
                        icon = Icons.Rounded.Mic,
                        title = "Microphone",
                        subtitle = "Required for video audio recording"
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    DarkPermissionItem(
                        icon = Icons.Rounded.PhotoLibrary,
                        title = "Storage",
                        subtitle = "Required for saving photos & videos to gallery"
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Grant Permissions Primary Button
            Button(
                onClick = onRequestPermissions,
                colors = ButtonDefaults.buttonColors(
                    containerColor = AccentCyan,
                    contentColor = DeepBlack
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            ) {
                Text(
                    text = "Grant Permissions",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // About Outlined Button
            OutlinedButton(
                onClick = onAboutClick,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, GlassBorder),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.Info,
                        contentDescription = null,
                        tint = DarkTextSecondary,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "About Real Mirror",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Privacy Guarantee Note
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(DarkAccentBg)
                    .border(1.dp, DarkCardBorder, RoundedCornerShape(14.dp))
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.Shield,
                    contentDescription = null,
                    tint = DarkAccentCyan,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "100% Open Source & Offline. Your data never leaves your device.",
                    fontSize = 12.sp,
                    color = DarkTextSecondary,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 17.sp
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun DarkPermissionItem(
    icon: ImageVector,
    title: String,
    subtitle: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(DarkAccentBg),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = DarkAccentCyan,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Column {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = DarkTextPrimary
            )
            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = DarkTextMuted
            )
        }
    }
}
