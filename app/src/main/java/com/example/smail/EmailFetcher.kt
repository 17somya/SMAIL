package com.example.smail

class EmailFetcher {
    companion object {
        private val senders = listOf(
            "Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon",
            "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley",
            "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer",
            "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould"
        )
        private val title = "Welcome to Kotlin!"
        private val summary = "Welcome to the Android Kotlin Course! We're excited to have you join us and learn how to develop Android apps using Kotlin."

        fun getEmails(): MutableList<Email> {
            return (0..9).map { i -> Email(senders[i], title, summary) }.toMutableList()
        }

        fun getNext5Emails(): MutableList<Email> {
            return (10..14).map { i -> Email(senders[i], title, summary) }.toMutableList()
        }
    }
}
