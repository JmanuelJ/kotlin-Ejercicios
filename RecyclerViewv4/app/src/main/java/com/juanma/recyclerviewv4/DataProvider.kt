package com.juanma.recyclerviewv4

class DataProvider {
    companion object{
        val data = listOf<DataClass>(
            DataClass(R.drawable.ic_list, "ListView"),
            DataClass(R.drawable.ic_checkbox, "CheckBox"),
            DataClass(R.drawable.ic_image, "ImageView"),
            DataClass(R.drawable.ic_toggle, "Toggle Switch"),
            DataClass(R.drawable.ic_date, "Date Picker"),
            DataClass(R.drawable.ic_rating, "Rating Bar"),
            DataClass(R.drawable.ic_time, "Time Picker"),
            DataClass(R.drawable.ic_text, "Text View"),
            DataClass(R.drawable.ic_edit, "Edit Text"),
            DataClass(R.drawable.ic_camera, "Camera"),
        )
    }
}