import React from "react";

function GroceryList({ items }) {
  // Handle button click
  const handleAddToCart = () => {
    alert("Groceries Added to Cart!");
  };

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Grocery List</h2>
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {items.map((item, index) => (
          <li key={index} style={{ margin: "5px 0", fontSize: "18px" }}>
            {item}
          </li>
        ))}
      </ul>
      <button 
        onClick={handleAddToCart} 
        style={{
          padding: "10px 20px",
          backgroundColor: "green",
          color: "white",
          border: "none",
          borderRadius: "5px",
          cursor: "pointer",
          marginTop: "10px"
        }}
      >
        Add to Cart buttonn
      </button>
    </div>
  );
}

export default GroceryList;
