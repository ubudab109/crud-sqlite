package application.android.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import application.android.myapplication.model.Todo
import application.android.myapplication.presenter.TodoMvp
import application.android.myapplication.presenter.TodoPresenter
import application.android.myapplication.view.DialogTodo

class MainActivity : AppCompatActivity(), TodoMvp.TodoView, SwipeRefreshLayout.OnRefreshListener {
    var adapter: RvAdapter = RvAdapter(ArrayList<Todo>())

    var presenter: TodoPresenter? = null
    var dialog: DialogTodo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}

inner class RvAdapter(lsTodos: MutableList<Todo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var lsTodos: MutableList<Todo> = lsTodos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_list, null, false)
        return RecyclerView.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}
