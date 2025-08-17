import React, { Component } from "react";
import MenuItem from "./MenuItem";



class Restaurant extends Component {
  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "20px" }}>
        <h2>Restaurant Name: Spice Hub</h2>
        <p><strong>Location:</strong> Block B, First Floor</p>
        <p><strong>Open Hours:</strong> 10:00 AM - 10:00 PM</p>




        <h3>Restaurant Menu</h3>
        <MenuItem name="Paneer Butter Masala" price={150} category="Main Course" available="Available" />
        <MenuItem name="Chicken Biryani" price={200} category="Main Course" available="Available" />
        <MenuItem name="Masala Dosa" price={80} category="Breakfast" available="Available" />
        <MenuItem name="Gulab Jamun" price={40} category="Dessert" available="Not Available" />
        <MenuItem name="Veg Thali" price={120} category="Combo" available="Available" />
      </div>
    );
  }
}

export default Restaurant;
