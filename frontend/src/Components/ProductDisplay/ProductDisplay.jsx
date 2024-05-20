import React, { useContext } from "react";
import "./ProductDisplay.css"; // Ensure CSS file is correctly linked
import star_icon from "../Assets/star_icon.png"; // Star icon for ratings
import star_dull_icon from "../Assets/star_dull_icon.png"; // Dull star icon for ratings
import { ShopContext } from "../../Context/ShopContext"; // Importing context for shop operations

const ProductDisplay = (props) => {
  const { product } = props; // Destructure product from props
  const { addToCart } = useContext(ShopContext); // Using useContext to fetch addToCart function

  return (
    <div className="productdisplay">
      <div className="productdisplay-left">
        <div className="productdisplay-img-list">
          {/* Displaying multiple smaller images; you might want to vary these if available */}
          <img src={product.image} alt={`${product.name} Thumbnail`} />
          <img src={product.image} alt={`${product.name} Thumbnail`} />
          <img src={product.image} alt={`${product.name} Thumbnail`} />
          <img src={product.image} alt={`${product.name} Thumbnail`} />
        </div>
        <div className="productdisplay-img">
          {/* Main product image */}
          <img className="productdisplay-main-img" src={product.image} alt={product.name} />
        </div>
      </div>
      <div className="productdisplay-right">
        <h1>{product.name}</h1>
        <div className="productdisplay-right-star">
          {/* Static star rating; could be made dynamic based on product rating */}
          <img src={star_icon} alt="Star" />
          <img src={star_icon} alt="Star" />
          <img src={star_icon} alt="Star" />
          <img src={star_icon} alt="Star" />
          <img src={star_dull_icon} alt="Dull Star" />
          <p>(122) Reviews</p>
        </div>
        <div className="productdisplay-right-prices">
          {/* Correctly displaying old and new prices */}
          <div className="productdisplay-right-price-old">${product.old_price}</div>
          <div className="productdisplay-right-price-new">${product.new_price}</div>
        </div>
        <div className="productdisplay-right-description">
          {/* Placeholder for product description */}
          DESCRIPTION: {product.description || "No description available."}
        </div>
        <button
          onClick={() => addToCart(product.id)}
        >
          ADD TO CART
        </button>
        <p className="productdisplay-right-category">
          <span>Tags:</span> {product.tags || "Latest, Cheap"} {/* Displaying product tags */}
        </p>
      </div>
    </div>
  );
};

export default ProductDisplay;
