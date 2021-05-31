package application.android.myapplication.presenter

import application.android.myapplication.model.Todo
import application.android.myapplication.repository.DbHelper

class TodoPresenter(todoView: TodoMvp.TodoView, db : DbHelper) : TodoMvp.TodoPresenter {

    val mTodoView : TodoMvp.TodoView = todoView;
    val mDb: DbHelper = db;

    override fun insertData(todo: Todo) {
        if(mDb.insertData(todo)){
            mTodoView.setResult("New Data Added")
        }else{
            mTodoView.setResult("Failed Add Data")
        }
    }

    override fun updateData(todo: Todo) {
        if(mDb.updateData(todo)){
            mTodoView.setResult("Data Updated")
        }else{
            mTodoView.setResult("Failed to update data")
        }
    }

    override fun getAllData() {
        val ls : List<Todo> = mDb.getAllTodo()
        mTodoView.onLoad(true)

        if(ls.size > 0) {
            mTodoView.setData(ls)
        }else{
            mTodoView.setEmpty()
        }

        mTodoView.onLoad(false)
    }


    override fun deleteData(id: Int) {
        if(mDb.deleteData(id)){
            mTodoView.setResult("Data Deleted")
            getAllData()
        }else{
            mTodoView.setResult("Failed to delete data")
        }
    }



}