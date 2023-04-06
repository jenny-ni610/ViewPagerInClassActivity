package edu.temple.viewpagerinclasssctivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    val viewPager: ViewPager2 by lazy {findViewById(R.id.viewPager2)}
    val button: Button by lazy {findViewById(R.id.button)}
    var numPages = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener() {
            numPages++
            viewPager.adapter?.notifyItemInserted(numPages-1)
            viewPager.setCurrentItem(numPages, true)
        }

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = numPages

            //position = 0 to 9
            override fun createFragment(position: Int) = TextFragment.newInstance((position+1).toString())
        }
    }
}