package com.example.gotravel.ui.module.accomodation

import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class AccomodationDetail: ComponentActivity() {

}

@Preview(showBackground = true)
@Composable
fun HotelDetailsScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        ImageSection()
        Box(modifier = Modifier.background(Color.LightGray)){
            Column {
                HotelInfoSection()
                RatingsSection()
                AmenitiesSection()
                CheckInOutSection()
                HotelDescriptionSection()
                PriceSection()
                BookButton()
            }
        }
    }
}

@Composable
fun ImageSection() {
    Box(modifier = Modifier
        .height(200.dp)
        .fillMaxWidth()) {
        Image(painter = painterResource(id = android.R.drawable.ic_dialog_map), contentDescription = null)
    }
}

@Composable
fun HotelInfoSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Khách sạn Pullman Vũng Tàu", style = MaterialTheme.typography.titleLarge)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
            Text(text = "5", style = MaterialTheme.typography.bodyMedium)
        }
        Text(text = "15 Thi Sách, Phường Thắng Tam, Vũng Tàu, Bà Rịa - Vũng Tàu, Việt Nam")
    }
}

@Composable
fun RatingsSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row {
            Text(text = "Xếp hạng và đánh giá", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Xem tất cả", color = Color.Blue)
        }
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(text = "8.6", style = MaterialTheme.typography.displayLarge)
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = "Ấn tượng", style = MaterialTheme.typography.bodyLarge)
                Text(text = "288 lượt đánh giá", style = MaterialTheme.typography.labelSmall)
            }
        }
        RatingTags()
        TopReviewSection()
    }
}

@Composable
fun RatingTags() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        RatingTag("Phòng sạch")
        RatingTag("Nhân viên thân thiện")
        RatingTag("Dịch vụ tốt")
    }
}

@Composable
fun RatingTag(text: String) {
    Surface(shape = RoundedCornerShape(16.dp), border = BorderStroke(1.dp, Color.Gray)) {
        Text(text = text, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun TopReviewSection() {
    Column {
        // Repeat for each review
        ReviewItem("Nguyen V.A.", "Khách sạn mới và đẹp, gần biển lại thuận tiện với nhân viên nhiệt tình và thân thiện.")
        ReviewItem("Tran V.B.", "Khách sạn sạch sẽ, vị trí đắc địa, nhân viên nhiệt tình. Xứng đáng với giá tiền.")
    }
}

@Composable
fun ReviewItem(name: String, review: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = name, style = MaterialTheme.typography.titleMedium)
        Text(text = review, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun AmenitiesSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row {
            Text(text = "Tiện nghi", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Xem tất cả", color = Color.Blue)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            AmenityItem("Nhà hàng")
            AmenityItem("Lễ tân 24h")
            AmenityItem("Hồ bơi")
            AmenityItem("Wifi")
        }
    }
}

@Composable
fun AmenityItem(name: String) {
    Surface(shape = RoundedCornerShape(8.dp), border = BorderStroke(1.dp, Color.Gray)) {
        Text(text = name, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun CheckInOutSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row {
            Text(text = "Giờ nhận phòng / trả phòng", style = MaterialTheme.typography.titleLarge)
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 8.dp)) {
            Column {
                Text(text = "Nhận phòng", style = MaterialTheme.typography.titleMedium)
                Text(text = "15:00 - 03:00", style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(text = "Trả phòng", style = MaterialTheme.typography.titleMedium)
                Text(text = "trước 11:00", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun HotelDescriptionSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Mô tả khách sạn", style = MaterialTheme.typography.titleLarge)
        Text(
            text = "Nằm dọc theo bãi biển Mỹ Khê cát trắng trải dài ...",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(text = "Xem thêm", color = Color.Blue)
    }
}

@Composable
fun PriceSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Giá phòng mỗi đêm từ", style = MaterialTheme.typography.bodyMedium)
        Text(text = "2.000.000đ", style = MaterialTheme.typography.headlineLarge, color = Color.Blue)
        Text(text = "Đã bao gồm thuế", style = MaterialTheme.typography.labelSmall)
    }
}

@Composable
fun BookButton() {
    Button(
        onClick = { /* handle click */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(Color.Blue)
    ) {
        Text(text = "Chọn phòng", color = Color.White)
    }
}
