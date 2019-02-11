package com.example.gryus.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    var footballItem: MutableList<ListClub> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = FootballAdapter(footballItem) {
                    startActivity<SecondActivity>(SecondActivity.POSITIONEXTRA to it)
                    val toast = Toast.makeText(context, it.nama, Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }

    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val keterangan = resources.getStringArray(R.array.club_info)

        footballItem.clear()

        for (i in name.indices) {
            footballItem.add(ListClub(name[i], image.getResourceId(i, 0), keterangan[i]))
        }
        Log.e("info", footballItem.size.toString())

        image.recycle()

    }

    class FootballUI : AnkoComponent<ViewGroup> {

        companion object {
            val nameId = 1
            val imageId = 2
        }

        override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
            linearLayout {
                orientation = LinearLayout.HORIZONTAL
                lparams(matchParent, wrapContent)
                padding = dip(16)

                imageView {
                    id = imageId
                    imageResource = R.drawable.img_arsenal

                }.lparams(dip(50), dip(50))

                textView {
                    id = nameId
                    text = "Coba FC"
                }.lparams(matchParent, wrapContent) {
                    margin = dip(10)
                    gravity = Gravity.CENTER_VERTICAL
                }

            }
        }

    }
}