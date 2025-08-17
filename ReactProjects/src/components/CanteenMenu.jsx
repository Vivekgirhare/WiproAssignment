import React from "react";
import CanteenItem from "./CanteenItem";

const CanteenMenu = () => {
  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Canteen Name: Campus Food Court</h2>
      <p><strong>Location:</strong> Block A, Ground Floor</p>
      <p><strong>Open Hours:</strong> 8:00 AM - 8:00 PM</p>

      <h3>Canteen Menu</h3>
      <ol style={{ textAlign: "left", display: "inline-block" }}>
        <li>
          Idli - Price: ₹30 - Category: Breakfast - Available: Yes
        </li>
        <li>
          Dosa - Price: ₹50 - Category: Breakfast - Available: Yes
        </li>
        <li>
          Vada - Price: ₹20 - Category: Snack - Available: No
        </li>
        <li>
          Poori - Price: ₹40 - Category: Breakfast - Available: Yes
        </li>
        <li>
          Meals - Price: ₹120 - Category: Lunch - Available: Yes
        </li>
      </ol>
    </div>
  );
};

export default CanteenMenu;
