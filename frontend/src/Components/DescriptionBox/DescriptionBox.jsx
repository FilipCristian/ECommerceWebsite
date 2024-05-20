import React from "react";
import './DescriptionBox.css';

const DescriptionBox = () =>{
    return(
        <div className="descriptionbox">
            <div className="descriptionbox-navigator">
                <div className="descriptionbox-nav-box">Description</div>
                <div className="descriptionbox-nav-box fade">Reviews (122)</div>
            </div>
            <div className="descriptionbox-description">
                <p> Welcome to our gaming paradise! Explore our curated collection of top titles, from classics to the latest releases. 
                    Dive into multiplayer battles or solo adventures with ease. Join our vibrant community and discover exclusive deals. 
                    Start your gaming journey now!</p>
                <p>TODO: EVEN MORE TEXT</p>
            </div>
        </div>
    )
}

export default DescriptionBox