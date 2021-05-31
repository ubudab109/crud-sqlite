package application.android.myapplication

import android.app.Application
import application.android.myapplication.repository.DbHelper

class TodoApplication : Application(){
    public var db: DbHelper = DbHelper(this)
    override fun onCreate() {
        super.onCreate()
    }
}