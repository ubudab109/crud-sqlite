package application.android.myapplication.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import application.android.myapplication.model.Todo

class DbHelper : SQLiteOpenHelper {

    constructor(context : Context) : super(context , "DB", null, 1)

    val TB_TODO : String = "tb_todo";
    val COL_ID : String = "id";
    val COL_TITLE: String = "title";
    var COL_DESC : String = "desc";
    val COL_DATE : String = "date";

    /*
    * Still NULL ON UPGRADE
    * */
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }


    /*
    * Function on create for create table in our database
    * @param db : SQLiteDatabase
    * @param p1 : Int
    * @param p2 : Int
    * */
    override fun onCreate(db: SQLiteDatabase?) {
        var sql : String = "CREATE TABLE $TB_TODO (" +
                "$COL_ID INTEGER PRIMARY KEY AUTO INCREMENT" +
                "$COL_TITLE VARCHAR(40)" +
                "$COL_DESC TEXT" +
                "$COL_DATE VARCHAR(15)" +
                ")";
        db?.execSQL(sql)
    }

    /*
    * Function for insert data
    * @param todo from Todo MODEL
    * Boolean
    * @return db.insert(table, condition, data) cursor
    * */
    fun insertData(todo : Todo) : Boolean{
        val db: SQLiteDatabase = this.writableDatabase;

        var cv = ContentValues()
        cv.put(COL_TITLE, todo.mTitle)
        cv.put(COL_DESC, todo.mDesc)
        cv.put(COL_DATE, todo.mDate)

        return db.insert(TB_TODO, null, cv ) > 0
    }


    /*
    * Function for get all data todo
    * @return array list Todo
    * */
    fun getAllTodo() : List<Todo> {
        var lsTodos : MutableList<Todo> = ArrayList<Todo>()

        val db: SQLiteDatabase = this.readableDatabase;
        var sql: String = "SELECT * FROM $TB_TODO";
        var cursor : Cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do {
                val todo : Todo = Todo(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                )
                lsTodos.add(todo)
            } while (cursor.moveToNext())
        }

        return lsTodos;
    }


    /*
    * Function for update data
    * @param todo from model Todo
    * @return db.update(Table, data, whereClause, OtherWhere) Cursor
    * */
    fun updateData(todo: Todo) : Boolean{
        val db : SQLiteDatabase = this.readableDatabase;

        var cv = ContentValues()
        cv.put(COL_TITLE, todo.mTitle)
        cv.put(COL_DESC, todo.mDesc)
        cv.put(COL_DATE, todo.mDate)

        var id = todo.mId;
        return db.update(TB_TODO, cv, "$COL_ID = $id", null) > 0;
    }

    /*
    * Function for delete data
    * @param Int id
    * @return db.delete(Table, WHereClause, OtherWhere) Cursor
    * */
    fun deleteData(id: Int) : Boolean{
        val db : SQLiteDatabase = this.readableDatabase;

        return db.delete(TB_TODO, "$COL_ID = $id", null) > 0;

    }


}