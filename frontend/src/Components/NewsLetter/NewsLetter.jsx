import React from "react";
import './NewsLetter.css'; 

const NewsLetter = () =>{
    return(
        <div className="newsLetter"> {/* Corrected class name */}
            <h1>Get Exclusive Offers On Your Email</h1>
            <p>Subscribe to our newsletter and stay updated</p>
            <div>
                <input type="email" placeholder="Your Email id"/> {/* Corrected type attribute */}
                <button>Subscribe</button>
            </div>
        </div>
    )
}

export default NewsLetter;
