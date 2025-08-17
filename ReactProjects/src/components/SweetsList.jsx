import React from "react";

function SweetsList() {
  // Array of sweets in JSON format
  const sweets = [
    { id: 1, name: "Laddu", price: 55 },
    { id: 2, name: "Jalebi", price: 40 },
    { id: 3, name: "Rasgulla", price: 60 },
    { id: 4, name: "Gulab Jamun", price: 70 }
  ];

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Sweets List</h2>
      {sweets.map((sweet) => (
        <p key={sweet.id}>
          {sweet.name} - Price: ₹{sweet.price}
        </p>
      ))}
    </div>
  );
}

export default SweetsList;
