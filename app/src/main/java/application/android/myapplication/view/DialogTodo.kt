package application.android.myapplication.view

import android.app.Dialog
import android.content.Context
import android.widget.Button
import android.widget.EditText
import application.android.myapplication.R
import application.android.myapplication.model.Todo
import application.android.myapplication.presenter.TodoPresenter

class DialogTodo : Dialog {
    val ctx : Context = context
    val btnSubmit:Button
    val etTitle:EditText
    val etDesc:EditText
    val etDate:EditText
    var mIsEdit:Boolean = false
    var mTodo:Todo? = null

    constructor(context: Context, presenter: TodoPresenter) : super(context){
        setContentView(R.layout.create_dialog)

        btnSubmit = findViewById(R.id.btnSubmit)
        etTitle = findViewById(R.id.etTitle)
        etDesc = findViewById(R.id.etDesc)
        etDate = findViewById(R.id.etDate)

        btnSubmit.setOnClickListener{
            if(etTitle.text.length > 0 && etDesc.text.length > 0) {
                if(!mIsEdit)
                {
                    val todo : Todo = Todo(
                            0,
                            etTitle.text.toString(),
                            etDesc.text.toString(),
                            etDate.text.toString()
                    )
                }else{
                    val todo : Todo = Todo(
                            mTodo!!.mId,
                            etTitle.text.toString(),
                            etDesc.text.toString(),
                            etDate.text.toString()
                    )
                }

                dismiss()
            }
        }
    }

    fun clear()
    {
        etTitle.setText("")
        etDate.setText("")
        etDate.setText("")
    }

    fun showDialog(isEdit : Boolean, todo: Todo?){
        mTodo = todo;

        if(mTodo != null)
        {
            etTitle.setText(todo?.mTitle)
            etDesc.setText(todo?.mDesc)
            etDate.setText(todo?.mDate)
        }else{
            clear()
        }

        mIsEdit = isEdit
        show()
    }

}