# weather-api
A Weather API that consumes the Open Weather API using Spring Boot

Test out the weather for Portugal in the following [link](https://weather-rapi.herokuapp.com/weather/?location=Portugal) deployed on [Heroku](https://www.heroku.com)

If you want to test it out locally, you can build the application using the **Docker** guide provided in the **Docker Setup** section

## What does the Weather API offers?
This Weather API was built for users to search for any location and obtain the current weather information, as well as hourly and daily weather information up to 7 days.

All this data is obtained from the [OpenWeather](https://openweathermap.org/api) open source API.

## The application in a nutshell
We can see the application in a very simple way, just as it is demonstrated in the diagram bellow.

<p align="center">
  <img src="https://github.com/ryzenboi98/weather-api/blob/main/structure.png">
</p>

We use use the Spring Boot [RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html) class to make HTTP requests to the [OpenWeather](https://openweathermap.org/api) API for obtaining the weather data. 

Some of the obtained data will be stored in our in-memory H2 Database Engine through the Java Persistance API (JPA).

## API doc
The API has only a simple **GET Request** method which requires a parameter called **location**.

This parameter can take the data in the following formats:

`<location>,<country>`, just `<location>` or simply `<country>`

The **location** has to be the exact name of a village, town or city. 
<br/>
The **country** has to be the exact name of a country.
<br/>
When providing both **location** and **country** strings, make sure  **country** corresponds to the country code (e.g. PT for Portugal).

### Request example
You can test out a simple request using the following method
```http
GET https://weather-rapi.herokuapp.com/weather/?location=Portugal
```
## Docker Setup

This section is a guide for setting up this project locally.

### API key environment

Since we are consuming [OpenWeather](https://openweathermap.org/api) API you will need to setup an **environment variable** for the **OpenWeather API key**.

You can do that by simple register in the [OpenWeather](https://home.openweathermap.org/users/sign_up) web page and check fo the **API Key** in your web site profile.

Then you need to setup that **API Key value** as an **environment variable** with the name `WEATHER_API_KEY`.

### Build with docker-compose

After setting up your **environment variable** simply download the project and extract the project folder to any location in your system.

Open up **Docker Desktop** and wait until it is fully initialized.

Open a terminal and navigate to the project **root folder**.

Execute the command **docker-compose build** and wait until the docker image is built.

Execute the command **docker-compose up** to start the application server.

Test out the application using this [link](http://localhost:8080/weather/?location=Portugal).
