# Quote Generator

A simple Kotlin-based Android app that displays random motivational quotes.

## Features

- Displays a random quote from a curated list
- Written in Kotlin
- Easy to extend with more quotes or features

## Project Structure

- `app/src/main/java/com/example/qoutegenerator/data/QuoteRepository.kt`: Contains the repository with a list of quotes and logic to fetch a random quote.
- `app/src/main/java/com/example/qoutegenerator/model/Quote.kt`: Data model for a quote.
- `app/src/main/java/com/example/qoutegenerator/data/network/QuoteApiService.kt`: (Optional) For future network-based quote fetching.

## Getting Started

### Prerequisites

- Android Studio or IntelliJ IDEA
- JDK 8 or higher
- Gradle

### Build & Run

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/qoutegenerator.git
