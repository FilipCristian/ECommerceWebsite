import React, { useContext } from "react";
import "./CSS/ShopCategory.css"; // Assuming this is the correct path
import { ShopContext } from "../Context/ShopContext"; 
import dropdown_icon from "../Components/Assets/dropdown_icon.png";
import Item from "../Components/Item/Item";

const ShopCategory = (props) => {
  const { allProduct } = useContext(ShopContext);

  return (
    <div className="shop-category">
      <div className="shopcategory-indexSort">
        <p>
          <span>Showing 1-12</span> out of {allProduct.length} products
        </p>
        <div className="shopcategoty-sort">
          Sort by <img src={dropdown_icon} alt="Dropdown Icon" />
        </div>
      </div>
      <div className="shopcategory-products">
        {allProduct.map((item, index) => {
          if (props.category === item.category) {
            return (
              <Item
                key={index}
                id={item.id}
                name={item.name}
                image={item.image}
                new_price={item.newPrice}
                old_price={item.oldPrice}
              />
            );
          }
          return null;
        })}
      </div>
      <div className="shopcategory-loadmore">Explore More</div>
    </div>
  );
};

export default ShopCategory;
