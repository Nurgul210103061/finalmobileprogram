package com.example.finalappcosmeticsstore.Models

import android.media.Image

class PopularModel{
    private var catalogImage :Int? = null
    private var catalogName : String = ""
    private var catalogPrice : Int = 0
    private var catalogPriceConstant : Int = 0
    private var catalogCount : Int = 1

    constructor()
    constructor(catalogImage: Int?, catalogName: String, catalogPrice : Int,catalogPriceConstant : Int, catalogCount : Int) {
        this.catalogImage = catalogImage
        this.catalogName = catalogName
        this.catalogPrice = catalogPrice
        this.catalogCount = catalogCount
        this.catalogPriceConstant=catalogPriceConstant
    }
    fun getCatalogPriceConstant(): Int{
        return catalogPriceConstant
    }
    fun setCatalogPriceConstant(catalogPriceConstant: Int) {
        this.catalogPriceConstant=catalogPriceConstant
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
     fun getCatalogPrice(): Int{
        return catalogPrice
    }

     fun setCatalogImage(catalogImage: Int?){
        this.catalogImage = catalogImage
    }
     fun setCatalogName(catalogName: String) {
        this.catalogName = catalogName
    }

     fun setCatalogPrice(catalogPrice: Int) {
        this.catalogPrice = catalogPrice
    }
}