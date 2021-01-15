package model

import Adapter.StudentAdapter
import FRagment.ViewFragment

val listStudent: ArrayList<Students> =  ArrayList()
val adapter = StudentAdapter(listStudent, ViewFragment())

fun add(){ listStudent.add(Students("Bhumika Lama",
    21,
    "Female",
    "Swoyambhu",
    "https://www.pngitem.com/pimgs/m/110-1104775_user-woman-business-woman-png-icon-transparent-png.png"))
    listStudent.add(Students(
        "Prayash Shrestha",
        25,"Male",
        "Koteswor",
        "https://cdn.onlinewebfonts.com/svg/img_504768.png"))
    listStudent.add(Students("Lorelai Gilmore",
        26,
        "female",
        "Stars Hollow",
        "https://www.pngitem.com/pimgs/m/110-1104775_user-woman-business-woman-png-icon-transparent-png.png"))}

