//package cn.george.mylearn.room.db
//
//import androidx.room.TypeConverter
//import java.util.*
//
///**
// * Created By George
// * Description:
// */
//class Converters {
//    @TypeConverter fun calendarToDatestamp(calendar:Calendar):Long = calendar.timeInMillis
//    @TypeConverter fun datestampToCalendar(value:Long):Calendar = Calendar.getInstance().apply { timeInMillis = value }
//}