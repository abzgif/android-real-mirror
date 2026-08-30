package com.bytegif.realmirror.ui.screens

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Camera
import androidx.compose.material.icons.rounded.OfflinePin
import androidx.compose.material.icons.rounded.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bytegif.realmirror.R
import com.bytegif.realmirror.ui.theme.DarkAccentBg
import com.bytegif.realmirror.ui.theme.DarkAccentCyan
import com.bytegif.realmirror.ui.theme.DarkCardBorder
import com.bytegif.realmirror.ui.theme.DarkCardSurface
import com.bytegif.realmirror.ui.theme.DarkGitHubBg
import com.bytegif.realmirror.ui.theme.DarkGitHubBorder
import com.bytegif.realmirror.ui.theme.DarkTextPrimary
import com.bytegif.realmirror.ui.theme.DarkTextSecondary
import com.bytegif.realmirror.ui.theme.DeepBlack
import com.bytegif.realmirror.ui.theme.GlassBorder
import com.bytegif.realmirror.ui.theme.SurfaceGlass

/**
 * About screen with flat dark background (no gradient), spacious top notch padding,
 * flat back button, vertical row-by-row feature chips for full text visibility,
 * and highlighted GitHub button.
 */
@Composable
fun AboutScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    // Dynamically retrieve version name and version code
    val packageInfo = remember(context) {
        try {
            context.packageManager.getPackageInfo(context.packageName, 0)
        } catch (e: Exception) {
            null
        }
    }
    val versionName = packageInfo?.versionName ?: "1.0.0"
    val versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        packageInfo?.longVersionCode ?: 1L
    } else {
        @Suppress("DEPRECATION")
        packageInfo?.versionCode?.toLong() ?: 1L
    }

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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Extra top spacing so top area is completely clear of phone notch/cutout
            Spacer(modifier = Modifier.height(28.dp))

            // ── Top Header Bar (Safe Notch Margin & Flat Back Button) ─────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                contentAlignment = Alignment.Center
            ) {
                // Flat Back Button (Zero shadow, flat dark glass circle)
                Box(
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(SurfaceGlass)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Text(
                    text = "About Real Mirror",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkTextPrimary
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ── App Icon ──────────────────────────────────────────────
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

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Real Mirror",
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                color = DarkTextPrimary
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(DarkAccentBg)
                    .padding(horizontal = 14.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "See yourself as others do",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkAccentCyan
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ── Description & Features Card ───────────────────────────
            Card(
                colors = CardDefaults.cardColors(containerColor = DarkCardSurface),
                border = androidx.compose.foundation.BorderStroke(1.dp, DarkCardBorder),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Real Mirror is a clean, 100% offline, privacy-focused application designed to give you your true, un-flipped image in real time.",
                        fontSize = 14.sp,
                        color = DarkTextSecondary,
                        textAlign = TextAlign.Center,
                        lineHeight = 22.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // ── Vertical Stacked Feature Rows for 100% Text Visibility ──
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        DarkFeatureRow(
                            icon = Icons.Rounded.OfflinePin,
                            label = "100% Offline Mode"
                        )
                        DarkFeatureRow(
                            icon = Icons.Rounded.Shield,
                            label = "Zero Data Collection & Tracking"
                        )
                        DarkFeatureRow(
                            icon = Icons.Rounded.Camera,
                            label = "HD Real Un-Flipped Camera"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ── App Version Card ──────────────────────────────────────
            Card(
                colors = CardDefaults.cardColors(containerColor = DarkCardSurface),
                border = androidx.compose.foundation.BorderStroke(1.dp, DarkCardBorder),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "App Version",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkTextSecondary
                    )
                    Text(
                        text = "v$versionName ($versionCode)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkAccentCyan
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ── Highlighted "View on GitHub" Button with Logo ─────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(DarkGitHubBg)
                    .border(1.dp, DarkGitHubBorder, RoundedCornerShape(16.dp))
                    .clickable {
                        uriHandler.openUri("https://github.com/abzgif/Android-Real-Mirror")
                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_github),
                        contentDescription = "GitHub Logo",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = "View on GitHub",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                        contentDescription = null,
                        tint = DarkAccentCyan,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ── Back Button ───────────────────────────────────────────
            OutlinedButton(
                onClick = onBack,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, GlassBorder),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = "Back to Mirror",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

/**
 * Vertical feature row component ensuring 100% full text visibility without clipping or truncation.
 */
@Composable
private fun DarkFeatureRow(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(DarkAccentBg)
            .padding(horizontal = 14.dp, vertical = 11.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = DarkAccentCyan,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkAccentCyan
        )
    }
}
