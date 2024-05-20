import React, { createContext, useState, useEffect } from "react";
import axios from 'axios'; // Ensure axios is installed

export const ShopContext = createContext({});

const ShopContextProvider = (props) => {
    const [allProduct, setAllProduct] = useState([]);
    const [cartItems, setCartItems] = useState({});

    useEffect(() => {
        const fetchData = async () => {
            try {
                console.log("Attempting to fetch products...");
                const response = await axios.get('/api/v1/psProject/products');
                console.log("Fetched products:", response.data);
                setAllProduct(response.data);
                setCartItems(getDefaultCart(response.data));
            } catch (error) {
                console.error('Error fetching products:', error);
                console.error('Detailed error:', error.response || error.message);
            }
        };
        fetchData();
    }, []);

    const getDefaultCart = (products) => {
        let cart = {};
        products.forEach(product => {
            cart[product.id] = 0;
        });
        return cart;
    };

    const addToCart = (itemId) => {
        setCartItems((prev) => ({ ...prev, [itemId]: prev[itemId] + 1 }));
    };

    const removeFromCart = (itemId) => {
        setCartItems((prev) => ({ ...prev, [itemId]: prev[itemId] - 1 }));
    };

    const getTotalCartAmount = () => {
        let totalAmount = 0;
        for (const item in cartItems) {
            if (cartItems[item] > 0) {
                let itemInfo = allProduct.find((product) => product.id === Number(item));
                totalAmount += itemInfo.newPrice * cartItems[item];
            }
        }
        return totalAmount;
    };

    const getTotalCartItems = () => {
        let totalItem = 0;
        for (const item in cartItems) {
            if (cartItems[item] > 0) {
                totalItem += cartItems[item];
            }
        }
        return totalItem;
    }

    const contextValue = { allProduct, getTotalCartItems, getTotalCartAmount, cartItems, addToCart, removeFromCart };

    return (
        <ShopContext.Provider value={contextValue}>
            {props.children}
        </ShopContext.Provider>
    );
};

export default ShopContextProvider;
