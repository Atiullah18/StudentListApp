# StudentListApp

## Experiment No. 7

### Title
**Creating an Adaptive Android Application with ListView and ImageView**

---

## Aim

To create an Android application using ListView and ImageView to display registered student details along with their corresponding images.

---

## Requirements

- Android Studio
- Kotlin
- XML
- Android Device / Emulator
- ListView
- ImageView
- BaseAdapter
- SharedPreferences

---

## Introduction

StudentListApp is an Android application developed using Kotlin and XML. It allows users to register students by entering their Name, Roll Number, and Course.

The student details are stored locally using SharedPreferences and displayed using a ListView. ImageView is used to display student images beside each student record.

---

## Concept / Technology Used

### ListView
ListView is an Android UI component used to display multiple items in a vertically scrollable list.

### ImageView
ImageView is used to display images in the Android application.

### BaseAdapter
BaseAdapter connects the student data with the ListView and displays each student as an individual list item.

### SharedPreferences
SharedPreferences is used to store student information locally on the device.

### Kotlin
Kotlin is used as the programming language for developing the Android application.

### XML
XML is used to design the user interface of the Android application.

---

## Scenario

A college wants a simple Android application to register and display student details.

The user enters:

- Student Name
- Roll Number
- Course

After clicking the **SAVE** button, the student details are stored using SharedPreferences.

By clicking the **VIEW ALL** button, all registered students are displayed using ListView.

Each student record contains:

- Student Image
- Student Name
- Roll Number
- Course

Three student images are used and automatically repeated for additional student records.

---

## Features

- Student Registration
- Name input
- Roll Number input
- Course input
- Save student details
- View all registered students
- ListView implementation
- ImageView implementation
- Multiple student records
- Repeated student images
- Clear registration form
- Clear all registered students
- Local data storage using SharedPreferences

---

## Application Flow

```text
Student Registration
        ↓
Enter Name, Roll No and Course
        ↓
       SAVE
        ↓
Store Data using SharedPreferences
        ↓
     VIEW ALL
        ↓
Registered Students
        ↓
ListView + ImageView
        ↓
Student Image + Name + Roll No + Course


StudentListApp/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/studentlistapp/
│           │       ├── MainActivity.kt
│           │       └── StudentListActivity.kt
│           │
│           ├── res/
│           │   ├── drawable/
│           │   │   ├── student1.png
│           │   │   ├── student2.png
│           │   │   ├── student3.png
│           │   │   ├── student_registration.png
│           │   │   └── student_icon.xml
│           │   │
│           │   └── layout/
│           │       ├── activity_main.xml
│           │       ├── activity_student_list.xml
│           │       └── student_item.xml
│           │
│           └── AndroidManifest.xml
│
├── Screenshots/
│   ├── 01_Student_Registration_Screen.png
│   ├── 02_Registered_Students_Screen.png
│   ├── 03_MainActivity_Code.png
│   └── 04_StudentListActivity_Code.png
│
├── .gitignore
├── build.gradle.kts
├── gradle.properties
├── settings.gradle.kts
└── README.md
