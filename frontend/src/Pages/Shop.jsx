import React from "react";
import Hero from "../Components/Hero/Hero";
import Popular from "../Components/Popular/Popular";
import Offers from "../Components/Offers/Offers";
import NewOffers from "../Components/NewOffers/NewOffers";
import NewsLetter from "../Components/NewsLetter/NewsLetter";

const Shop = () =>{
    return(
        <div>
            <Hero/>
            <Popular/>
            <Offers/>
            <NewOffers/>
            <NewsLetter/>
        </div>
    )
}

export default Shop