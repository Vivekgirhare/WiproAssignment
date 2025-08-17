import React from "react";

// Child Component (Arrow Function)
const CanteenItem = ({ name, price, category, available }) => {
  return (
    <div style={{ margin: "10px", padding: "10px", border: "1px solid gray", borderRadius: "5px" }}>
      <p><strong>{name}</strong> - Price: ₹{price}</p>
      <p>Category: {category}</p>
      <p>Available: {available}</p>
    </div>
  );
};

export default CanteenItem;
