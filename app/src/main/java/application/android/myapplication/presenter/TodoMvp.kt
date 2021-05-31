package application.android.myapplication.presenter

import application.android.myapplication.model.Todo

class TodoMvp {
    interface TodoView{
        fun setData(ListTodo: List<Todo>)
        fun setEmpty()
        fun setResult(message: String)
        fun onLoad(isLoading : Boolean)
    }

    interface TodoPresenter{
        fun insertData(todo: Todo)
        fun deleteData(id: Int)
        fun updateData(todo: Todo)
        fun getAllData()
    }
}