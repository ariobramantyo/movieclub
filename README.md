<h1 align="center">
  Movie Club
</h1>
<p align="center">
  <a href="http://developer.android.com/index.html"><img alt="Platform" src="https://img.shields.io/badge/platform-Android-green.svg"></a>
  <a href="http://kotlinlang.org"><img alt="Kotlin" src="https://img.shields.io/badge/kotlin-1.4.20-blue.svg"></a>
  <a href="https://developer.android.com/studio/releases/gradle-plugin"><img alt="Gradle" src="https://img.shields.io/badge/gradle-4.1.1-yellow.svg"></a>
</p>

This application is an application that is used to explore films that have been released. The film domain was chosen because films are something that is very close to today's society where there are more and more film streaming platforms nowadays. Plus there is an API that provides services for exploring films such as [TheMovieDatabase](https://www.themoviedb.org/) as used in this project. The first thing that needs to be done before you can use the API is to get an API Key like the following instructions [TheMovieDB](https://developer.themoviedb.org/reference/intro/getting-started). This project was used as a medium for me to learn about several things such as Clean Architecture, Reactive Programming, and Dependency Injection.

## Installation

Clone this repository and import into Android Studio
```
https://github.com/ariobramantyo/movieclub.git
```

## Preview App
<div>
  <img src="https://github.com/ariobramantyo/movieclub/assets/61187315/52e1da54-12ff-473b-9e15-7c4717f964a9" width="240">
  <img src="https://github.com/ariobramantyo/movieclub/assets/61187315/77b9bd3f-1d6b-4e97-89f6-beacdcd9e46d" width="240">
  <img src="https://github.com/ariobramantyo/movieclub/assets/61187315/b7305342-4766-42cd-b244-a8c239e5715a" width="240">
  <img src="https://github.com/ariobramantyo/movieclub/assets/61187315/fbbc04c2-24ca-4493-b8c8-53c327773bc6" width="240">
</div>

## Tech Stack
- Clean Architecture
- Modularization (core module)
- Dynamic Feature (favorite module)
- Clean Architecture (data, domain, presentation)
- Dependency Injection with Koin
- Coroutines Flow
- ViewBinding

## Dependencies
- [Glide](https://github.com/bumptech/glide)
- [AndroidX](https://mvnrepository.com/artifact/androidx)
- [Lifecycle & LiveData](https://developer.android.com/jetpack/androidx/releases/lifecycle)
- [Koin](https://github.com/InsertKoinIO/koin)
- [Retrofit](https://square.github.io/retrofit/)
- [Coroutines Flow](https://developer.android.com/kotlin/flow)
- [Room](https://developer.android.com/training/data-storage/room?gclid=Cj0KCQiA0MD_BRCTARIsADXoopYlw1cozWjwyR-ucLYa-aoqYlZeJmxG34JnhByjApMNwuchOcAzcy0aAgGHEALw_wcB&gclsrc=aw.ds)
