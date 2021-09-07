package com.taskone.utils

import androidx.lifecycle.MutableLiveData
import com.taskone.model.MyListModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

object ListRepo {

    private var list = ArrayList<MyListModel>()
    var observableList = MutableLiveData<ArrayList<MyListModel>>(ArrayList())
    fun populateList() {
        list.add(MyListModel(0, "A", "01/05/2021"))
        list.add(MyListModel(1, "B", "02/05/2021"))
        list.add(MyListModel(2, "C", "04/05/2021"))
        list.add(MyListModel(3, "D", "03/05/2021"))
        list.add(MyListModel(4, "E", "01/05/2021"))
        list.add(MyListModel(5, "F", "03/05/2021"))
        list.add(MyListModel(6, "G", "02/05/2021"))
        list.add(MyListModel(7, "H", "01/05/2021"))
        list.add(MyListModel(8, "I", "03/05/2021"))
        list.add(MyListModel(9, "J", "02/05/2021"))
    }

    fun getDataList(): ArrayList<MyListModel> {
        return list
    }

    fun getCheckedItems(): ArrayList<MyListModel> {
        var tempList = ArrayList<MyListModel>()
        for (item in list)
            if (item.isSelected)
                tempList.add(item)

        observableList.postValue(tempList)
        return tempList
    }

    fun getAscendingList(): ArrayList<MyListModel> {
        val tempList = getCheckedItems()
        Collections.sort(tempList, byAsc)
        return tempList
    }

    fun getDescendingList(): ArrayList<MyListModel> {
        val tempList = getCheckedItems()
        Collections.sort(tempList, byDsc)
        return tempList
    }


    val byAsc: Comparator<MyListModel> = object : Comparator<MyListModel> {
        var sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        override fun compare(ord1: MyListModel, ord2: MyListModel): Int {

            try {
                var d1 = sdf.parse(ord1.date)
                var d2 = sdf.parse(ord2.date)
                return if (d1.time > d2.time) 1 else -1 //ascending

            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return 1
            //return (d1.getTime() > d2.getTime() ? -1 : 1);     //descending
        }
    }
    val byDsc: Comparator<MyListModel> = object : Comparator<MyListModel> {
        var sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        override fun compare(ord1: MyListModel, ord2: MyListModel): Int {
            try {
                var d1 = sdf.parse(ord1.date)
                var d2 = sdf.parse(ord2.date)
                return if (d1.time > d2.time) -1 else 1 //ascending

            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return -1
        }
    }
}