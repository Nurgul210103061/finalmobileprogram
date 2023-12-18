package com.example.finalappcosmeticsstore.Models

class PopularModel{
    private var catalogImage : Int? = null
    private var catalogName : String = ""
    private var catalogPrice : String = ""

    constructor()
    constructor(catalogImage: Int?, catalogName: String, catalogPrice: String){
        this.catalogImage = catalogImage
        this.catalogName = catalogName
        this.catalogPrice = catalogPrice
    }

     fun getCatalogImage() : Int?{
        return catalogImage
    }

     fun getCatalogName() : String {
        return catalogName
    }

    fun getCatalogPrice() : String?{
        return catalogPrice
    }

     fun setCatalogImage(catalogImage: Int?){
        this.catalogImage = catalogImage
    }
     fun setCatalogName(catalogImage: String?) {
        this.catalogName = catalogName
    }
     fun setCatalogPrice(catalogPrice: String) {
        this.catalogPrice = catalogPrice
    }
}