# Customer Info
This app shows list of customer information and validate their phone numbers.

**Prerequisites:** [Java 11](http://www.oracle.com/technetwork/java/javase/downloads) and [Node.js](https://nodejs.org/).

* [Getting Started](#getting-started)
* [Help](#help)

## Getting Started

To install this example application, run the following commands:

git clone https://github.com/JosephineTakla/customerinfo.git
cd customerinfo

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

To run the application:
Open terminal inside backend folder and run command java -jar target/customerInfo.jar

To run the docker file:
Open terminal inside phone-number folder and run those commands 

docker build --tag=customerinfo:latest .

docker run -p8887:8888 customerinfo:latest

Now you can access the app through url http://localhost:8080/

## Help
Please send any questions on email jtakla10@gmail.com if would like to create a support ticket.
