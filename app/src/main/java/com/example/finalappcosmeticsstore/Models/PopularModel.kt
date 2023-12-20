package com.example.finalappcosmeticsstore.Models

import android.media.Image

class PopularModel{
    private var catalogImage :Int? = null
    private var catalogName : String = ""
    private var catalogPrice : String = ""
    private var catalogCount : Int = 1

    constructor()
    constructor(catalogImage: Int?, catalogName: String, catalogPrice : String, catalogCount : Int) {
        this.catalogImage = catalogImage
        this.catalogName = catalogName
        this.catalogPrice = catalogPrice
        this.catalogCount = catalogCount
    }

    fun getCatalogCount() : Int {
        return catalogCount
    }

    fun setCatalogCount(catalogCount: Int) {
        this.catalogCount = catalogCount
    }
     fun getCatalogImage() : Int? {
        return catalogImage
    }
     fun getCatalogName() : String{
        return catalogName
    }
     fun getCatalogPrice(): String{
        return catalogPrice
    }

     fun setCatalogImage(catalogImage: Int?){
        this.catalogImage = catalogImage
    }
     fun setCatalogName(catalogName: String) {
        this.catalogName = catalogName
    }

     fun setCatalogPrice(catalogPrice: String) {
        this.catalogPrice = catalogPrice
    }
}