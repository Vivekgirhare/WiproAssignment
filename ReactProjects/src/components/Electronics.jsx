import React, { useState } from "react";

function Electronics() {
  // multiple useState hooks
  const [name] = useState("Laptop");
  const [brand, setBrand] = useState("Dell");
  const [price, setPrice] = useState(55000);

  // function to change brand
  const changeBrand = () => {
    setBrand("HP"); // you can change to any other brand
  };

  // function to increase priceeeee
  const increasePrice = () => {
    setPrice(price + 2000); // increases by 2000 each click
  };

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Electronic Item Details</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>Brand:</strong> {brand}</p>
      <p><strong>Price:</strong> ₹{price}</p>
          

      <button
        onClick={changeBrand}
        style={{
          padding: "10px 15px",
          backgroundColor: "orange",
          color: "white",
          border: "none",
          borderRadius: "5px",
          cursor: "pointer",
          marginRight: "10px"
        }}
      >
        Change Brand
      </button>

      <button
        onClick={increasePrice}
        style={{
          padding: "10px 15px",
          backgroundColor: "purple",
          color: "white",
          border: "none",
          borderRadius: "5px",
          cursor: "pointer"
        }}
      >
        Increase Price
      </button>
    </div>
  );
}

export default Electronics;
