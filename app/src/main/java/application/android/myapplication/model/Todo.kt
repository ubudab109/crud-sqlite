package application.android.myapplication.model

class Todo(id : Int, title : String, desc : String, date : String){

    var mId : Int = 0;
    var mTitle : String = "";
    var mDesc : String = "";
    var mDate : String = "";

    init {
        mId = id
        mTitle = title
        mDesc = desc
        mDate = date
    }
}