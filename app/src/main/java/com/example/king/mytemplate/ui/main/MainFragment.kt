package com.example.king.mytemplate.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.king.mytemplate.R
import com.example.king.mytemplate.base.BaseFragment
import com.example.king.mytemplate.di.ActivityScoped
import com.example.king.mytemplate.di.ViewModelFactory
import com.example.king.mytemplate.model.MyItem
import com.example.king.mytemplate.util.Lg
import com.example.king.mytemplate.util.withViewModel
import kotlinx.android.synthetic.main.fragment_main.rvData
import kotlinx.android.synthetic.main.fragment_main.swipeRefreshLayout
import javax.inject.Inject

@ActivityScoped
class MainFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        Lg.d("-=-=, onCreateView")

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Lg.d("-=-=, onViewCreated")

        super.onViewCreated(view, savedInstanceState)
        initDataList()

    }

    private fun initDataList() {
        rvData.layoutManager = LinearLayoutManager(this.context)
        withViewModel<MainViewModel>(viewModelFactory) {
            Lg.d("-=-=, initDataList")

            rvData.adapter = DataAdapter(emptyList())
            this.dataList.observe({ this@MainFragment.lifecycle }, {
                Lg.d("-=-=, data updated")
                it?.let {
                    (rvData.adapter as DataAdapter).updateData(it.toList())
                }
                swipeRefreshLayout.isRefreshing = false
            })

            swipeRefreshLayout.setOnRefreshListener {
                this.getList()
            }
            swipeRefreshLayout.isRefreshing = true
            this.getList()
        }
    }

    class DataAdapter(private var data: List<MyItem>) :
            RecyclerView.Adapter<DataAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_main_list,
                    parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = data[position]
            holder.title.text = item.title
            holder.description.text = item.description
        }

        fun updateData(d: List<MyItem>) {
            this.data = d.toMutableList()
            notifyDataSetChanged()
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val title by lazy { itemView.findViewById(R.id.tvTitle) as TextView }
            val description by lazy {
                itemView.findViewById(R.id.tvDescription) as TextView
            }
        }
    }
}