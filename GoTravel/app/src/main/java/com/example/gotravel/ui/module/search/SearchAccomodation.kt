package com.example.gotravel.ui.module.search

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

class SearchAccomodation {

}

@Preview(showBackground = true)
@Composable
fun PreviewSearch(){
    NightSelectionBottomSheet()
}


@Composable
fun SearchCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Điểm đến, khách sạn", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(text = "Vũng Tàu", fontSize = 16.sp, color = Color.Black, modifier = Modifier.padding(bottom = 8.dp))
            Divider()
            Text(text = "Ngày nhận phòng", fontWeight = FontWeight.Bold, fontSize = 14.sp, modifier = Modifier.padding(top = 8.dp))
            Text(text = "Thứ Tư, 02/02/2022", fontSize = 16.sp, color = Color.Black)
            Text(text = "Ngày trả phòng: Thứ Sáu, 04/02/2022", fontSize = 12.sp, color = Color.Gray)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = "Số đêm nghỉ", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(text = "2 đêm", fontSize = 16.sp, color = Color.Black)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = "Số phòng và khách", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(text = "2 phòng, 2 người lớn, 1 trẻ em", fontSize = 16.sp, color = Color.Black)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = "Bộ lọc", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(text = "1.500.000 đ - 2.000.000 đ, 5 sao, Th", fontSize = 16.sp, color = Color.Black)
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text(text = "Tìm kiếm", textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun RecentSearches() {
    Column {
        Text(
            text = "Tra cứu gần đây",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Khách sạn Pullman Vũng Tàu", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                Text(text = "02/02/2022 - 04/02/2022", fontSize = 12.sp, color = Color.Gray)
                Text(text = "2 phòng, 2 người lớn, 1 trẻ em", fontSize = 12.sp, color = Color.Gray)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Vũng Tàu", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                Text(text = "02/02/2022 - 04/02/2022", fontSize = 12.sp, color = Color.Gray)
                Text(text = "2 phòng, 2 người lớn, 1 trẻ em", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomGuestSelectionBottomSheet() {
    val sheetState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetContent = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Chọn số phòng và khách", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))

                // Phòng selection
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Phòng")
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        IconButton(onClick = { /* Handle minus */ }) {
                            Icon(Icons.Default.Delete, contentDescription = "Remove")
                        }
                        Text(text = "1") // Số lượng phòng
                        IconButton(onClick = { /* Handle add */ }) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }
                }

                // Người lớn selection
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Người lớn (Từ 18 tuổi)")
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        IconButton(onClick = { /* Handle minus */ }) {
                            Icon(Icons.Default.Delete, contentDescription = "Remove")
                        }
                        Text(text = "1") // Số lượng người lớn
                        IconButton(onClick = { /* Handle add */ }) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }
                }

                // Trẻ em selection
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Trẻ em (Từ 0 đến 17 tuổi)")
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        IconButton(onClick = { /* Handle minus */ }) {
                            Icon(Icons.Default.Delete, contentDescription = "Remove")
                        }
                        Text(text = "0") // Số lượng trẻ em
                        IconButton(onClick = { /* Handle add */ }) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* Close bottom sheet */ }) {
                    Text(text = "Hoàn tất")
                }
            }
        },
      //  sheetPeekHeight = 0.dp // Ẩn BottomSheet khi không hiển thị
    ) {
        // Nội dung chính của màn hình
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NightSelectionBottomSheet() {
    val sheetState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetContent = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Chọn số đêm nghỉ", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn {
                    items(listOf("1 đêm", "2 đêm", "3 đêm", "4 đêm", "5 đêm", "6 đêm", "7 đêm")) { nightOption ->
                        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                            Text(text = nightOption)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = "Trả phòng: 03/02/2022") // Ngày trả phòng có thể thay đổi
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* Close bottom sheet */ }) {
                    Text(text = "Hoàn tất")
                }
            }
        },
       // sheetPeekHeight = 0.dp // Ẩn BottomSheet khi không hiển thị
    ) {
        // Nội dung chính của màn hình
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerBottomSheet() {
    val sheetState = rememberBottomSheetScaffoldState()
    val selectedDate = remember { mutableStateOf<LocalDate?>(null) }

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetContent = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Chọn ngày nhận phòng", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))

                DatePicker(state = DatePickerState(CalendarLocale(LocalTextStyle.toString())))

                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* Close bottom sheet */ }) {
                    Text(text = "Hoàn tất")
                }
            }
        },
       // sheetPeekHeight = 0.dp // Ẩn BottomSheet khi không hiển thị
    ) {
        // Nội dung chính của màn hình
    }
}

