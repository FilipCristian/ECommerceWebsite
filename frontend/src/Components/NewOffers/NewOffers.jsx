import React from "react";
import "./NewOffers.css";
import new_collection from "../Assets/new_collections"; // Corrected import name

const NewOffers = () => {
  return (
    <div className="new-offers">
      <h1>New Offers</h1>
      <hr />
      <div className="collections">
        {" "}
        {}
        {new_collection.map((item, i) => (
          <div key={i}>
            <img src={item.image} alt={item.name} />
            <p>{item.name}</p>
            <p>New Price: ${item.new_price}</p>
            <p>Old Price: ${item.old_price}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default NewOffers;
