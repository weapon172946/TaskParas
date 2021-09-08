package com.taskone.utils

import androidx.lifecycle.MutableLiveData
import com.taskone.model.MyListModel

object ListRepo {

    private var list = ArrayList<MyListModel>()
    var observableList = MutableLiveData<ArrayList<MyListModel>>(ArrayList())
    fun populateList() {
        var cricketers = ArrayList<MyListModel.AnswerMcQ>()
        cricketers.add(MyListModel.AnswerMcQ(0, "Sachin"))
        cricketers.add(MyListModel.AnswerMcQ(0, "Virat"))
        cricketers.add(MyListModel.AnswerMcQ(0, "Gale"))
        cricketers.add(MyListModel.AnswerMcQ(0, "Vision"))

        var colors = ArrayList<MyListModel.AnswerMcQ>()
        colors.add(MyListModel.AnswerMcQ(0, "white"))
        colors.add(MyListModel.AnswerMcQ(0, "Yellow"))
        colors.add(MyListModel.AnswerMcQ(0, "Orange"))
        colors.add(MyListModel.AnswerMcQ(0, "Green"))

//        type -> 0 Manual
//        type -> 1 Select One
//        type -> 2 Multiselect
        list.add(MyListModel(0, "What is your name?", 0, "", ArrayList()))
        list.add(MyListModel(1, "Who is the best cricketer in the world?", 1, "", cricketers))
        list.add(MyListModel(1, "What are the colors in the Indian national flag?", 2, "", colors))
    }

    fun getDataList(): ArrayList<MyListModel> {
        return list
    }


}