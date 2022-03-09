# FitBros App

Fitness app to provide workout options to optimize flow of gym experience.

This app is designed to help users quickly select workouts in a gym or fitness center based on the availability of equipment.

## Getting Started

### Prerequisites

Designed for Android devices with a minimum target API level of 23 (Codename: Marshmallow, Version 6.0).

### Settings

Customizations provided to the user from the menu (3 vertical dots button) at the upper right of the app are:

* Name
* Language
  * English (default)
  * Spanish
* Measurement
  * Imperial (default)
  * Metric

### Runtime Permissions

In order for full functionality, the user will need to accept a request for permission to send a SMS to tech support when the user initiates contact.

## Running the App

### General Workout Categories

The user can select exercises from 4 workout categories:

* Upper Body
* Lower Body
* Core Muscles, and
* Cardio.

These selections are available from the Home screen in a ListView, as well as the side Navigation Drawer. Of note, glutes are included in Core Muscles.

![Image of Home Screen](https://user-images.githubusercontent.com/55886048/157558594-75d29cf4-e1e7-4d8e-9627-447653b40fd1.jpg)
*Figure 1. Home Screen*

![Image of Home Screen](https://user-images.githubusercontent.com/55886048/157558681-a9daf527-0abe-4900-bafe-3a7d234a633f.jpg)
*Figure 2. Navigation Drawer*

### Target Workout

Within each category, the user can select from 3 targets. For example, the category Upper Body provides options for 3 target muscle groups: Bicep, Tricep, and Back.

![Image of Home Screen](https://user-images.githubusercontent.com/55886048/157558758-f5e55a3c-5b19-4709-a9ca-69f93dd8d540.jpg)
*Figure 3. Muscle Groups*

### Exercise options

When a target button is selected, the user is provided with a RecyclerView of exercise options.

![Image of Home Screen](https://user-images.githubusercontent.com/55886048/157558829-3ae0c052-e93e-4aa6-b322-f0ea385a3c52.jpg)
*Figure 4. Exercise Choices*

## Tools & Calculators

The user is provided with 4 tools/intents:

* Set workout alarm
* Tweet your workout
* Find a gym, and
* Fit tips.

A ViewPager provides the user the option to swipe left or right to navigate from these tools to 2 calculators.

### RFM Calculator

The user is provided with a calculator to input height, waist circumference, and gender in order to receive a personalized interpretation of health status according to the **Relative Fat Mass Index** created by [Cedars-Sinai Medical Center](https://www.cedars-sinai.org/blog/relative-fat-mass.html).

This is considered to be a [more accurate measure](https://www.cedars-sinai.org/newsroom/cedars-sinai-investigators-develop-more-accurate-measure-of-body-fat/) of body fat than BMI.

### BMI Calculator

The user is also provided with a calculator to input height and weight in order to receive a personalized interpretation of health status according to the traditional **Body Mass Index**. Interpretation of results was sourced from the [Centers for Disease Control and Prevention](https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/index.html#InterpretedAdults).

## Built With

* Android Studio 3.5
* Adobe Photoshop CC 2019
* GitHub

## Authors

* Hasan Muslemani
* Cordelle Neufeld

## Acknowledgments

This app was built as a final project for Android 2 in the [Mobile Applications Development Program](http://www.stclaircollege.ca/programs/postsec/mobile_app_dev/) at St. Clair College in Windsor, Ontario, Canada. We are appreciative of the support and guidance of Câi Filiault, Professor.

Please refer to the credits in the FitBros app for a full list of additional acknowledgments.
