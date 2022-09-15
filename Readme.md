VerseStockApp
=====  

VerseStockApp is an Android application that shows a list of stock symbols and prices for a set of  
stocks parsed from the provided JSON endpoints.

Author
------  
Darío Martín-Lara Ortega - @dmartinlara on GitLab email: dariomartinlara@gmail.com

Build
-----  
You can build the app using Android Studio and choosing between different flavours according to the
expected behavior:
> success_response

> error_response

> empty_response

About the exercise
------  
**Time spent**
For this exercise I have spent around 7 hours. 3 hours for architectural design and logic
implementation, 3 for presentation and 1 hour for testing.

**The architectural approach you took and why**
For this exercise I have decided to follow the architecture proposed by Google for the development
of Android applications since it is the one I have been using lately and allows the application to
scale easily and be open to possible modifications.

In this architecture we can find 3 layers:

- **The presentation layer**, where all the components needed to paint the screens are located. As a
  design pattern I have followed **MVVM**, as it facilitates the development and is fully integrated
  into the Android framework.

- **The domain layer**, which houses the data models with which the application will work and the
  different use cases that bring the different functionalities to our app.

- **The data layer**, where all the components needed to retrieve, store or delete the information
  that the app needs are located.

**The trade offs you made and why How to run your project**
In order to simulate the different scenarios, I have decided to create 3 different flavors for each
of the cases.

This way, we have the flavor ***success_response***, which returns a list of stocks whenever there
is a connection and a connection can be established. The flavor ***error_response*** that returns an
error when trying to retrieve the data and the flavor ***empty_response*** that returns an empty
list.

To manage the different types of response I have modeled a Kotlin sealed class that allows to
control these 3 types of scenarios.

These 3 behaviors can be executed by selecting the corresponding buildType from Android Studio.

**3rd party libraries or copied code you may have used**
I have used:

- **Retrofit** and **OkHttp** for network connections
- **Jetpack Compose** for views
- **Hilt** for dependency injection
- **JUnit** for tests

**Any other information that you would like us to know**
For testing I have only included tests for the function that paints the stock value and some simple ViewModel
tests. I am not very experienced with testing coroutines so I have reused some code from some
personal projects for this purpose.

I have also added support for DarkTheme using JetpackCompose.