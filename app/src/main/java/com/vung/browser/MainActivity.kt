package com.vung.browser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF0B1020)
private val SurfaceDark = Color(0xFF151D30)
private val Accent = Color(0xFF4D8DFF)
private val Muted = Color(0xFF9AA8C2)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VungApp()
        }
    }
}

private enum class AppTab(val label: String) {
    HOME("Trang chủ"),
    PROFILES("Hồ sơ"),
    CONNECTION("Kết nối"),
    SECURITY("Bảo mật"),
    MORE("Thêm")
}

@Composable
private fun VungApp() {
    var selectedTab by remember { mutableStateOf(AppTab.HOME) }

    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Accent,
            background = Background,
            surface = SurfaceDark,
            onBackground = Color.White,
            onSurface = Color.White
        )
    ) {
        Scaffold(
            containerColor = Background,
            bottomBar = {
                NavigationBar(containerColor = SurfaceDark) {
                    AppTab.values().forEach { tab ->
                        NavigationBarItem(
                            selected = selectedTab == tab,
                            onClick = { selectedTab = tab },
                            icon = {
                                androidx.compose.material3.Icon(
                                    imageVector = when (tab) {
                                        AppTab.HOME -> Icons.Default.Home
                                        AppTab.PROFILES -> Icons.Default.Folder
                                        AppTab.CONNECTION -> Icons.Default.Wifi
                                        AppTab.SECURITY -> Icons.Default.Shield
                                        AppTab.MORE -> Icons.Default.MoreHoriz
                                    },
                                    contentDescription = tab.label
                                )
                            },
                            label = { Text(tab.label, fontSize = 10.sp) }
                        )
                    }
                }
            }
        ) { innerPadding ->
            when (selectedTab) {
                AppTab.HOME -> Dashboard(Modifier.padding(innerPadding))
                AppTab.PROFILES -> PlaceholderScreen(
                    "Quản lý hồ sơ",
                    "Quản lý hồ sơ và lưu trữ riêng sẽ được triển khai ở phiên bản tiếp theo."
                )
                AppTab.CONNECTION -> PlaceholderScreen(
                    "Kết nối",
                    "Màn hình trạng thái kết nối minh bạch sẽ được triển khai ở phiên bản tiếp theo."
                )
                AppTab.SECURITY -> PlaceholderScreen(
                    "Bảo mật",
                    "PIN, sinh trắc học và tự khóa sẽ được triển khai ở phiên bản tiếp theo."
                )
                AppTab.MORE -> PlaceholderScreen(
                    "Thêm",
                    "Cài đặt, nhật ký hoạt động và thông tin ứng dụng."
                )
            }
        }
    }
}

@Composable
private fun Dashboard(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "VÙNG",
                color = Accent,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Browser Manager",
                color = Color.White,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Không gian quản lý trình duyệt",
                color = Muted,
                fontSize = 13.sp
            )
        }
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = SurfaceDark),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "TỔNG QUAN",
                        color = Muted,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Ứng dụng đã khởi tạo",
                        color = Color.White,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Bản nền V0.1. Các chức năng chưa triển khai được ghi rõ, không hiển thị trạng thái giả.",
                        color = Muted,
                        fontSize = 13.sp
                    )
                }
            }
        }
        item { InfoCard("Hồ sơ trình duyệt", "Chưa có hồ sơ nào được tạo.") }
        item { InfoCard("Trạng thái kết nối", "Chưa cấu hình kết nối.") }
        item { InfoCard("Trung tâm bảo mật", "Chưa thiết lập khóa ứng dụng.") }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "LỘ TRÌNH",
                    color = Muted,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("V0.2 · Quản lý hồ sơ và cơ sở dữ liệu", color = Color.White, fontSize = 14.sp)
                Text("V0.3 · Trình duyệt và lưu trữ hồ sơ", color = Color.White, fontSize = 14.sp)
            }
        }
    }
}

@Composable
private fun InfoCard(title: String, detail: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = SurfaceDark),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(title, color = Color.White, fontWeight = FontWeight.SemiBold)
            Text(detail, color = Muted, fontSize = 13.sp)
        }
    }
}

@Composable
private fun PlaceholderScreen(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(title, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Text(description, color = Muted, fontSize = 14.sp)
    }
}
