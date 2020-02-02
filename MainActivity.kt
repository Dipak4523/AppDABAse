package com.app.simpledatabase

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.simpledatabase.adapter.StudentAdapter
import com.app.simpledatabase.database.AppDabase
import com.app.simpledatabase.database.StudentEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var studentList: ArrayList<StudentEntity>
    lateinit var adapter: StudentAdapter
   lateinit var appDatabase: AppDabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appDatabase = AppDabase.getDatabase(this)
        getAllData()
        tvAdd.setOnClickListener {
            addData()
        }
        //setAdapter()
    }


    private fun setAdapter(list:ArrayList<StudentEntity>) {
        adapter = StudentAdapter(this, list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter=adapter
    }

    private fun getAllData() {
        studentList= arrayListOf()

        class DataAsync: AsyncTask<Void, Void,ArrayList<StudentEntity>>() {

            override fun doInBackground(vararg p0: Void?): ArrayList<StudentEntity> {
                //studentList= arrayListOf()
                //studentList.addAll(appDatabase.studentDAO().getStudentList())
                studentList= appDatabase.studentDAO().getStudentList() as ArrayList<StudentEntity>
                return  studentList
            }

            override fun onPostExecute(result: ArrayList<StudentEntity>?) {
                super.onPostExecute(result)
                Log.e("data",result.toString())
                setAdapter(result!!)
            }
        }

        val dataAsync=DataAsync()
        dataAsync.execute()
    }

    private fun addData(){
        class DataAsync: AsyncTask<Void, Void,String>() {
            override fun doInBackground(vararg p0: Void?):String {

                 val data=StudentEntity()
            data.name="Dipak"
            studentList.add(data)
                appDatabase.studentDAO().insert(data)
            //if(adapter== nullsFirst<>())
                return "daa"
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                Log.e("ad",result);
            }
        }
        val dataAsync=DataAsync()
        dataAsync.execute()
    }


}
