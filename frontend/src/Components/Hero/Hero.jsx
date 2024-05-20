import React from "react";
import './Hero.css'
import hand_icon from '../Assets/hand_icon.png'
import arrow_icon from '../Assets/arrow.png'
import hero_image from '../Assets/hero_image_3.png'
const Hero = () =>{
    return(
        <div className='hero'>
            <div className="hero-left">
                <div>
                    <div className="hero-hand-icon">
                        <p>Welcome</p>
                        <img src={hand_icon} alt="" />
                    </div>
                        <p>to the world</p>
                        <p>of GAMING</p>
                </div>
                <div className="hero-latest-btn">
                    <div>See our offers</div>
                    <img src={arrow_icon} alt="" />
                </div> 
            </div>
            <div className="hero-right">
                <img src={hero_image} alt=""/> 
            </div>
        </div>
    )
}

export default Hero