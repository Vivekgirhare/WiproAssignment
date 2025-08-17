import React, { useState } from "react";

const Phone = () => {
  // initial state
  const [price, setPrice] = useState(79999);



  // function to increase price
  const increasePrice = () => {
    setPrice(price + 1000); // increases by 1000 each click
  };

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Phone Details</h2>
      <p><strong>Brand:</strong> Apple</p>
      <p><strong>Model:</strong> iPhone 15</p>
      <p><strong>Price:</strong> ₹{price}</p>



      

      <button 
        onClick={increasePrice} 
        style={{
          padding: "10px 20px",
          backgroundColor: "blue",
          color: "white",
          border: "none",
          borderRadius: "5px",
          cursor: "pointer",
          marginTop: "10px"
        }}
      >
        Increase Price
      </button>
    </div>
  );
};

export default Phone;
