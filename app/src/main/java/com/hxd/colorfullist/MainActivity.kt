package com.hxd.colorfullist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rv_main.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(this)
        rv_main.adapter = adapter


        val list = ArrayList<Bean>()
        list.add(Bean(1000, "韩小呆", R.mipmap.cf))
        list.add(Bean(1001, "设置", R.mipmap.dh))
        list.add(Bean(1001, "客服", R.mipmap.dx))
        list.add(Bean(1001, "升级", R.mipmap.qf))
        list.add(Bean(1001, "修改", R.mipmap.ld))
        list.add(Bean(1002, "", R.mipmap.ld, R.mipmap.dx, R.mipmap.cf))
        list.add(Bean(1003, "", R.mipmap.ld))
        list.add(Bean(1002, "", R.mipmap.dh, R.mipmap.lc, R.mipmap.lq))
        list.add(Bean(1002, "", R.mipmap.lc, R.mipmap.lx, R.mipmap.gy))
        list.add(Bean(1002, "", R.mipmap.hl, R.mipmap.hl, R.mipmap.qf))
        list.add(Bean(1003, "", R.mipmap.gy))
        list.add(Bean(1002, "", R.mipmap.cf, R.mipmap.lx, R.mipmap.gy))
        list.add(Bean(1003, "", R.mipmap.ld))
        adapter.setData(list)
        adapter.notifyDataSetChanged()
    }
}