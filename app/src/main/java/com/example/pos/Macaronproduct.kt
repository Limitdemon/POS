package com.example.pos

class Macaronproduct(Name: String, Price: Int, ID: Int, Color: String) {

        val name = Name
        var price = Price
        val id = ID
        val color = Color
        var num = 1

        companion object {
            fun MacaronList(): ArrayList<Macaronproduct> {
                val macaron = ArrayList<Macaronproduct>()

                macaron.add(Macaronproduct("Rose Lychee Macaron", 65, 1001, "Pink"))
                macaron.add(Macaronproduct("Macha Macaron", 60, 1002, "Green"))
                macaron.add(Macaronproduct("Blue Macaron", 50, 1003, "Blue"))
                macaron.add(Macaronproduct("Chocolate Mint Macaron", 75, 1004, "Brown and light green"))
                macaron.add(Macaronproduct("Chocolate Macarons", 65, 1005, "Brown"))

                return macaron
            }
        }
    }
