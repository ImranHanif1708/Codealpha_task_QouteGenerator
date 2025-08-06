package com.example.qoutegenerator.data

import com.example.qoutegenerator.model.Quote

class QuoteRepository {
    private val quotes = listOf(
        Quote("The only limit to our realization of tomorrow is our doubts of today.", "Franklin D. Roosevelt"),
        Quote("In the middle of every difficulty lies opportunity.", "Albert Einstein"),
        Quote("Success is not final, failure is not fatal: It is the courage to continue that counts.", "Winston Churchill"),
        Quote("Don’t watch the clock; do what it does. Keep going.", "Sam Levenson"),
        Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"),
        Quote("What you get by achieving your goals is not as important as what you become by achieving your goals.", "Zig Ziglar"),
        Quote("Act as if what you do makes a difference. It does.", "William James"),
        Quote("Happiness is not something ready made. It comes from your own actions.", "Dalai Lama"),
        Quote("Do one thing every day that scares you.", "Eleanor Roosevelt"),
        Quote("Hardships often prepare ordinary people for an extraordinary destiny.", "C.S. Lewis"),
        Quote("Success usually comes to those who are too busy to be looking for it.", "Henry David Thoreau"),
        Quote("The best time to plant a tree was 20 years ago. The second-best time is now.", "Chinese Proverb"),
        Quote("You miss 100% of the shots you don’t take.", "Wayne Gretzky"),
        Quote("Dream big and dare to fail.", "Norman Vaughan"),
        Quote("It always seems impossible until it's done.", "Nelson Mandela"),
        Quote("Everything you’ve ever wanted is on the other side of fear.", "George Addair"),
        Quote("Start where you are. Use what you have. Do what you can.", "Arthur Ashe"),
        Quote("Success is how high you bounce when you hit bottom.", "George S. Patton"),
        Quote("Don’t be pushed around by the fears in your mind. Be led by the dreams in your heart.", "Roy T. Bennett"),
        Quote("Great minds discuss ideas; average minds discuss events; small minds discuss people.", "Eleanor Roosevelt")
    )

    fun getRandomQuote(): Quote = quotes.shuffled().first()
}