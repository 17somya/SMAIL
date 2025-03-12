package com.example.smail

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var emails: MutableList<Email>
    private lateinit var adapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
        val loadMoreBtn = findViewById<Button>(R.id.loadMoreBtn)

        // Fetch initial emails
        emails = EmailFetcher.getEmails()

        // Create and set up adapter
        adapter = EmailAdapter(emails)
        emailsRv.adapter = adapter
        emailsRv.layoutManager = LinearLayoutManager(this)

        // Load More Button Click
        loadMoreBtn.setOnClickListener {
            loadMoreEmails()
        }
    }

    private fun loadMoreEmails() {
        val newEmails = EmailFetcher.getNext5Emails()
        if (newEmails.isNotEmpty()) {
            val startPosition = emails.size
            emails.addAll(newEmails)
            adapter.notifyItemRangeInserted(startPosition, newEmails.size)
        }
    }
}
