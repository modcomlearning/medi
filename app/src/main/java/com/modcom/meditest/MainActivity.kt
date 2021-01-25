package com.modcom.meditest
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class MainActivity: AppCompatActivity() {
    lateinit
    var progerssProgressDialog: ProgressDialog
    var dataList = ArrayList < recyclerresponse > ()
    lateinit
    var recyclerView: RecyclerView
    private
    var myAdapter: DataAdpter ? = null

    lateinit var layoutManager : LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.brandlist)

        myAdapter = DataAdpter(dataList, this)
        recyclerView.adapter = myAdapter

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        progerssProgressDialog = ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()



        getDat1a()
        searchbrandedit.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString())
            }
        })

        addScrollerListener()
    }
    private fun getDat1a() {
        val call: Call < List < recyclerresponse >> = ApiClient.getClient.getPhotos()
        call.enqueue(object: Callback < List < recyclerresponse >> {
            override fun onResponse(call: Call < List < recyclerresponse >> ? , response : Response < List < recyclerresponse >> ? ) {
                progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body() !!)
                recyclerView.adapter!!.notifyDataSetChanged()
            }
            override fun onFailure(call: Call < List < recyclerresponse >> ? , t : Throwable ? ) {
                progerssProgressDialog.dismiss()
            }
        })
    }
    private fun filter(text: String) {
        //new array list that will hold the filtered data
        val filteredNames = ArrayList < recyclerresponse > ()
        //looping through existing elements and adding the element to filtered list
        dataList!!.filterTo(filteredNames) {
            //if the existing elements contains the search input
            it.title.toLowerCase().contains(text.toLowerCase()) || it.url.toLowerCase().contains(text.toLowerCase())
        }
        //calling a method of the adapter class and passing the filtered list
        if (filteredNames != null) {
            myAdapter!!.filterList(filteredNames)
        }
    }


    private var isLoading: Boolean = false
    private fun addScrollerListener()
    {
        //attaches scrollListener with RecyclerView
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener()
        {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int)
            {
                super.onScrolled(recyclerView, dx, dy)
                if (!isLoading)
                {
                    //findLastCompletelyVisibleItemPostition() returns position of last fully visible view.
                    ////It checks, fully visible view is the last one.
                    if ( layoutManager.findLastCompletelyVisibleItemPosition() == dataList.size - 1)
                    {
                        getDat1a()
                        isLoading = true
                    }
                }
            }
        })
    }
}