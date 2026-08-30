package com.bytegif.realmirror.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Dark Glass-morphism & Sleek Dark Theme Palette
val DeepBlack = Color(0xFF050508)
val GlassWhite = Color(0xCCFFFFFF)
val GlassBorder = Color(0x33FFFFFF)
val AccentCyan = Color(0xFF00E5FF)
val AccentPurple = Color(0xFFBB86FC)
val RecordRed = Color(0xFFFF1744)
val RecordRedDim = Color(0x99FF1744)
val SurfaceGlass = Color(0x22FFFFFF)
val OnGlass = Color(0xFFFFFFFF)
val TimerYellow = Color(0xFFFFD600)

// Dark Theme specific tokens for About & Permission screens
val DarkBackgroundTop = Color(0xFF080911)
val DarkBackgroundBottom = Color(0xFF121424)
val DarkCardSurface = Color(0xFF171A2E)
val DarkCardBorder = Color(0x26FFFFFF)
val DarkTextPrimary = Color(0xFFFFFFFF)
val DarkTextSecondary = Color(0xFF94A3B8)
val DarkTextMuted = Color(0xFF64748B)
val DarkAccentCyan = Color(0xFF00E5FF)
val DarkAccentBg = Color(0x1F00E5FF)
val DarkGitHubBg = Color(0xFF1E233A)
val DarkGitHubBorder = Color(0x3DFFFFFF)

private val DarkColorScheme = darkColorScheme(
    primary = AccentCyan,
    secondary = AccentPurple,
    tertiary = RecordRed,
    background = DeepBlack,
    surface = SurfaceGlass,
    onPrimary = DeepBlack,
    onSecondary = DeepBlack,
    onBackground = OnGlass,
    onSurface = OnGlass,
)

@Composable
fun RealMirrorTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
