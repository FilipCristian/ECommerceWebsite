import React, { useContext } from "react"
import  { useState } from "react"; 
import './Navbar.css'

import logo from '../Assets/logo_2.png'
import cart_icon from '../Assets/cart_icon.png'
import { Link } from "react-router-dom";
import { ShopContext } from "../../Context/ShopContext"; // Import ShopContext

const Navbar = () => {
    const [menu,setMenu] = useState("shop");
    const { getTotalCartItems } = useContext(ShopContext); // Use ShopContext here

    return (
        <div className='navbar'>
            <div className="nav-logo">
                <img src={logo} alt="" />
                <p>SteamGames</p>
            </div>
            <ul className="nav-menu">
                    <li onClick={()=>{setMenu("shop")}}><Link style={{textDecoration: 'none'}} to='/'>Shop</Link>{menu === "shop"? <hr/>:<></>}</li>
                    <li onClick={()=>{setMenu("devices")}}><Link style={{textDecoration: 'none'}} to='/devices'>Devices</Link>{menu === "devices"? <hr/>:<></>}</li>
                    <li onClick={()=>{setMenu("accesories")}}><Link style={{textDecoration: 'none'}} to = "/accesories">Accesories</Link>{menu === "accesories"? <hr/>:<></>}</li>
                    <li onClick={()=>{setMenu("games")}}><Link style={{textDecoration: 'none'}} to = '/games'>Games</Link>{menu === "games"? <hr/>:<></>}</li>
            </ul>
            <div className="nav-login-cart">
                <Link to ='/login'><button>Login</button></Link>
                <Link to='/cart'><img src={cart_icon} alt="" /></Link>
                <div className="nav-cart-count">{getTotalCartItems()}</div> {/* Call getTotalCartItems as a function */}
            </div>
        </div>
    )
}

export default Navbar
